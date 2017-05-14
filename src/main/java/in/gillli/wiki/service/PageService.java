package in.gillli.wiki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gillli.wiki.entity.Page;
import in.gillli.wiki.repository.PageRepository;

@Service
public class PageService {

	@Autowired
	private PageRepository pageRepository;
	
	public void addPage(Page page){
		pageRepository.save(page); 
	}
	
	public Page getPage(String pageTitle)
	{
		return pageRepository.findByUrlFrendlyTitle(toCamelUnderscore(pageTitle));
	}
	
	public String toCamelUnderscore(String input){
		
		String result = "";
		
		char firstChar = input.charAt(0);
        result = result + Character.toUpperCase(firstChar);
        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char previousChar = input.charAt(i - 1);
            if (previousChar == ' ') {
                result = result + Character.toUpperCase(currentChar);
            } else {
                result = result + currentChar;
            }
        }
        return result.replaceAll(" ", "_");
	}
}
