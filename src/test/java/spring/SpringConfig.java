package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import modules.BrowserConfig;
import responses.JsonResponse;

@Configuration
public class SpringConfig {

	@Bean
	@Scope("cucumber-glue")
	public TestState testState(){
		return new TestState();
	}
	
	@Bean
	@Scope("cucumber-glue")
	public BrowserConfig browserConfig(){
		return new BrowserConfig();
	}
	
	@Bean
	@Scope("cucumber-glue")
	public JsonResponse jsonResponse(){
		return new JsonResponse();
	}
	
}
