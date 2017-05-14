package in.gillli.wiki.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.gillli.wiki.entity.Menu;

public interface MenuRepository extends MongoRepository<Menu, String> {

	public List<Menu> findByParentMenu(String parentMenu);
	public List<Menu> findByParentMenuIsNull();
	
}
