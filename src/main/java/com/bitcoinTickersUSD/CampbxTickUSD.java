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
public class CampbxTickUSD {


/*{"Last Trade":"312.00","Best Bid":"319.01","Best Ask":"340.99"}
*/

    public static String campbx(JSONObject json) throws JSONException {
        //this exchange sites doesnt have timestamp
        Date timestamp = new Date();

        Map<String, String> out = new HashMap<String, String>();
        JsonItemIterator.parse(json, out);

        String bid = out.get("Best Bid"); // best bid, best trade
        String ask = out.get("Best Ask");
        String last = out.get("Last Trade");
        return "{\"best_bid\":" + bid + ",\"best_ask\":" + ask +",\"last\":" + last
                + ",\"timestamp\": " + timestamp.getTime() + "}";
    }
}
