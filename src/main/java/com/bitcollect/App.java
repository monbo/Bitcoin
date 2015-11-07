package com.bitcollect;
//
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.bitcollect.ExchangeServers.bitcoinExchangekList;
import static com.bitcollect.ExchangeServers.exchangeAmount;
import static com.bitcollect.ExchangeServers.setUpExhanges;


class App {


    //Names of bitcoin sites


    public static void main(String[] args) throws IOException, InterruptedException {

        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase database = client.getDatabase("Tick");    // connect to database
        System.out.println("Connect to database successfully");

        //Setting up exchanges
        setUpExhanges();
        final int MYTHREADS = exchangeAmount;    // thread number
        ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
        //noinspection InfiniteLoopStatement

        while (true) {
            for (int i = 0; i < exchangeAmount; i++)
            {
                if (!bitcoinExchangekList[i].isInprogress()) {
                    ThreadsList.BitcoinRunnable myRunnable = new ThreadsList.BitcoinRunnable(bitcoinExchangekList[i], database);
                    executor.execute(myRunnable);
                }
                Thread.sleep(10);
            }
        }
    }

    //
   /* public static class MyRunnable implements Runnable {
        private final String url;
        MongoCollection<Document> collection;

        MyRunnable(String url, MongoDatabase database) {
            this.url = url;
            switch (url) {
                case ExchangeServers.btceUSD:
                    this.collection = database.getCollection("btceUSD");    // get database collection
                    break;
                case ExchangeServers.bitbayUSD:
                    this.collection = database.getCollection("bitbayUSD");    // get database collection
                    break;
                case ExchangeServers.bitstampUSD:
                    this.collection = database.getCollection("bitstampUSD");    // get database collection
                    break;
                case ExchangeServers.korbitKRW:
                    this.collection = database.getCollection("korbitKRW");    // get database collection
                    break;
                case ExchangeServers.bitfinexUSD:
                    this.collection = database.getCollection("bitfinexUSD");    // get database collection
                    break;
                case ExchangeServers.anxhkUSD:
                    this.collection = database.getCollection("anxhkUSD");    // get database collection
                    break;
*//*					case ExchangeServers.bithumbKRW:
						this.collection = database.getCollection("bithumbKRW");	// get database collection
						break; // Kolkas neveikia del http request kaltes*//*
                default:
                    break;
            }
            //this.collection = database.getCollection("bitTestas");	// get database collection
        }

        @Override
        public void run() {

            try {


                //if(ServerAccesabilityTimeCheck.ServerTimerCheck(String url)) {
                Date now = new Date();
                    *//*getTime():It returns the number of milliseconds since
  				    * January 1, 1970, 00:00:00 GMT
  				    * represented by this date.
  				    *//*
                Document doc = JsonReader.readJsonFromUrl(url);
                doc.append("now", now.getTime()); // time at which the data was added

                //}
                //collection.insertOne(doc);
                System.out.println(url + " " + doc.toString());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }


        }

        private void FiveSecondDelay() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/
}