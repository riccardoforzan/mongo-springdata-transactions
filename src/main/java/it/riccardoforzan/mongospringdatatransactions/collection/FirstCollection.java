package it.riccardoforzan.mongospringdatatransactions.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record FirstCollection(@Id String id, String data) {
}
