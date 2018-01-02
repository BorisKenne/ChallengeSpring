alert('OK dans le script !!!');

var p=document.getElementById("parent");
alert('p!!!');
for (var i=1;i<=10;i++) {
	alert('boulce !!!');
 var e=document.createElement("div");
 alert('e!!!');
 e.innerHTML="Element n°"+i;
 alert('innert');
 p.append(e);
 alert('p');
}



var lat;
var lon;
var lienShops;
var lienLikeShops;
var email;
var pass;
function connect(){
	
}
function getPosition(){
alert('getPosition');	
		if(navigator.geolocation)
		        {
navigator.geolocation.getCurrentPosition(maPosition, erreurPosition,{maximumAge:600000,enableHighAccuracy:true});
				}
		else{
			lat=-6.81134; 
		    lon=33.95564;
		}
function maPosition(position) {
			lat=position.coords.latitude;
			lon=position.coords.longitude;
			}
function erreurPosition(error) {
			    var info = "Erreur lors de la géolocalisation : ";
			    switch(error.code) {
			    case error.TIMEOUT:
			    	info += "Timeout !";
			    break;
			    case error.PERMISSION_DENIED:
			    info += "Vous navez pas donné la permission";
			    break;
			    case error.POSITION_UNAVAILABLE:
			    	info += "La position na pu être déterminée";
			    break;
			    case error.UNKNOWN_ERROR:
			    	info += "Erreur inconnue";
			    break;
			    }
			}
		
	
}
function getShops(){
	lienShops="http://localhost:8080/user/connectionUser/Alice.com/alice/-6/33.json";
	alert("le lien est :"+lienShops);
	  var req = new XMLHttpRequest();
	  req.open("GET",lienShops, true); 
	  req.onreadystatechange = monCode;
	  req.send(null);
	  function monCode(){
	   if (req.readyState == 4)
	   {
	        var shops = eval('('+req.responseText+')');
	        affichage(shops);  
	   }
	}
}
function getLikeShop(){
	
}
function dislikeShop(){
	
}
function affichage(shops){
	//var ul = $('#itemsList');
	var liste=document.getElementById('itemList');
	alert('UL');
	shops.forEach(function (shop){
		alert('affichage'+shop.id);
		var li=document.createElement('li');
		li.setAttribute('class','lignePhoto');
		
		var shop=document.createElement('table');//$('<table/>',{'class':'shop'});
		shop.setAttribute('class','shop');
		alert('shop');
		var ligneNom=document.createElement('tr');ligneNom.setAttribute('class','ligneNom')//$('<tr/>',{'class':'ligneNom'});
		alert('ligneNom');
		var nom=document.createElement('td');//$('<td/>',{'class':'nom'}).html(shop.name);
		nom.appendChild(document.createTextNode(shop.name));
		alert('nom');
		var lignePhoto=document.createElement('tr');//$('<tr/>',{'class':'lignePhoto'});
		lignePhoto.setAttribute('class','lignePhoto');
		alert('lignePhoto');
		var photo=document.createElement('td');//$('<td/>',{'class':'photo'});
		photo.setAttribute('class','photo');
		alert('photo');
		var image=document.createElement('img');//$('<img/>',{'src':shop.picture});
		image.setAttribute('src',shop.picture);
		alert('image');
		var ligneLike=document.createElement('tr');//$('<tr/>',{'class':'ligneLike'});
		ligneLike.setAttribute('class','ligneLike');
		alert('ligneLike');
		var like=document.createElement('td');//$('<td/>',{'class':'like'});
		like.setAttribute('class','like');
		alert('like');
		var lien=document.createElement('a');//$('<a/>',{'href':shop.link}).html('LIKE/DISLIKE');
		lien.setAttribute('href',shop.link);
		lien.appendChild(document.createTextNode("LIKE/DISLIKE"));
		alert('lien');
		
		ligneNom.appendChild(nom);
		alert('appendLigneNom');
		
		lignePhoto.appendChild(photo);
		alert('appendLignePhoto');
		photo.appendChild(image);
		alert('appendphoto');
	
		
		like.appendChild(lien);
		alert('appendLike');
		ligneLike.appendChild(like);
		alert('appendLigneLike');
		
        shop.appendChild(ligneNom);
        alert('appendShop1');
        shop.appendChild(photo);
        alert('appendShop2');
        shop.appendChild(like);
        alert('appendShop3');
        
        li.appendChild(shop)
        alert('appendListe');
       liste.appendChild(li);
        alert('appendListe');
    });
	
}
/*
function displayFeeds(items){
	var ul = $('#itemsList');
	for (var i = 0; i < items.length; i++) {
	var souslink='https://www.facebook.com/pagedelacasamnationale';
	if(items[i].link.indexOf(souslink)!=-1){
	//if((items[i].link).visited()){alert('lienvisité');}
	var li=$('<li/>',{'class':'ligne' });
	 li.attr('id',items[i].link+'ligne');
	var pubtime=items[i].pubDate;
	var vraiHeure=pubtime.substring(0,16);
	var photo=$('<div/>',{'class':'photo'});
	var image=$('<img/>',{'src':'images/LogCasam.jpg'});
	photo.append(image);
	var titrePub=$('<div/>',{'class':'titrePub'});
	var titre=$('<div/>',{'class':'titre'});
	var linktitle=$('<a/>',{'href':items[i].link}).html(items[i].description);
	    linktitle.attr('class','lien');
	    linktitle.attr('id',items[i].link); 
	    linktitle.attr('target','_blank');
	    linktitle.css({'text-decoration':'none','color':'black'});
	titre.append(linktitle);
	var pub=$('<div/>',{'class':'pub'});
	var heure=$('<div/>',{'class':'heure'}).html(vraiHeure);
	var lus=$('<div/>',{'class':'lus'});
	lus.attr('id',items[i].link+'lus'); 
	lus.attr('class','lus');
	heure.append(lus);
	var casam=$('<div/>',{'class':'casam'})
	var lienCasam=$('<a/>',{'href':'https://www.facebook.com/pagedelacasamnationale'}).html('Cameroonian Student'+'s Association in Morocco');
    casam.append(lienCasam);
    
    pub.append(heure);
    pub.append(casam);
    titrePub.append(titre);
    titrePub.append(pub);
    li.append(photo);
    li.append(titrePub);
    ul.append(li)
    }
	else{
	//alert('lien inacceptable');
    }

	}
	
	load();
	couleursLignes();
	}
*/