package it.riccardoforzan.mongospringdatatransactions;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class MongoSpringdataTransactionsApplicationTests {

	@Test
	void contextLoads() {
	}

}
