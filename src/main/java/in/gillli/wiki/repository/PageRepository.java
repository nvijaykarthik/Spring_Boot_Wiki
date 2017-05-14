package in.gillli.wiki.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.gillli.wiki.entity.Page;

public interface PageRepository extends MongoRepository<Page, String> {

	public Page findByUrlFrendlyTitle(String UrlFrendlyTitle);
}
