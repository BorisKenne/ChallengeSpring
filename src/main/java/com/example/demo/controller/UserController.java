package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Retour;
import com.example.demo.model.Shop;
import com.example.demo.model.ShopLink;
import com.example.demo.model.User;
import com.example.demo.repository.ShopRepository;
import com.example.demo.repository.UserRepository;

@RestController
@Service
@RequestMapping("/user")
public class UserController {
public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ShopRepository shopRepository;
	
	// les liens pour gerer 
	String linkNearBy;
	String linkLike;
	
	//create
public void createUser(User user){
		userRepository.save(user);
	}

@RequestMapping("/saveUser")
public String addUser(HttpServletRequest request,ModelMap modelMap) {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		ArrayList<String> shops=new ArrayList<String>();
		User user=new User(id, email, password, name,shops);
		userRepository.save(user);
		return ("/pages/connection");
}
	//read
	@RequestMapping("/{idUser}")
	public User findUserById(@PathVariable("idUser") String id){
		System.out.println("find User by id is going on");
		return userRepository.findOne(id);
		//return user;
	}
	@RequestMapping("/connectionUser/{email}/{password}/{lat}/{lon}/")
	public Retour connectionUser(@PathVariable("email")String email,
			                                  @PathVariable("password")String password,
			                                  @PathVariable("lat")String lat,
			                                  @PathVariable("lon")String lon,
			                                  ModelMap modelMap){

		System.out.println("la lat est de :"+ lat);
		System.out.println("la lon est de :"+ lon);
		Double ord=Double.valueOf(lat);
		System.out.println("la abs est de :"+ ord);
		Double abs=Double.valueOf(lon);
		System.out.println("la ord est de :"+ abs);
		List<User> users=new ArrayList<User>();
		users=userRepository.findAll();
		User finalUser=null;
        for(int i=0;i<users.size();i++)                   
        {
        	User user=users.get(i);
        	if ((user.getEmail().equals(email))&&(user.getPassword().equals(password))){
        		finalUser=user;
        		break;
        	}
        }
        if(finalUser!=null) {
        	modelMap.put("user", finalUser);
        	 linkNearBy="/user/connectionUser?email="+finalUser.getEmail()+"&password="+finalUser.getPassword();
        	modelMap.put("linkNearBy", linkNearBy);
        	 linkLike="/user/likedShops/"+finalUser.getId();
        	modelMap.put("linkLike", linkLike);

        	//trions les shops et envoyons les dans la page de bienvenue
        	MecanismeController mecanisme=new MecanismeController();
        	ArrayList<Shop> shops=new ArrayList<Shop>();
        	shops=(ArrayList<Shop>) shopRepository.findAll();
        	shops=mecanisme.affichageDesShoppings(shops,abs, ord);
        	//crayons un Array des shoppings avec les liens pour les liker !!! 
        	ArrayList<ShopLink> shopLinks=new ArrayList<ShopLink>();
        	for(int i=0;i<shops.size();i++){
        		Shop shop=shops.get(i);
        		String link="/user/addShopInUser/"+finalUser.getId()+"/"+shop.getId();
        		ShopLink shoplink=new ShopLink(shop,link);
        		shopLinks.add(shoplink);
        	}
            modelMap.put("shopLinks", shopLinks);
        	//return "/pages/bienvenue";
          //String userId, String userName, String userEmail, ArrayList<ShopLink> shop
            
    		Retour retour=new Retour(finalUser.getId(),finalUser.getName(), finalUser.getEmail(), shopLinks);
    		System.out.println("le retour est pres apres connection");
    		
        	return retour;
        	}
        else {
        	System.out.println(" ---------------user n'esxiste pas ---------------- ");
			//return "/pages/connection";
        	return null;
        }
	}
	@RequestMapping("/addShopInUser/{idUser}/{idShop}/")
	public Retour addShopInUser(@PathVariable("idUser") String idUser,@PathVariable("idShop") String idShop,ModelMap modelMap){
		User user=userRepository.findOne(idUser);
		ArrayList<String> shops=new ArrayList<String>();
		shops=user.getShops();
		Boolean bool=false;
		for(int i=0;i<shops.size();i++) {
			if (idShop.equals(shops.get(i))){bool=true;}
		}
		if(bool==false) {shops.add(idShop);}
		user.setShops(shops);
		userRepository.save(user);
		Retour retour= printLikedShop(idUser,modelMap);
		//String userId, String userName, String userEmail, ArrayList<ShopLink> shop
		//Retour retour=new Retour(user.getId(), user.getName(), user.getEmail(), likedShop);
		
		return retour;
	}
	@RequestMapping("/deleteShopInUser/{idUser}/{idShop}/")
	public Retour deleteShopInUser(@PathVariable("idUser") String idUser,@PathVariable("idShop") String idShop,ModelMap modelMap){
		User user=userRepository.findOne(idUser);
		ArrayList<String> shops=new ArrayList<String>();
		ArrayList<String> newShops=new ArrayList<String>();
		shops=user.getShops();
		for(int i=0;i<shops.size();i++) {
			if (idShop.equals(shops.get(i))){System.out.println("element à suprimer");}
			else{newShops.add(shops.get(i));}
		}
		user.setShops(newShops);
		userRepository.save(user);
		Retour retour=printLikedShop(idUser,modelMap);
		//String userId, String userName, String userEmail, ArrayList<ShopLink
		return retour;
	}
	@RequestMapping("likedShops/{idUser}/")
  public Retour printLikedShop(@PathVariable("idUser") String idUser,ModelMap modelMap) {
		User user=userRepository.findOne(idUser);
		ArrayList<String> likedShopsId=user.getShops();
		ArrayList<ShopLink> likedShops=new ArrayList<ShopLink>();
		for(int i=0;i<likedShopsId.size();i++) {
			Shop shop=shopRepository.findOne(likedShopsId.get(i));
			String link="/user/deleteShopInUser/"+idUser+"/"+shop.getId();
    		ShopLink shoplink=new ShopLink(shop,link);
			likedShops.add(shoplink);
			}
		modelMap.put("linkNearBy", linkNearBy);
		modelMap.put("linkLike", linkLike);
		 modelMap.put("likedShops",likedShops);
			Retour retour=new Retour(user.getId(), user.getName(), user.getEmail(), likedShops);
			
		 return retour;
	}
	//update
	public void updateUser(User user){
		userRepository.save(user);
	}
	//delete
	public void deleteUser(User user){
		userRepository.delete(user);
	}
	
	
}
