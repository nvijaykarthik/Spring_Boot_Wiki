package in.gillli.wiki.service;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Service;

@Service
public class CommonService {

public String markDownParse(String rawText){
	
	 Parser parser = Parser.builder().build();
	 Node document = parser.parse(rawText);
	 HtmlRenderer renderer = HtmlRenderer.builder().build();
	 return renderer.render(document); 
	}
}
