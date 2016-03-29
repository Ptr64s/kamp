package kamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calendar {
	List<CalendarEntry> calendar;

	public Calendar() {
		calendar = new ArrayList<CalendarEntry>();
	}
	
	public Calendar(List<CalendarEntry> newCalendar) {
		this.calendar = newCalendar;
	}

	public void add(CalendarEntry calendarEntry) {
		calendar.add(calendarEntry);
	}
	
	List<CalendarEntry> getEntries() {
		return this.calendar;
	}

	public String toString() {
		String result = "";
		for (CalendarEntry entry : calendar) {
			result = result + entry.toString() + "\n";
		}
		return result;
	}
	public void sort(){
		Collections.sort(calendar);
	}

}
