var namespace=""
function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};

function getBook(bookName){
	$.get( namespace+"/resource/Book?bookName="+bookName,function(data, status){
		if(data.sidebarContent){			
			$.ajax({
                url: namespace+"/resource/common/parse",
                dataType: 'text',
                type: 'post',
                contentType:'application/json',
                data: data.sidebarContent,
                success: function( resp, textStatus, jQxhr ){
                    $('#sidebar').html( resp );
                    console.log("Response"+resp);
                },
                error: function( jqXhr, textStatus, errorThrown ){
                    console.log( errorThrown );
                }
            });
		}
	})
}

$(document).ready(function() {
	var bookName=getUrlParameter('book');
	getBook(bookName)
	
});

