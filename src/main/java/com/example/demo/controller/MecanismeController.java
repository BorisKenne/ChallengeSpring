package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.classe.Distance;
import com.example.demo.model.Shop;
import com.example.demo.repository.ShopRepository;
import com.example.demo.repository.UserRepository;

@RestController
@Service
@RequestMapping("/mecanisme")
public class MecanismeController {
	@Autowired
	UserRepository userRepositoryMeca;
	
	@Autowired
	ShopRepository shopRepositoryMeca;

//triage des shopping à l'affichage qui prends en parametre les coordonnées de l'utilisateur !
	public ArrayList<Shop> affichageDesShoppings(ArrayList<Shop> shops,double abs,double ord) {
		//calcule des distances associée à chaque shops
		ArrayList<Distance> dists=tableauDistance( shops,abs,ord);
		//triage du tablea obtenu
		dists=trieDistance(dists);
		//obtantion des shop a partir du trie obtenu 
		shops=ShoppingTrie(shops,dists);
		//renvoies des shops
		return shops;
	}
private ArrayList<Distance> tableauDistance(ArrayList<Shop> shops,double abs,double ord){
	int taille=shops.size();
	ArrayList<Distance> distances=new ArrayList<Distance>();
	for (int i=0;i<taille;i++) {
		String idShop=shops.get(i).getId();
		double absShop=shops.get(i).getLocation().abs();
		double ordShop=shops.get(i).getLocation().ord();
		double  distance=Math.sqrt((Math.pow((absShop-abs), 2))+(Math.pow((ordShop-ord), 2)));
		Distance Dist=new Distance(idShop, distance);
		distances.add(Dist);
	}
		return distances;
	}
	private ArrayList<Distance> trieDistance(ArrayList<Distance> dist){
		int longueur = dist.size();
		Distance  tampon ;
		boolean permut;
 
		do {
			// hypothèse : le tableau est trié
			permut = false;
			for (int i = 0; i < longueur-1 ; i++) {
				// Teste si 2 éléments successifs sont dans le bon ordre ou non
				if (dist.get(i).getDistanceShop() > dist.get(i+1).getDistanceShop())
				{
					// s'ils ne le sont pas, on échange leurs positions
					tampon = dist.get(i);
					dist.set(i, dist.get(i+1));
					dist.set(i+1, tampon);
					permut = true;
				}
			}
		} while (permut);
		return dist;
	}
	private ArrayList<Shop> ShoppingTrie(ArrayList<Shop> shops,ArrayList<Distance> dist){
     ArrayList<Shop> shopTris=new ArrayList<Shop>();
     for(int i=0;i<dist.size();i++) {
    	 String id=dist.get(i).getIdShop();
    	 Shop shop=new Shop();
    	// Shop shop=shopRepositoryMeca.findOne(id); 
       for(int j=0;j<dist.size();j++) {
    		 if(shops.get(j).getId().equals(id)) {
    		 shop=shops.get(j); 
    		 shopTris.add(shop);
    		 }
    	 }
     }
		return shopTris;
	}
}
