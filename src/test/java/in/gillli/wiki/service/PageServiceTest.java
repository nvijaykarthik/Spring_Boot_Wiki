package in.gillli.wiki.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import in.gillli.wiki.entity.Page;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PageServiceTest {

	@Autowired
	private PageService pageService;
	
	@Test
	public void testAddPage() {
		 Page page = new Page();
		 page.title="My First title";
		 page.content="# My First Page";
		 page.urlFrendlyTitle=pageService.toCamelUnderscore(page.title);
		 page.createdBy="vijaykarthik";
		 page.createdDate = new Date();
		 
		 pageService.addPage(page);
	}

	@Test
	public void testGetPage() {
		System.out.println(pageService.getPage("My First title"));
	}

}
