package fr.udara;

import java.net.URI;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.udara.model.CurrentWeatherData;

@SpringBootApplication
@EnableWebMvc
public class UdaraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UdaraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		
		String API_key = "5365db9398346b11fec2438e41e3563b";
		String city_name = "Montpellier";
		String metrics = "metrics";
		String baseUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city_name + "&appid=" + API_key + "&units=" + metrics;		
		URI uri = new URI(baseUrl);
		
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		String jsonString = response.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		CurrentWeatherData bean = mapper.readValue(jsonString, CurrentWeatherData.class);
		System.out.println(bean);

		
		
	}

	
}
