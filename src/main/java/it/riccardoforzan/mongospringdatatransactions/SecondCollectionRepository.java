package it.riccardoforzan.mongospringdatatransactions;

import it.riccardoforzan.mongospringdatatransactions.collection.SecondCollection;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SecondCollectionRepository extends MongoRepository<SecondCollection, String> {
}
