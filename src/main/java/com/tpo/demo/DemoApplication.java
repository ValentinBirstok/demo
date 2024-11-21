package com.tpo.demo;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.GraphDatabase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories

public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try (var driver = GraphDatabase.driver("neo4j+s://406c47d3.databases.neo4j.io",
			AuthTokens.basic("neo4j",
				"programacion3"))) {
			driver.verifyConnectivity();
			System.out.println("Connection established.");
}

		
	}

}
