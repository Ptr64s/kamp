package kamp;

import java.util.Calendar;

public class CalendarTime {
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

	public int compareTo(CalendarTime calendarTime) {
		return this.time.compareTo(calendarTime.time);
		
	}

}
