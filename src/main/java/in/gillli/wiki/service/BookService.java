package in.gillli.wiki.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gillli.wiki.entity.Book;
import in.gillli.wiki.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public void saveBook(Book book){
		book.createdDate=new Date();
		bookRepository.save(book);
	}
	
	public Book getBookByName(String bookName){
		return bookRepository.findByUrlFriendlyName(toCamelUnderscore(bookName));
	}
	
	public Book getBookByUrlFriendlyName(String bookName){
		return bookRepository.findByUrlFriendlyName(bookName);
	}
	
	public Book getBook(String bookId){
		return bookRepository.findOne(bookId);
	}
	
	public String toCamelUnderscore(String input){
		
		String result = "";
		
		char firstChar = input.charAt(0);
        result = result + Character.toUpperCase(firstChar);
        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char previousChar = input.charAt(i - 1);
            if (previousChar == ' ') {
                result = result + Character.toUpperCase(currentChar);
            } else {
                result = result + currentChar;
            }
        }
        return result.replaceAll(" ", "_");
	}
}
