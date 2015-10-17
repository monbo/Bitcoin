package com.bitcollect;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Date;
import org.bson.Document;

/**
 * Created by simonas on 15. 10. 18.
 */
public class ThreadsList {
    private MongoCollection<Document> collection;















    ///////////// MyRunable for Two Second

    public static class TwoSecondRunnable implements Runnable {
        private String url;
        private MongoDatabase database;
        public TwoSecondRunnable(String url, MongoDatabase database) {
            MongoCollection<Document> collection;
            this.url = url;
            this.database = database;

        }

        @Override
        public void run() {

            try {

                MongoCollection<Document> collection;
                Date now = new Date();
                System.out.println("Starting time:" +Thread.currentThread().getName() + " " + now);
                switch (url) {
                    case ExchangeServers.btceUSD:
                        collection = database.getCollection("btceUSD");    // get database collection
                        break;
                    case ExchangeServers.bitbayUSD:
                        collection = database.getCollection("bitbayUSD");    // get database collection
                        break;
                    case ExchangeServers.bitstampUSD:
                        collection = database.getCollection("bitstampUSD");    // get database collection
                        break;
                    case ExchangeServers.korbitKRW:
                        collection = database.getCollection("korbitKRW");    // get database collection
                        break;
                    case ExchangeServers.bitfinexUSD:
                        collection = database.getCollection("bitfinexUSD");    // get database collection
                        break;
                    case ExchangeServers.anxhkUSD:
                        collection = database.getCollection("anxhkUSD");    // get database collection
                        break;
/*					case ExchangeServers.bithumbKRW:
						this.collection = database.getCollection("bithumbKRW");	// get database collection
						break; // Kolkas neveikia del http request kaltes*/
                    default:
                        break;
                }


                Document doc = JsonReader.readJsonFromUrl(url);
                doc.append("now", now.getTime()); // time at which the data was added
                System.out.println(url + " " + doc.toString());
                TwoSecondDelay();
                Date end = new Date();
                System.out.println("Ending Time: " + Thread.currentThread().getName() + " " + end);

                //}
                //collection.insertOne(doc);

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }


        }
        private void TwoSecondDelay() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

