package com.bitcollect;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sun.istack.internal.NotNull;

import java.util.Date;
import org.bson.Document;

/**
 * Created by simonas on 15. 10. 18.
 */
public class ThreadsList {
    private MongoCollection<Document> collection;

    public static class BitcoinRunnable implements Runnable {
        private MongoDatabase database;
        private BitcoinExchange bitcoinExchange;

        public BitcoinRunnable(BitcoinExchange bitcoinExchange, MongoDatabase database) {
            MongoCollection<Document> collection;
            this.bitcoinExchange = bitcoinExchange;
            this.database = database;
        }

        @Override
        public void run() {
            try {
                bitcoinExchange.setInprogress(true);
                MongoCollection<Document> collection = null;


                switch (bitcoinExchange.getServeURL()) {
                    case ExchangeServers.btceUSD:
                        collection = database.getCollection("btceUSD");// get database collection
                        break;
                    case ExchangeServers.bitbayUSD:
                        collection = database.getCollection("bitbayUSD");// get database collection
                        break;
                    case ExchangeServers.bitstampUSD:
                        collection = database.getCollection("bitstampUSD");// get database collection
                        break;
                    case ExchangeServers.korbitKRW:
                        collection = database.getCollection("korbitKRW");// get database collection
                        break;
                    case ExchangeServers.bitfinexUSD:
                        collection = database.getCollection("bitfinexUSD");// get database collection
                        break;
                    case ExchangeServers.anxhkUSD:
                        collection = database.getCollection("anxhkUSD");// get database collection
                        break;
                    case ExchangeServers.bithumbKRW:
                        collection = database.getCollection("bithumbKRW");// get database collection
                        break; // Kolkas neveikia del http request kaltes
                    case ExchangeServers.bitkonanUSD:
                        collection = database.getCollection("bitkonanUSD");// get database collection
                        break;
                    case ExchangeServers.hitbtcUSD:
                        collection = database.getCollection("hitbtcUSD");// get database collection
                        break;
                    case ExchangeServers.campbxUSD:
                        collection = database.getCollection("campbxUSD");// get database collection
                        break;
                    case ExchangeServers.bitcurexUSD:
                        collection = database.getCollection("bitcurexUSD");// get database collection
                        break;
                    default:
                        break;
                }
                Document doc = JsonReader.readJsonFromUrl(bitcoinExchange.getServeURL());
                //System.out.println("FAKE" + bitcoinExchange.getServeURL() + " " + doc.toString());

                if (doc != null) {
                    if (!StringDuplicate.check(doc.toString()).equals(bitcoinExchange.getPrevious())){
                        bitcoinExchange.setPrevious(StringDuplicate.check(doc.toString()));
                        Date now = new Date();
                        doc.append("now", now.getTime()); // time at which the data was added
                        //System.out.println(bitcoinExchange.getServeURL() + " " + doc.toString());
                        if (collection != null) {
                            collection.insertOne(doc);
                        }
                    }
                }
                Delay(bitcoinExchange.getDelay());

                bitcoinExchange.setInprogress(false);




            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }
        private void Delay(int delay) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

