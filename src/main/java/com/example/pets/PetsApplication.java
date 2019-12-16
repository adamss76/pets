package com.example.pets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class })
public class PetsApplication {
	@Value("${client.id}")
	String client_id;

	@Value("${client.secret}")
	String client_secret;
	@Bean
	public OAuth2RestTemplate oauth2RestTemplate() {
		ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
		resourceDetails.setGrantType("client_credentials");
		resourceDetails.setAccessTokenUri("https://api.petfinder.com/v2/oauth2/token");

		resourceDetails.setClientId("Yhn4gF6MKRFaS7oFsIIbmXDVgxV2EbklvAc1i0okCPMAtXsAhu");
		resourceDetails.setClientSecret("7A2S9TEoaEFTsClsPBtpPo3RRuzKwZXQSdyBoKfx");
		resourceDetails.setAuthenticationScheme(AuthenticationScheme.header);
		return new OAuth2RestTemplate(resourceDetails);
	}

	public static void main(String[] args) {
		SpringApplication.run(PetsApplication.class, args);
	}

}
