/**
 * 
 */
package fr.udara.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 * @author Udara
 *
 */
public class DateFormatUtil {
	
	/**
	 * Retourne une date donner en format String
	 * 
	 * @param dateTime
	 * @return
	 */
	public static String paseDateToString(LocalDateTime dateTime) {
		
		DateFormat dateformat = new SimpleDateFormat("dd mm yyyy hh:mm:ss");
		
		String strDate = dateformat.format(dateTime);
		
		return strDate;
		
	}

}
