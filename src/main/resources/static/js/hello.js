var lat;
var lon;

position();

alert('la position lat='+lat);
alert('la position lon='+lon);

alert('response is ok');
angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('http://localhost:8080/user/connectionUser/Alice.com/alice/'+lat+'/'+lon).
        then(function(response) {
        	alert(response);
            $scope.greeting = response.data;
        });
});

function position(){
	if(navigator.geolocation)
	        {
					alert("geo  accord obtenue");
				  navigator.geolocation.getCurrentPosition(maPosition, erreurPosition,{maximumAge:600000,enableHighAccuracy:true});
				}

	function maPosition(position) {
		alert("determination de la position");
		lat=position.coords.latitude;
		lon=position.coords.longitude;	
		alert('lat='+lat);
		alert('lon='+lon);
		
		angular.module('demo', [])
		.controller('Hello', function($scope, $http) {
			var lien='http://localhost:8080/user/connectionUser/Alice.com/alice/'+lat+'/'+lon;
			alert('le lien est'+lien);
		    $http.get(lien).
		        then(function(response){
		        	alert(response);
		            $scope.greeting = response.data;
		        });
		});
		/*
		  infopos += "Latitude : "+position.coords.latitude +"\n";
		  infopos += "Longitude: "+position.coords.longitude+"\n";
		  infopos += "Altitude : "+position.coords.altitude +"\n";
	    */
		}
		function erreurPosition(error) {
		  alert("erreure de determination de la position");
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
