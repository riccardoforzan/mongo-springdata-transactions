package it.riccardoforzan.mongospringdatatransactions;

import it.riccardoforzan.mongospringdatatransactions.collection.FirstCollection;
import it.riccardoforzan.mongospringdatatransactions.collection.SecondCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class MongoSpringdataTransactionsApplicationTests {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    WriteTransactionWithPause writeTransactionWithPause;

    @Test
    void testTransactionalVisibility() throws InterruptedException {
        try (ExecutorService executor = Executors.newSingleThreadExecutor()) {
            executor.submit(() -> writeTransactionWithPause.writeDataWithPause());
            // Ensure transactional writes have started
            Thread.sleep(1000);

            System.out.println("Reading data before completion");
            // Verify transactional data isn't visible externally yet
            Assertions.assertEquals(0, mongoTemplate.findAll(FirstCollection.class).size());
            Assertions.assertEquals(0, mongoTemplate.findAll(SecondCollection.class).size());

            executor.shutdown();
            executor.awaitTermination(10, TimeUnit.SECONDS);
            System.out.println("Reading data after completion");
            // After completion, verify data is now visible (transaction committed)
            Assertions.assertEquals(1, mongoTemplate.findAll(FirstCollection.class).size());
            Assertions.assertEquals(1, mongoTemplate.findAll(SecondCollection.class).size());
        }
    }

}
