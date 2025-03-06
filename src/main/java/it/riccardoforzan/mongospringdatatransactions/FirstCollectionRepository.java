package it.riccardoforzan.mongospringdatatransactions;

import it.riccardoforzan.mongospringdatatransactions.collection.FirstCollection;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FirstCollectionRepository extends MongoRepository<FirstCollection, String> {
}
