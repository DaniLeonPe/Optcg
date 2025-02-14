package es.ies.puerto.optcg.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath*:cxf-service.xml")
//@ComponentScan(basePackages = "es.ies.puerto.mgs.project")
public class OptcgApplication {

	public static void main(String[] args) {
		SpringApplication.run(OptcgApplication.class, args);
	}

}
