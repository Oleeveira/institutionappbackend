package com.example.institutionbackend;

import com.google.api.client.util.Value;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;


@SpringBootApplication

public class InstitutionbackendApplication {

	@Value("${firebase.service-account.path}")
	private String serviceAccountPath;


	public static void main(String[] args) throws IOException {
		ClassLoader classLoader = InstitutionbackendApplication.class.getClassLoader();

		File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountKey.json")).getFile());
		FileInputStream serviceAccount =
				new FileInputStream(file.getAbsolutePath());


		FirebaseOptions options = new FirebaseOptions.Builder()

				.setCredentials(GoogleCredentials.fromStream(serviceAccount))

				.setDatabaseUrl("https://institutionapp-1cc1e-default-rtdb.firebaseio.com")

				.build();


		FirebaseApp.initializeApp(options);

		SpringApplication.run(InstitutionbackendApplication.class, args);
	}

}
