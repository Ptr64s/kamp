package kamp;

public class CalendarEntry implements Comparable<CalendarEntry> {
	private CalendarTime beginEvent;
	private CalendarTime endEvent;

	@Deprecated
	public CalendarEntry() throws Exception {
		this.setBeginEvent(new CalendarTime());
		this.setEndEvent(new CalendarTime());
		validate();

	}

	public CalendarEntry(CalendarTime newBeginEvent, CalendarTime newEndEvent) throws Exception {
		this.setBeginEvent(newBeginEvent);
		this.setEndEvent(newEndEvent);
		validate();
	}

	public CalendarEntry(String calendarStartDate, String calendarStartTime, String calendarEndDate,
			String calendarEndTime) throws Exception {
		this.setBeginEvent(new CalendarTime(calendarStartDate, calendarStartTime));
		this.setEndEvent(new CalendarTime(calendarEndDate, calendarEndTime));
		validate();
	}

	public String toString() {
		return getBeginEvent().toString() + " - " + getEndEvent().toString();
	}

	public void validate() throws Exception {
		if (getBeginEvent().getDate().compareTo(getEndEvent().getDate()) > 0) {
			throw new Exception("end date before begin date!!");
		}
		if (getBeginEvent().getDate().compareTo(getEndEvent().getDate()) == 0) {
			if (getBeginEvent().getTime().compareTo(getEndEvent().getTime()) > 0) {
				throw new Exception("end time before begin time!!");
			}
		}
		
	}
	
	public boolean startsBefore(CalendarTime time){
		if (time.compareTo(getBeginEvent())<0)
			return false;
		return true;
	}
	
	public boolean endsAfter(CalendarTime time){
		if (time.compareTo(getEndEvent())>0)
			return false;
		return true;
	}
	public boolean inside(CalendarTime time){
		if (startsBefore(time) && endsAfter(time))
			return true;
		return false;
	}
	
	

	@Override
	public int compareTo(CalendarEntry o) {
		return getBeginEvent().compareTo(o.getBeginEvent());
		// TODO Auto-generated method stub

	}

	public CalendarTime getBeginEvent() {
		return beginEvent;
	}

	public void setBeginEvent(CalendarTime beginEvent) {
		this.beginEvent = beginEvent;
	}

	public CalendarTime getEndEvent() {
		return endEvent;
	}

	public void setEndEvent(CalendarTime endEvent) {
		this.endEvent = endEvent;
	}
}
