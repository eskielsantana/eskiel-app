package com.infotech.app;
import com.infotech.app.util.LoggingInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication(scanBasePackages = { "com.infotech.app" })
public class EskielsBaseProject extends WebMvcConfigurerAdapter {

	// Main function (Obvious)
	public static void main(String[] args) {
		SpringApplication.run(EskielsBaseProject.class, args);
	}

	// I have no idea about what this function does
	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(new LoggingInterceptor()).addPathPatterns("/**");
	}

	// This function returns the data of the application in the swagger page
	@Bean
	public Docket docket()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(getClass().getPackage().getName()))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(generateApiInfo());
	}

	// Defines witch data will be displayed by swagger
	private ApiInfo generateApiInfo()
	{
		return new ApiInfo("Eskiel Base Application", "This is my base application that I will use to create every new project I have.", "Version 1.0 - Starter",
				"urn:tos", "eskiel.sj@gmail.com", "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	}


}