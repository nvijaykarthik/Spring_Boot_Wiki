package in.gillli.wiki.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import in.gillli.wiki.entity.Book;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

	
	@Autowired
	private BookService bookservice;
	
	@Test
	public void testAddBook() {
		Book book = new Book();
		book.name="My second book";
		book.createdBy="vijaykarthik n";
		book.urlFriendlyName=bookservice.toCamelUnderscore(book.name);
		bookservice.saveBook(book);
		book=bookservice.getBookByName("My second book");
		System.out.println(book);
		book.sidebarContent ="* [Homepage](/resource/page/home)";
		book.bookCover="# cover page";
		bookservice.saveBook(book);
		book=bookservice.getBookByName("My second book");
		System.out.println(book);
	}		

}	