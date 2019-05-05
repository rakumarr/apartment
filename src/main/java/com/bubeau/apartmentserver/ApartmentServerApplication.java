package com.bubeau.apartmentserver;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bubeau.apartmentserver.service.UserDetailsService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;

@SpringBootApplication
public class ApartmentServerApplication {
	
	@Autowired
	private UserDetailsService userDetailsService;

	public static void main(String[] args) {
		SpringApplication.run(ApartmentServerApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("https://www.bubeau.com",
						"https://angular-yd8upv.stackblitz.io");
			}
		};
	}
	
	@Bean
	public OncePerRequestFilter  authentication() {
		return new OncePerRequestFilter () {

			@Override
			protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
					FilterChain filterChain) throws ServletException, IOException {
				System.out.println("asdf");
				try {
					Payload payload = userDetailsService.getUser(request.getHeader("X-AuthToken"));
					if(payload != null) {
						request.setAttribute("user", payload);
					} else {
						response.setStatus(HttpStatus.FORBIDDEN.ordinal());
						throw new IOException("User not Authenticated");
					}					
				} catch (GeneralSecurityException e) {
					throw new IOException(e.getCause());
				}
				filterChain.doFilter(request, response);
			}
			
		};
	}

}
