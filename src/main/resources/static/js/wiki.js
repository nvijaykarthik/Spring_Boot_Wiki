var namespace="";
var book;
var page;
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

function getBook(bookName,sidebarEdit,pageEdit){
	$.get( namespace+"/resource/Book?bookName="+bookName,function(data, status){
		book=data;
		if(book.sidebarContent){			
			$.ajax({
                url: namespace+"/resource/common/parse",
                dataType: 'text',
                type: 'post',
                contentType:'application/json',
                data: book.sidebarContent,
                success: function( resp, textStatus, jQxhr ){
                    $('#sidebar-view').html( resp );
                   
                    $('#sidebar-view ul li').click(function(e) {
                		e.preventDefault();
                		/*$('#sidebar-view ul li').removeClass('atleta_atual');
                		$(this).addClass('atleta_atual');*/
                		var h = $("a",this).attr('href');
                        getPage(h,pageEdit);
                	});
                    
                },
                error: function( jqXhr, textStatus, errorThrown ){
                    console.log( errorThrown );
                }
            });
			sidebarEdit.value(book.sidebarContent);
		}
	});
}


function saveBookSidebar(sideBarContent){
	book.sidebarContent=sideBarContent;
	console.log("Book : "+book.id);
	
	$.ajax({
        url: namespace+"/resource/Book",
        dataType: 'text',
        type: 'post',
        contentType:'application/json',
        data: JSON.stringify(book),
        success: function( resp, textStatus, jQxhr ){
           alert("Successfully saved");    
        },
        error: function( jqXhr, textStatus, errorThrown ){
        	alert("error while saving the book");
            console.log( errorThrown );
        }
    });
}

function savePage(pageContent){
	page.content=pageContent;
	
	$.ajax({
        url: namespace+"/resource/page",
        dataType: 'text',
        type: 'post',
        contentType:'application/json',
        data: JSON.stringify(page),
        success: function( resp, textStatus, jQxhr ){
           alert("Successfully saved");    
        },
        error: function( jqXhr, textStatus, errorThrown ){
        	alert("error while saving the book");
            console.log( errorThrown );
        }
    });
}


function getPage(url,pageEdit){
	$.get( namespace+url,function(data, status){
		page=data;
		if(page.content){			
			$.ajax({
                url: namespace+"/resource/common/parse",
                dataType: 'text',
                type: 'post',
                contentType:'application/json',
                data: page.content,
                success: function( resp, textStatus, jQxhr ){
                    $('#page-view').html( resp );
                },
                error: function( jqXhr, textStatus, errorThrown ){
                    console.log( errorThrown );
                }
            });
			$('#pageTitle').html("<h1>"+page.title+"</h1>");
			pageEdit.value(page.content)
		}
	})
}

$(document).ready(function() {
	var bookName=getUrlParameter('book');	
	$(".nav-tabs a").click(function(){
        $(this).tab('show');
    });
	
	var sidebarEdit = new SimpleMDE({ 
        element: document.getElementById("sidebar-edit-txt") 
    });
	
	var pageEdit = new SimpleMDE({ 
        element: document.getElementById("page-edit-txt") 
    });
	
	getBook(bookName,sidebarEdit,pageEdit);
	
	$('#sidebarSave').click(function(){
		var modifiedValue=sidebarEdit.value();
		saveBookSidebar(modifiedValue);
	})

	$('#pageSave').click(function(){
		var pageCntValue=pageEdit.value();
		savePage(pageCntValue);
	});
	
	$('#refreshBook').click(function(){
		getBook(bookName,sidebarEdit,pageEdit);
	})
	
	$('#refreshPage').click(function(){
		getPage("/resource/page/"+page.title,pageEdit);
	})
	
	$('#searchResult').hide();
	var divList = $('#searchResult')
	$('#searchText').on('change keyup paste',function() {
		if($(this).val().length > 0){
			 divList.empty();
		   $('#searchResult').show();
		   $.get( namespace+"/resource/Book/search?bookName="+$(this).val(),function(data, status){
			   var ul = $('<ul/>')
		        .addClass('search-ul')
		        .appendTo(divList);
			   $.each(data , function (index, value){
				   var li = $('<li/>')
			        .addClass('search-li')
			        .appendTo(ul);
				   var aaa = $('<a/>')
			        .addClass('search-a')
			        .text(value.name)
			        .attr("href","?book="+value.urlFriendlyName)
			        .appendTo(li);
				 });
		   });
		}else{
			$('#searchResult').hide();
		}
	});
});


/*$('li > a').click(function() {
/$('li').removeClass();
$(this).parent().addClass('active');
});

$('ul.art-vmenu li').click(function(e) 
    { 
     alert($(this).find("span.t").text());
    });

<div class="wrap_atletas_interno">
	<ul>
		<li class="atleta">
			<a href="teste.html">
				<div class="nome_86_atleta">Antônio</div>
				<img src="atletas/antonio_86px.jpg"/>
			</a>
		</li>
		<li  class="atleta">
			<div class="nome_86_atleta">Cauê</div>
			<img src="atletas/caue_86px.jpg"/>
		</li>
		<li class="atleta">
			<div class="nome_86_atleta">Dudu</div>
			<img src="atletas/dudu_86px.jpg"/>
		</li>
  </ul>
</div>



*/
