package br.com.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	
	@Bean
	public Docket detalheApi() {
		
		Docket dc = new Docket(DocumentationType.SWAGGER_2);
		
			dc
			.tags(new Tag("Pessoas"    , "Serviços relacionados as pessoas."),
					new Tag("Cargos"    , "Serviços relacionados a Cargos."),
					new Tag("Perfis"    , "Serviços relacionados a Perfis."))
		
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.swagger"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(this.informacoesApi().build());
						
				
		return dc;
	}
	
	

	private ApiInfoBuilder informacoesApi() {
		 
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
 
		apiInfoBuilder.title("Api-Sistema");
		apiInfoBuilder.description("Documentação API ");
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.termsOfServiceUrl("Termo de uso: Implementada e para nível de estudo");
		apiInfoBuilder.license("Licença - Open Source");
		apiInfoBuilder.licenseUrl("Github");
		apiInfoBuilder.contact(this.contato());
 
		return apiInfoBuilder;
 
	}
	private Contact contato() {
 
		return new Contact(
				"Alan Lima",
				"http://github", 
				"alan.makau@gmail.com");
		
	}

}
