package in.gillli.wiki;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import in.gillli.wiki.utils.ExceptionErrorMapping;
import in.gillli.wiki.utils.ExceptionHandlerMapping;


@SpringBootApplication
public class WikiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WikiApplication.class, args);
	}
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/resource/**").allowedOrigins("*");
            }
        };
    }

	
	@Bean
	public ExceptionHandlerMapping exceptionHandlerMapping(){
		ExceptionHandlerMapping mapping = new ExceptionHandlerMapping();
		Map<Class<? extends Exception>,ExceptionErrorMapping> exceptionHandler = new HashMap<>();
		exceptionHandler.put(HttpMessageNotReadableException.class, new ExceptionErrorMapping(HttpStatus.BAD_REQUEST,"Invalid message"));
		mapping.setExceptionHandler(exceptionHandler);	
		return mapping;	
	}
}
