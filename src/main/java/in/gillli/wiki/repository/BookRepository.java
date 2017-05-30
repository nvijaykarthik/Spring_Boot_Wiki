package in.gillli.wiki.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.gillli.wiki.entity.Book;

public interface BookRepository extends MongoRepository<Book, String> {

	public Book findByUrlFriendlyName(String urlFriendlyName);
	
	public Book findByName(String name);
	
	public List<Book> findByNameContainingIgnoreCase(String name);
	
}
