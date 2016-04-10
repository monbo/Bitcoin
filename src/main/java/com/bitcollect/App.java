package com.bitcollect;
//
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.bitstamp.BitstampExchange;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.dto.marketdata.Ticker;
import com.xeiam.xchange.service.polling.marketdata.PollingMarketDataService;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.bitcollect.ExchangeServers.bitcoinExchangekList;
import static com.bitcollect.ExchangeServers.exchangeAmount;
import static com.bitcollect.ExchangeServers.okcoinCNY;
import static com.bitcollect.ExchangeServers.setUpExhanges;


class App {
    public static void main(String[] args) throws IOException, InterruptedException {

        while (true) {
            Exchange bitstamp = ExchangeFactory.INSTANCE.createExchange(BitstampExchange.class.getName());

            PollingMarketDataService marketDataService = bitstamp.getPollingMarketDataService();

            Ticker ticker = marketDataService.getTicker(CurrencyPair.BTC_USD);

            System.out.println(ticker.toString());
            try {
                Thread.sleep(2000);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            ;
        }
    }
}

/*


    DateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm:ss");

    MongoClient client = new MongoClient("localhost", 27017);
    MongoDatabase database = client.getDatabase("Tick");    // connect to database
    System.out.println("Connect to database successfully");
    setUpExhanges();
    final int MYTHREADS = exchangeAmount;    // thread number
    ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
    for (int i = 0; i < exchangeAmount; i++) {
        ThreadsList.BitcoinRunnable myRunnable = new ThreadsList.BitcoinRunnable(bitcoinExchangekList[i], database);
        executor.execute(myRunnable);
    }


    while (true) {
        Thread.sleep(10);
    }
}*/
