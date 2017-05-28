package in.gillli.wiki.resources.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.gillli.wiki.entity.Page;
import in.gillli.wiki.service.PageService;

@RestController
@RequestMapping("/resource/page")
public class PageController {

	@Autowired
	private PageService pageService;
	
	@RequestMapping(method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void addPage(@RequestBody Page page){
		page.createdDate=new Date();
		pageService.addPage(page);
	}
	
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Page getPage(@RequestParam String pageTitle){
		return	pageService.getPage(pageTitle);
	}
}
