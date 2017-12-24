// List.js set-up and initialisation

var options = {
  valueNames: [ 'project-name', 'project-title', 'project-label' ]
};

var userList = new List('sandbox', options);

// View Switcher

$('#viewSwitch').on('click',function(e) {
    if ($('ul').hasClass('grid')) {
        $('ul').removeClass('grid').addClass('list');
    }
    else if($('ul').hasClass('list')) {
        $('ul').removeClass('list').addClass('grid');
    }
});