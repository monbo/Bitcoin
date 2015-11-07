package com.bitcoinTickersUSD;

import com.bitcollect.JsonItemIterator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by simonas on 15. 11. 1.
 */
public class BitkonanTickUSD {

    /*{"last":"290.00","high":"290.00","low":"288.98","bid":"288.91","ask":"291.95","open":"287.49","volume":"3.97534562"}*/

    public static String bitkonan(JSONObject json) throws JSONException {
        //this exchange sites doesnt have timestamp
        Date timestamp = new Date();

        Map<String, String> out = new HashMap<String, String>();
        JsonItemIterator.parse(json, out);

        String bid = out.get("bid");
        String ask = out.get("ask");
        String high = out.get("high");
        String low = out.get("low");
        String last = out.get("last");
        String volume = out.get("volume");
        String open = out.get("open");


        return "{\"bid\":" + bid + ",\"ask\":" + ask + ",\"high\":" + high + ",\"low\":" + low + ",\"last\":"
                + last + ",\"volume\":" + volume + ",\"open\":" + open + ",\"timestamp\": " + timestamp.getTime() + "}";
    }
}
