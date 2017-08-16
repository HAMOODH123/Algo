package com.util;

import edu.princeton.cs.algs4.Date;
import static com.util.Print.*;

public class SmartDate extends Date{
	public SmartDate(int month, int day, int year) {
		super(month, day, year);
	}
	
	public String dayOfTheWeek() {
//		 W = (d+2*m+3*(m+1)/5+y+y/4-y/100+y/400) mod 7
		int result = (day() + 2*month() + 3*(month()+1)/5 + year() 
				      + year()/4 - year()/100 + year()/400) % 7;
		String weekDay = null;
		
		switch(result) {
		case 0:
			weekDay = "Monday";break;
		case 1:
			weekDay = "Tuesday";break;
		case 2:
			weekDay = "Wednesday";break;
		case 3:
			weekDay = "Thursday";break;
		case 4:
			weekDay = "Friday";break;
		case 5:
			weekDay = "Saturday";break;
		case 6:
			weekDay = "Sunday";break;			
		}
		return weekDay;
	}

	public static void main(String[] args) {
		SmartDate d = new SmartDate(5, 5, 2017);
		println(d.dayOfTheWeek());
	}
}
