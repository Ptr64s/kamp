package kamp;

import java.time.Duration;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calendar {
	List<CalendarEntry> calendar;

	public Calendar() {
		calendar = new ArrayList<>();
	}
	
	public Calendar(List<CalendarEntry> newCalendar) {
		this.calendar = newCalendar;
	}

	public void add(CalendarEntry calendarEntry) throws Exception {
		calendar.add(calendarEntry);
	}
	List<CalendarEntry> getEntries() {
		Duration d;
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
	
	// with-margin-minutes: int
	
	/**
	 * with-margin: "00:15"
	 * @param timeString
	 * @return new calendar
	 */
	public Calendar withMargins(String timeString) {
		return null;
	}

}
