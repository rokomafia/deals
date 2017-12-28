$(document).ready(function(e) {

             $(".dropdown").dropdown({

  			   template : function(r){ return "<li><a>"+r.text+"</a></li>"; },
  			   buttons:[
  			       //Button 1
  				   {
  					   text: 'Profile', //Inner HTML
  					   href: '/user/home', //<a> href
  					   addClass: 'custom-button', //<li> Class
  					   onClick: function(p,e){
  						   return true; //Return true - will close dropdown, false - will keep dropwdown
  					   }
  				   },

  				   // Separator
  				   {},

  				   //Button 2
  				   {
                         text: 'Profile',
                         href: '/',
                         addClass: '',
                         onClick: function(p, e){ return true; }
                     },

                   // Separator
                   {},

  				   //Button 3
  				   {
                         text: 'Log out',
                         href: '/logout',
                         addClass: '',
                         onClick: function(p,e){ return true; }
                     }
  			   ]

  		   });

    });
