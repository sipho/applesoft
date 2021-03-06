package com.applesoft;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import com.applesoft.resources.RateServiceResource;
import com.google.common.base.Predicate;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Sipho on 04/09/2017.
 */

@Configuration
@ApplicationPath("/applesoft")
@EnableSwagger2
public class AppleSoftAppConfig extends ResourceConfig {

	/**
	 * default constructor of AppleSoftAppConfig
	 */
	public AppleSoftAppConfig() {
		register(RateServiceResource.class);
	}

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("applesoft-api")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(postPaths())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Apple soft rating service system")
				.description("Applesoft API reference for developers")
				.license("Apple soft License")
				.version("1.0")
				.build();
	}

	@SuppressWarnings("unchecked")
	private Predicate<String> postPaths() {

		return or(regex("/applesoft/v1/.*"));
	}
}
