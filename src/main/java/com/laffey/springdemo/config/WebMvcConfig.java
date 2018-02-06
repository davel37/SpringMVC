package com.laffey.springdemo.config;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.laffey.springdemo.inteceptors.HeaderInteceptor;



@Configuration
@ComponentScan("com.laffey.springdemo")
@EnableWebMvc


public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public DataSource dataSource() {
		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		
		dsLookup.setResourceRef(true);
		DataSource dataSource = dsLookup.getDataSource("jdbc/springdb");
		return dataSource;
		
	}
	//@Bean
	//public RequestMappingHandlerMapping requestMappingHandlerMapping() {
	//	RequestMappingHandlerMapping rmhm = new RequestMappingHandlerMapping();
		//rmhm.setUseSuffixPatternMatch(false);
		//rmhm.setUseTrailingSlashMatch(false);
		//return rmhm;
		
	//}
	
	
	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
	    resolver.setViewClass(JstlView.class);
	    
	    return resolver;
	
}
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("testMvcHome");
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HeaderInteceptor());
	}
}
