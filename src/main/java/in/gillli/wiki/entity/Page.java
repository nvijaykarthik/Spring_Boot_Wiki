package in.gillli.wiki.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;


public class Page {

	@Id
	public String id;
	
	@Indexed(unique=true)
	public String title;
	public String content;
	
	@Indexed(unique=true)
	public String urlFrendlyTitle;
	
	public Date createdDate;
	public String createdBy;
	
	@Override
	public String toString() {
		return "Page [id=" + id + ", title=" + title + ", urlFrendlyTitle=" + urlFrendlyTitle + ", createdDate="
				+ createdDate + ", createdBy=" + createdBy + "]";
	}
	
	
	
	
	
}
