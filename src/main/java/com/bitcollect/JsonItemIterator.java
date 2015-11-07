package com.bitcollect;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONException;
import java.util.Iterator;

/**
 * Created by simonas on 15. 10. 25.
 */
public class JsonItemIterator {
    public static Map<String,String> parse(JSONObject json , Map<String,String> out) throws JSONException{
        Iterator keys = json.keys();
        while(keys.hasNext()){
            String key = (String) keys.next();
            String val = null;
            try{
                JSONObject value = json.getJSONObject(key);
                parse(value,out);
            }catch(Exception e){
                val = json.getString(key);
            }

            if(val != null){
                out.put(key,val);
            }
        }
        return out;
    }

}
