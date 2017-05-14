package in.gillli.wiki.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;


public class Page {

	@Id
	public String id;
	
	public String title;
	public String content;
	public String urlFrendlyTitle;
	public Date createdDate;
	public String createdBy;
	
	@Override
	public String toString() {
		return "Page [id=" + id + ", title=" + title + ", urlFrendlyTitle=" + urlFrendlyTitle + ", createdDate="
				+ createdDate + ", createdBy=" + createdBy + "]";
	}
	
	
	
	
	
}
