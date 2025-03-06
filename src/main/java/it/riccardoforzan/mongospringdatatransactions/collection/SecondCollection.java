package it.riccardoforzan.mongospringdatatransactions;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record SecondCollection(String id) {
}
