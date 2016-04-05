package kamp;

import java.time.LocalDateTime;

public class CalendarEntry implements Comparable<CalendarEntry> {
	private LocalDateTime beginEvent;
	private LocalDateTime endEvent;

//	@Deprecated
//	public CalendarEntry() throws Exception {
//		this.setBeginEvent(new CalendarTime());
//		this.setEndEvent(new CalendarTime());
//		validate();
//
//	}

	public CalendarEntry(LocalDateTime newBeginEvent, LocalDateTime newEndEvent) throws Exception {
		this.setBeginEvent(newBeginEvent);
		this.setEndEvent(newEndEvent);
		//validate();
	}

//	public CalendarEntry(String calendarStartDate, String calendarStartTime, String calendarEndDate,
//			String calendarEndTime) throws Exception {
//		this.setBeginEvent(new CalendarTime(calendarStartDate, calendarStartTime));
//		this.setEndEvent(new CalendarTime(calendarEndDate, calendarEndTime));
//		validate();
//	}

	public String toString() {
		return getBeginEvent().toString() + " - " + getEndEvent().toString();
	}

//	public void validate() throws Exception {
//		if (getBeginEvent().getDate().compareTo(getEndEvent().getDate()) > 0) {
//			throw new Exception("end date before begin date!!");
//		}
//		if (getBeginEvent().getDate().compareTo(getEndEvent().getDate()) == 0) {
//			if (getBeginEvent().getTime().compareTo(getEndEvent().getTime()) > 0) {
//				throw new Exception("end time before begin time!!");
//			}
//		}
//		
//	}
	
	public boolean startsBefore(LocalDateTime time){
		return time.isAfter(beginEvent);
	}
	
	public boolean startsAfter(LocalDateTime time) {
		return time.isBefore(beginEvent);
	}
	
	// calenderEntry.endsAfter(time)
	public boolean endsAfter(LocalDateTime time) {
		return time.isBefore(endEvent);
	}
	
	public boolean contains(LocalDateTime time){
		return startsBefore(time) && endsAfter(time);
	}

	@Override
	public int compareTo(CalendarEntry o) {
		return getBeginEvent().compareTo(o.getBeginEvent());
	}

	public LocalDateTime getBeginEvent() {
		return beginEvent;
	}

	public void setBeginEvent(LocalDateTime beginEvent) {
		this.beginEvent = beginEvent;
	}

	public LocalDateTime getEndEvent() {
		return endEvent;
	}

	public void setEndEvent(LocalDateTime endEvent) {
		this.endEvent = endEvent;
	}
	
	public boolean intersects(CalendarEntry entry) {
		return beginEvent.isBefore(entry.getEndEvent()) && entry.getBeginEvent().isBefore(endEvent);
	}

};
