package in.gillli.wiki.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Menu {

	@Id
	public String id;
	
	@Indexed(unique=true)
	public String menu;
	public String parentMenu;
	public String link;
	
}
