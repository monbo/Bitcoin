package com.bitcollect;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sun.istack.internal.NotNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bson.Document;

import static com.bitcollect.ExchangeServers.bitcoinExchangekList;
import static com.bitcollect.ExchangeServers.okcoinCNY;

/**
 * Created by simonas on 15. 10. 18.
 */
public class ThreadsList {
    private MongoCollection<Document> collection;

    public static class BitcoinRunnable implements Runnable {
        private MongoDatabase database;
        private  BitcoinExchange bitcoinExchange;
        private MongoCollection<Document> collection;
        public BitcoinRunnable(BitcoinExchange bitcoinExchange, MongoDatabase database) {
            this.bitcoinExchange = bitcoinExchange;
            this.database = database;
            collection = database.getCollection(ThreadListCollections.chooseCollection(bitcoinExchange));
        }

        @Override
        public void run() {
            while(true) {
                try {
                    Document doc = JsonReader.readJsonFromUrl(bitcoinExchange);
                    //System.out.println("FAKE  " + bitcoinExchange.getServeURL() + " " + doc.toString());
                    if (doc != null) {
                        if (!StringDuplicate.check(doc.toString()).equals(bitcoinExchange.getPrevious())) {
                            bitcoinExchange.setPrevious(StringDuplicate.check(doc.toString()));
                            Date now = new Date();
                            doc.append("now", now.getTime()); // time at which the data was added
                            if (collection != null) {
                                collection.insertOne(doc);
                                System.out.println(bitcoinExchange.getServeURL() + " " + doc.toString());
                            }
                        }
                    }
/*              DateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
                if(bitcoinExchange.getServeURL() == ExchangeServers.okcoinCNY) {
                    Date dates = new Date();
                    System.out.println(df.format(dates) + "   "+ bitcoinExchange.getDelay());
                }*/
                    //System.out.println();
                    Delay(bitcoinExchange.getDelay());

                    //bitcoinExchange.setInprogress(false);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
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

