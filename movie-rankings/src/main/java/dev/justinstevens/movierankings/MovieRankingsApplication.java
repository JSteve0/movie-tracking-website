package dev.justinstevens.movierankings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MovieRankingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRankingsApplication.class, args);
	}

}
