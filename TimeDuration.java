package org.eclipse.Duration;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;
import static java.time.temporal.ChronoUnit.SECONDS;
import java.time.Duration;

public class TimeDuration {
public static void main(String[] args) {
	DurationTwoDays();

	String dateStart = "01/14/2012 09:29:58";
	String dateStop = "01/15/2012 10:31:48";

	//HH converts hour in 24 hours format (0-23), day calculation
	SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	Date d1 = null;
	Date d2 = null;

	try {
		d1 = format.parse(dateStart);
		d2 = format.parse(dateStop);

		//in milliseconds
		long diff = d2.getTime() - d1.getTime();

		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);

		System.out.print(diffDays + " days, ");
		System.out.print(diffHours + " hours, ");
		System.out.print(diffMinutes + " minutes, ");
		System.out.print(diffSeconds + " seconds.");

	} catch (Exception e) {
		e.printStackTrace();
	}
}


	
	public static void DurationTwoDays() {
	
    Duration d = Duration.ZERO.plus(2, DAYS).plus(3, HOURS).plus(12, MINUTES).plus(46, SECONDS);

    
    if(d.isNegative()) d = d.negated();

    
    System.out.printf("Total duration is %sdays %shrs %smin %ssec.\n", d.toDays(), d.toHours() % 24, d.toMinutes() % 60, d.getSeconds() % 60);

    
    System.out.printf("Or total duration is %shrs %smin %sec.\n", d.toHours(), d.toMinutes() % 60, d.getSeconds() % 60);

     
    System.out.printf("Or total duration is %smin %ssec.\n", d.toMinutes(), d.getSeconds() % 60);

    
    System.out.printf("Or total duration is %ssec.\n", d.getSeconds());
}

}


