package com.bitcollect;

import org.bson.Document;

/**
 * Created by simonas on 15. 10. 18.
 */
public class StringDuplicate {
    public static String check(String jsonText){
        String generatedText;

        generatedText  = jsonText.substring(0,jsonText.lastIndexOf("timestamp"));
        return generatedText;
        // turesiu problemu su tais, kurie neturi timestamp;
    }
}
