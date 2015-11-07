package com.bitcoinTickersUSD;

import com.bitcollect.JsonItemIterator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by simonas on 15. 11. 1.
 */
public class HitbtcTickUSD {
/*
    {"ask":"327.12","bid":"323.94","last":"324.50",
            "low":"317.80","high":"351.68","open":"341.88","volume":"259.71","volume_quote":"86199.42","timestamp":1446354327061}*/

    public static String hitbtc(JSONObject json) throws JSONException {

        Map<String, String> out = new HashMap<String, String>();
        JsonItemIterator.parse(json, out);

        String bid = out.get("bid");
        String ask = out.get("ask");
        String high = out.get("high");
        String low = out.get("low");
        String last = out.get("last");
        String volume = out.get("volume");
        //vwap Volume Weighted Average Price
        String volume_quote = out.get("volume_quote");
        String open = out.get("open");
        String timestamp = out.get("timestamp");


        return "{\"bid\":" + bid + ",\"ask\":" + ask + ",\"high\":" + high + ",\"low\":"
                + low + ",\"last\":" + last + ",\"volume\":" + volume + ",\"open\":"+ open + ",\"volume_quote\":"+ volume_quote + ",\"timestamp\": " + timestamp + "}";
    }
}
