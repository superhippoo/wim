package com.wim.util;

import java.util.Calendar;
import java.util.Random;

public class uidUtil {
	
	public static String generateUid(String type) {
		Random generator = new Random();       
		Calendar cal = Calendar.getInstance();
		
        int year = cal.get(Calendar.YEAR);
        int mon = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        int milsec = cal.get(Calendar.MILLISECOND);
        int ran = generator.nextInt(999)+1;
        
		String uid = ""+type+year+mon+day+hour+min+sec+milsec+ran;

		return uid;
		
	}

}
