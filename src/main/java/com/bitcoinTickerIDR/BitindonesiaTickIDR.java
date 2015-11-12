package com.bitcoinTickerIDR;

import com.bitcollect.JsonItemIterator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by simonas on 15. 11. 8.
 */
public class BitindonesiaTickIDR {

   /* {"ticker":{"high":"5374900",
            "low":"5250000","vol_btc":
        "1581.03059870","vol_idr":"8400335390","last":"5295000","buy":"5294900","sell":"5295000","server_time":1446973726}}*/

    public static String bitIndonesia(JSONObject json) throws JSONException {
        Map<String, String> out = new HashMap<String, String>();
        JsonItemIterator.parse(json, out);

        String bid = out.get("buy");
        String ask = out.get("sell");
        String high = out.get("high");
        String low = out.get("low");
        String last = out.get("last");
        String volume = out.get("vol_btc");
        String volume_idr = out.get("vol_idr");
        String timestamp = out.get("server_time");


        return "{\"bid\":" + bid + ",\"ask\":" + ask + ",\"high\":" + high + ",\"low\":"
                + low + ",\"last\":" + last + ",\"volume\":" + volume + ",\"volume_idr\":"+ volume_idr + ",\"timestamp\": " + timestamp + "}";
    }

}
