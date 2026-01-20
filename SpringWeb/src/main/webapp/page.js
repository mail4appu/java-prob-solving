

/*jQuery.i18n.properties({name:'messages',path:'/',mode:'both',
	   language:'en',callback:function(){}});*/
function showMessage(){
	window.alert(jQuery.i18n.prop("wel.come.text"));
}


var localized_messages;

$(document).ready(function(){
	document.cookie="lang=es"; 
	$.ajax
	({
		type		: 'GET',	  			
		url			: '/springweb/getJson',   
		cache       : true,
		success		: function(response){
			
			localized_messages = jQuery.parseJSON( response );
			alert(getLocalizedText("wel.come.text"));
		}});		

});


//This is to get the localized messages

function getLocalizedText(key){
	/*if(key.indexOf(".")){	
		key = key.replace(/\./g, "_");
	}*/
	console.log("key is"+key+"\n"+JSON.stringify(localized_messages));
	console.log(localized_messages[key])
	//This is where we are getting the localized message from json object
	return localized_messages[key];
	
}
