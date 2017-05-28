package in.gillli.wiki.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Book {

	@Id
	public String id;
	
	@Indexed(unique=true)
	public String name;
	
	@Indexed(unique=true)
	public String urlFriendlyName;
	
	public String sidebarContent;
	
	public String bookCover;
	
	public Date createdDate;
	
	public String createdBy;
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", urlFriendlyName=" + urlFriendlyName + ", createdDate="
				+ createdDate + ", createdBy=" + createdBy + "]";
	}
	
}
