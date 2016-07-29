package utils;

import java.sql.Timestamp;

public class DateTimeUtils {
	public static Timestamp str2Timestamp(String s){
	    Timestamp ts = new Timestamp(System.currentTimeMillis());    
        try {   
            ts = Timestamp.valueOf(s);   
        } catch (Exception e) {   
            e.printStackTrace();   
        }  
        return ts;
	}
}
