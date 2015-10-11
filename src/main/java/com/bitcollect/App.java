package com.bitcollect;
//
import java.io.IOException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.bson.Document;

import com.mongodb.Block;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class App {
	//Names of bitcoin sites
	static final String btcUSD = "https://btc-e.com/api/3/ticker/btc_usd";
	static final String bitfinexUSD = "https://api.bitfinex.com//v1/pubticker/btcusd";
	static final String bitstampUSD = "https://bitstamp.net/api/ticker/";
	static final String korbitKRW = "https://api.korbit.co.kr/v1/ticker/detailed";
	static final String bitbayUSD = "https://bitbay.net/API/Public/BTCUSD/ticker.json";
	
	public static void main(String[] args) throws IOException, InterruptedException {

		MongoClient client = new MongoClient("localhost", 27017);
		MongoDatabase database = client.getDatabase("Tick");	// connect to database
		System.out.println("Connect to database successfully");
	 
		final int MYTHREADS = 4;	// thread number

		ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
		String[] serverList = {btcUSD, bitfinexUSD, bitstampUSD, korbitKRW};
		while(true) {
			for (int i = 0; i < serverList.length; i++) {
				String url = serverList[i];
				Runnable worker = new MyRunnable(url, client, database);
				executor.execute(worker);
			}
			Thread.sleep(1000);
			
		}
	}
	//
	public static class MyRunnable implements Runnable {
  		private final String url;
  		MongoCollection<Document> collection;

  		MyRunnable(String url, MongoClient client, MongoDatabase database) {
  			this.url = url;
				switch(url){
					case btcUSD:
						this.collection = database.getCollection("btcUSD");	// get database collection
						break;
					case bitbayUSD:
						this.collection = database.getCollection("bitbayUSD");	// get database collection
						break;
					case bitstampUSD:
						this.collection = database.getCollection("bitstampUSD");	// get database collection
						break;
					case korbitKRW:
						this.collection = database.getCollection("korbitKRW");	// get database collection
						break;
					case bitfinexUSD:
						this.collection = database.getCollection("bitfinexUSD");	// get database collection
						break;
					default:
						break;
				}
  	  		//this.collection = database.getCollection("bitTestas");	// get database collection
  		}
  		public void run() {
  			
  			try {
  				
  				Document doc = JsonReader.readJsonFromUrl(url);
  				
  				collection.insertOne(doc);
  				

  			} catch (Exception e) {
  				System.err.println(e.getMessage());
  		}
  			
  		
	}
  }
  
}