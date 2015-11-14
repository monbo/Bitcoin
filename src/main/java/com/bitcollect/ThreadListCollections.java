package com.bitcollect;

/**
 * Created by simonas on 15. 11. 14.
 *
 * A class for checking the right collection to use
 */

public class ThreadListCollections {
    public static String chooseCollection(BitcoinExchange bitcoinExchange) {

        switch (bitcoinExchange.getServeURL()) {
            case ExchangeServers.btceUSD:
                return "btceUSD";
            case ExchangeServers.bitbayUSD:
                return "bitbayUSD";
            case ExchangeServers.bitstampUSD:
                return "bitstampUSD";
            case ExchangeServers.korbitKRW:
                return "korbitKRW";
            case ExchangeServers.bitfinexUSD:
                return "bitfinexUSD";
            case ExchangeServers.anxhkUSD:
                return "anxhkUSD";
            case ExchangeServers.bithumbKRW:
                return "bithumbKRW";// Kolkas neveikia del http request kaltes
            case ExchangeServers.bitkonanUSD:
                return "bitkonanUSD";
            case ExchangeServers.hitbtcUSD:
                return "hitbtcUSD";
            case ExchangeServers.campbxUSD:
                return "campbxUSD";
            case ExchangeServers.bitcurexUSD:
                return "bitcurexUSD";
            case ExchangeServers.okcoinUSD:
                return "okcoinUSD";
            case ExchangeServers.btccCNY:
                return "btccCNY";
            case ExchangeServers.itbitEUR:
                return "itbitEUR";
            case ExchangeServers.krakenEUR:
                return "krakenEUR";
            case ExchangeServers.bitIndonesiaIDR:
                return "bitIndonesiaIDR";
            case ExchangeServers.hitbtcEUR:
                return "hitbtcEUR";
            case ExchangeServers.okcoinCNY:
                return "okcoinCNY";
            default:
                return "";
        }
    }
}
