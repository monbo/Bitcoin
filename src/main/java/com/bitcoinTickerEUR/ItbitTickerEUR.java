package com.bitcoinTickerEUR;

import com.bitcollect.JsonItemIterator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by simonas on 15. 11. 8.
 */
public class ItbitTickerEUR {
    public static String itbit(JSONObject json) throws JSONException{
//    https://api.itbit.com/v1/markets/XBTEUR/ticker
        Date timestamp = new Date();
/*    {"pair":"XBTEUR","bid":"382.65","bidAmt":"114.4219","ask":"383.29",
            "askAmt":"4.477","lastPrice":"382.65000000",
            "lastAmt":"1.57500000","volume24h":"3631.12780000",
            "volumeToday":"1826.49970000","high24h":"391.13000000","low24h":"375.96000000","highToday":"389.53000000","lowToday":"375.96000000",
            "openToday":"384.39000000","vwapToday":"384.73825170","vwap24h":"385.44867764","serverTimeUTC":"2015-11-08T08:43:40.3434349Z"}*/
        //System.out.println(json.toString());
        Map<String, String> out = new HashMap<String, String>();
        JsonItemIterator.parse(json, out);


        String bid = out.get("bid");
        String ask = out.get("ask");
        String high = out.get("high24h"); //all high and low are 24h
        String low = out.get("low24h");
        String last = out.get("lastPrice");
        String volume = out.get("volume24h");
        String vwap = out.get("vwap24h");
        String open = out.get("openToday"); // first trade price

        String bid_amt = out.get("bidAmt"); // highest bid amount
        String ask_amt = out.get("askAmt"); // lowest ask amount
        String last_amt = out.get("lastAmt");
        String vol_today = out.get("volumeToday");
        String high_today = out.get("highToday");
        String low_today = out.get("lowToday");
        String vwap_today = out.get("vwapToday");

       // String timestamp = out.get("serverTimeUTC"); // wrong time stamp
        return "{\"bid\":" + bid + ",\"ask\":" + ask + ",\"high\":" + high + ",\"low\":" + low + ",\"last\":"
                + last + ",\"volume\":" + volume + ",\"vwap\":" + vwap + ",\"open\":" + open + ",\"bidAmt\":" + bid_amt + ",\"askAmt\":" + ask_amt +
                ",\"lastAmt\":" + last_amt +",\"vol_today\":" + vol_today +",\"high_today\":" + high_today +",\"low_today\":" + low_today +",\"vwap_today\":" + vwap_today + ",\"timestamp\":" + timestamp.getTime() +"}";


    }
}
