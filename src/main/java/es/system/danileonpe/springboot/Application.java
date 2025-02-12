package es.system.danileonpe.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ComponentScan(basePackages = "es.system.danileonpe.springboot")
//@ComponentScan(basePackages = "es.system.danileonpe.springboot")

public class Application {
	
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
}
