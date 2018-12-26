package com.enhancesys.ws;

import org.bson.Document;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Configuration
public class DBUtils {

	MongoClient mongoClient = null;

	@Bean
	public MongoCollection<Document> getConnection() {

		mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("employeedb");
		MongoCollection<Document> collection = database.getCollection("employes");
		return collection;
	}

	@Bean
	public boolean closeConnection() {
		mongoClient.close();
		return true;
	}
}
