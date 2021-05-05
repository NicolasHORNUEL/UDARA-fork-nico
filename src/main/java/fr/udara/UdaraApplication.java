package fr.udara;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *  @SpringBootApplication est une annotation pratique qui ajoute tous les éléments suivants:
 *  @Configuration.
 *  @EnableAutoConfiguration
 *  @ComponentScan.
 *  
 *  @EnableScheduling
 *  Un déclenchement est réalisé tous les jours à 6h00, 12h00 et 18h00 dans la classe IntegrationAPI méthode traite()
 * 
 */
@SpringBootApplication
@EnableScheduling
public class UdaraApplication implements CommandLineRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(UdaraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	}
	
//    @Bean
//    public WebMvcConfigurer corsConfigurer() 
//    {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                //registry.addMapping("/**").allowedOrigins("*");
//                registry.addMapping("/**").allowedOrigins("http://localhost:4200");
//
//            }
//        };
//    }
    

	
}
