package com.bankonet.mongodb;

import java.sql.SQLException;

import org.bson.Document;

import com.bankonet.model.Client;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ClientDao {
	/* Attributs */
	private final String URL = "localhost";
	private MongoClient mongoClient;
	private MongoDatabase mongoDatabase;
	
	/* Constructeurs */
	public ClientDao() {
		mongoClient = new MongoClient("localhost");
		mongoDatabase = mongoClient.getDatabase("bankonet");
	}
	
	/* Methodes */
	public void closeConnection() {
		mongoClient.close();
	}
	
	public void ecrireClient(Client client) {
		MongoCollection clientsCollection = mongoDatabase.getCollection("clients");
		Document clientDoc = client.toDocument();
		clientsCollection.insertOne(clientDoc);
	}
}
