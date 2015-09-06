package com.bitcollect;


import java.util.Date;

import java.io.IOException;

import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class App {
	
 public static void main(String[] args) throws IOException, JSONException, InterruptedException {

	 MongoClient client = new MongoClient("localhost", 27017);
	 MongoDatabase database = client.getDatabase("Tick");	// connect to database
	 System.out.println("Connect to database successfully");
	 
	 MongoCollection<Document> collection = database.getCollection("Data");	// get database collection
	 System.out.println("Collection created successfully");
	 
	 
	Timer time = new Timer(); //timer to slow down connection requests
	final int MYTHREADS = 5;	// thread number

    ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
	String[] serverList = {"https://btc-e.com/api/3/ticker/btc_usd","https://api.bitfinex.com//v1/pubticker/btcusd", "https://bitstamp.net/api/ticker/",
			"https://api.korbit.co.kr/v1/ticker/detailed","https://bitbay.net/API/Public/BTCUSD/ticker.json"};
	boolean a = true;
	
	while(true) {
		for (int i = 0; i < serverList.length; i++) {
			String url = serverList[i];
			Runnable worker = new MyRunnable(url);
			executor.execute(worker);
		}
		Thread.sleep(100);

	}
}

   

  	public static class MyRunnable implements Runnable {
  		private final String url;
  		Date now; // to display current time

  		MyRunnable(String url) {
  			this.url = url;
  		}

  		public void run() {
  			
  			now = new Date(); // initialize date
  			String result = "";
  			
  			try {
  				JSONObject json = JsonReader.readJsonFromUrl(url);

  			} catch (Exception e) {
  				System.err.println(e.getMessage());

  		}
  			
  		
	}
  }
  
}