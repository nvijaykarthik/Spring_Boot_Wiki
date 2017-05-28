package in.gillli.wiki.resources.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.gillli.wiki.entity.Book;
import in.gillli.wiki.service.BookService;

@RestController
@RequestMapping("/resource/Book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void addBook(@RequestBody Book book){
		book.createdDate=new Date();
		bookService.saveBook(book);
		}
	
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Book getBook(@RequestParam String bookName){
		return	bookService.getBookByName(bookName);
	}
}
