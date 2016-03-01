package kamp;

import java.util.Calendar;

public class CalendarTime implements Comparable<CalendarTime> {
	private String date;
	private String time;

	public CalendarTime() {
		date = "160101";
		time = "15:00";

	}
	
	public CalendarTime(String date, String time) {
		this.date = date;
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public String toString(){
		return getDate()+" kl."+getTime();
	}
	
//	public boolean equal
	
	// fredriksCalendertime.compareTo(andersCalenderTime)
	
	//anders
	@Override
	public int compareTo(CalendarTime calendarTime) {
		if (this.date.compareTo(calendarTime.date) != 0) {
			return this.date.compareTo(calendarTime.date);
		}
		return this.time.compareTo(calendarTime.time);
		
	}

}
