package kamp;

public class CalendarEntry implements Comparable<CalendarEntry> {
	CalendarTime beginEvent;
	CalendarTime endEvent;

	@Deprecated
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
		if (beginEvent.getDate().compareTo(endEvent.getDate()) == 0) {
			if (beginEvent.getTime().compareTo(endEvent.getTime()) > 0) {
				throw new Exception("end time before begin time!!");
			}
		}
		
	}
	
	public boolean before(CalendarTime time){
		if (time.compareTo(beginEvent)>0)
			return false;
		return true;
	}
	
	public boolean after(CalendarTime time){
		if (time.compareTo(endEvent)<0)
			return false;
		return true;
	}
	public boolean inside(CalendarTime time){
		if (before(time) || after(time))
			return false;
		return true;
	}
	
	

	@Override
	public int compareTo(CalendarEntry o) {
		return beginEvent.compareTo(o.beginEvent);
		// TODO Auto-generated method stub

	}
}
