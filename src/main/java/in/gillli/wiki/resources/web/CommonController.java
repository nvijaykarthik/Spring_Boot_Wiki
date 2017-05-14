package in.gillli.wiki.resources.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.gillli.wiki.service.CommonService;

@RestController
@RequestMapping("/resource/common")
public class CommonController {

	@Autowired
	private CommonService commonService;
	
	@RequestMapping(path="/parse",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public String parse(@RequestBody String rawText){
		return	commonService.markDownParse(rawText);
	}
	
}
