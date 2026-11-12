package apihibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.krakdev.peliculas.entidades")
@EnableJpaRepositories(basePackages = "com.krakdev.peliculas.repository")
@ComponentScan(basePackages = {
        "com.krakdev.peliculas.controllers",
        "com.krakdev.peliculas.services"
})
public class ApihibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApihibernateApplication.class, args);
    }
}