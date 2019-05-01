package com.bubeau.apartmentserver.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bubeau.apartmentserver.models.User;
import com.bubeau.apartmentserver.repository.RoleRepository;
import com.bubeau.apartmentserver.repository.UserRepository;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	private static final JacksonFactory jsonFactory = new JacksonFactory();

	@Override
	public void getUser(String token) throws GeneralSecurityException, IOException {
		
		HttpTransport transport = new NetHttpTransport();

		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
		    // Specify the CLIENT_ID of the app that accesses the backend:
		    .setAudience(Collections.singletonList("1009671136892-50ko56l38kkkcdmmj9cd7n0pbeu4poe3.apps.googleusercontent.com"))
		    // Or, if multiple clients access the backend:
		    //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
		    .build();

		// (Receive idTokenString by HTTPS POST)

		GoogleIdToken idToken = verifier.verify(token);
		if (idToken != null) {
		  Payload payload = idToken.getPayload();

		  // Print user identifier
		  String userId = payload.getSubject();
		  System.out.println("User ID: " + userId);

		  // Get profile information from payload
		  String email = payload.getEmail();
		  boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
		  String name = (String) payload.get("name");
		  String pictureUrl = (String) payload.get("picture");
		  String locale = (String) payload.get("locale");
		  String familyName = (String) payload.get("family_name");
		  String givenName = (String) payload.get("given_name");
		  System.out.println(payload.toPrettyString());
		  // Use or store profile information
		  // ...

		} else {
		  System.out.println("Invalid ID token.");
		}
		
	}

}
