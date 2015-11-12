package com.bitcoinTickersCNY;

import com.bitcollect.JsonItemIterator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by simonas on 15. 11. 8.
 */
public class BtccTickCNY {
/*    {"ticker":
{"high":"2619.75","low":"2525.00","buy":"2567.51","sell":"2568.14",
"last":"2567.14","vol":"57058.44300000","date":1446967549,
                "vwap":"2583.7","prev_close":"2566.07","open":"2566.07"}}*/
    public static String btcc(JSONObject json) throws JSONException {


        Map<String, String> out = new HashMap<String, String>();
        JsonItemIterator.parse(json, out);

        String bid = out.get("buy");
        String ask = out.get("sell");
        String high = out.get("high");
        String low = out.get("low");
        String last = out.get("last");
        String volume = out.get("vol");
        String vwap = out.get("vwap");
        String prev_close = out.get("prev_close");
        String open = out.get("open");
        String timestamp = out.get("date");


        return "{\"bid\":" + bid + ",\"ask\":" + ask + ",\"high\":" + high + ",\"low\":" + low + ",\"last\":"
                + last + ",\"volume\":" + volume + ",\"vwap\":" + vwap + ",\"prev_close\":" + prev_close +",\"open\":" + open +",\"timestamp\": " + timestamp + "}";
    }
}

