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

$(document).ready(function(){
		var navItems = $('.admin-menu li > a');
		var navListItems = $('.admin-menu li');
		var allWells = $('.admin-content');
		var allWellsExceptFirst = $('.admin-content:not(:first)');

		allWellsExceptFirst.hide();
		navItems.click(function(e)
    	{
        e.preventDefault();
        navListItems.removeClass('active');
        $(this).closest('li').addClass('active');

        allWells.hide();
        var target = $(this).attr('data-target-id');
        $('#' + target).show();
    });
});

$(document).ready(function(){
		$("#myInput").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		$("div#summary").filter(function() {
		$(this).parents("div[id^='panel_']").toggle($(this).text().toLowerCase().indexOf(value) > -1)
				});
			});
		});
