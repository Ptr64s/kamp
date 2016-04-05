package kamp;

import java.time.Duration;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calendar {
	List<Period> calendar;

	public Calendar() {
		calendar = new ArrayList<>();
	}
	
	public Calendar(List<Period> newCalendar) {
		this.calendar = newCalendar;
	}

	public void add(Period calendarEntry) throws Exception {
		calendar.add(calendarEntry);
	}
	List<Period> getEntries() {
		Duration d;
		return this.calendar;
	}

	public String toString() {
		String result = "";
		for (Period entry : calendar) {
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
