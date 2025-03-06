package it.riccardoforzan.mongospringdatatransactions;

import org.springframework.boot.SpringApplication;

public class TestMongoSpringdataTransactionsApplication {

	public static void main(String[] args) {
		SpringApplication.from(MongoSpringdataTransactionsApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
