package trng.rest.ws.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.annotation.MultipartConfig;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.imcs.spring.config.DbConfig;

@Configuration
@ComponentScan(basePackages = { "trng.rest.ws" })
@EnableWebMvc
@EnableAutoConfiguration
@MultipartConfig
@Import(DbConfig.class)
public class AppConfig {

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
		multipartConfigFactory.setMaxFileSize("128KB");
		multipartConfigFactory.setMaxRequestSize("128KB");
		return multipartConfigFactory.createMultipartConfig();
	}
}
