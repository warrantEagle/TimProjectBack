package project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import project.model.Result;
import project.model.ResultRepository;


@SpringBootApplication
@EnableNeo4jRepositories
public class EndomondoApplication {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(EndomondoApplication.class, args);
    }

    /*@Bean
    CommandLineRunner demo(ResultRepository resultRepository) {
        return args -> {

            resultRepository.deleteAll();

            Result greg = new Result( 1, 10, 2, 2);




            resultRepository.save(greg);

        };
    }*/
}