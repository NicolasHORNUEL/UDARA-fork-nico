package fr.udara;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import fr.udara.batch.IntegrationAPI;
import fr.udara.batch.IntegrationFile;

@SpringBootApplication
@EnableWebMvc
public class UdaraApplication implements CommandLineRunner {

	private IntegrationFile integrationFile;
	private IntegrationAPI integrationAPI;

	
	public static void main(String[] args) {
		SpringApplication.run(UdaraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		this.integrationFile.traite();
		//this.integrationAPI.traite();

	}

	
}
