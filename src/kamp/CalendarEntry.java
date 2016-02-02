package kamp;

public class CalendarEntry {
	CalendarTime beginEvent;
	CalendarTime endEvent;

	public CalendarEntry() {
		this.beginEvent = new CalendarTime();
		this.endEvent = new CalendarTime();

	}

	public CalendarEntry(CalendarTime newBeginEvent, CalendarTime newEndEvent) {
		this.beginEvent = newBeginEvent;
		this.endEvent = newEndEvent;
	}

	public CalendarEntry(String calendarStartDate, String calendarStartTime, String calendarEndDate,
			String calendarEndTime) throws Exception {
		this.beginEvent = new CalendarTime(calendarStartDate, calendarStartTime);
		this.endEvent = new CalendarTime(calendarEndDate, calendarEndTime);
		validate();
	}

	public String toString() {
		return beginEvent.toString() + " - " + endEvent.toString();
	}

	public void validate() throws Exception {
		if (beginEvent.getDate().compareTo(endEvent.getDate()) > 0) {
			throw new Exception("end date before begin date!!");
		}
		if (beginEvent.getTime().compareTo(endEvent.getTime()) > 0) {
			throw new Exception("end time before begin time!!");
		}
		
	}
}
