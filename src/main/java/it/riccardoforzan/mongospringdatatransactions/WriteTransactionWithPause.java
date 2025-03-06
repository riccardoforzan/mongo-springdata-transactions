package it.riccardoforzan.mongospringdatatransactions;

import it.riccardoforzan.mongospringdatatransactions.collection.FirstCollection;
import it.riccardoforzan.mongospringdatatransactions.collection.SecondCollection;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class WriteTransactionWithPause {

    private final FirstCollectionRepository firstCollectionRepository;
    private final SecondCollectionRepository secondCollectionRepository;

    public WriteTransactionWithPause(FirstCollectionRepository firstCollectionRepository, SecondCollectionRepository secondCollectionRepository) {
        this.firstCollectionRepository = firstCollectionRepository;
        this.secondCollectionRepository = secondCollectionRepository;
    }

    @Transactional
    void writeDataWithPause() {
        firstCollectionRepository.save(new FirstCollection(UUID.randomUUID().toString(), "1"));
        secondCollectionRepository.save(new SecondCollection(UUID.randomUUID().toString(), "2"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.printf("Transaction done\n");
    }
}
