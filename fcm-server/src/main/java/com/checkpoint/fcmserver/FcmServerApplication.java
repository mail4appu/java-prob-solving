package com.checkpoint.fcmserver;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.IOException;

@SpringBootApplication
public class FcmServerApplication extends SpringBootServletInitializer {



	public static void main(String[] args) {
		SpringApplication.run(FcmServerApplication.class, args);
		FirebaseOptions options = null;
		try {
			options = FirebaseOptions.builder()
					.setCredentials(GoogleCredentials.getApplicationDefault())
					//.setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
					.build();
		} catch (IOException e) {
			e.printStackTrace();
		}

		FirebaseApp.initializeApp(options);

	}

}
