package in.gillli.wiki.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.gillli.wiki.entity.Page;

public interface PageRepository extends MongoRepository<Page, String> {

	public Page findByUrlFrendlyTitle(String UrlFrendlyTitle);
	
	public List<Page> findByBookId(String bookId);
}
