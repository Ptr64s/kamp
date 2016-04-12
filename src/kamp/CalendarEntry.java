package kamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CalendarEntry implements Comparable<CalendarEntry> {
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHH:mm");
	private static DateTimeFormatter toStringFormatter = DateTimeFormatter.ofPattern("yyMMdd' kl.'HH:mm");
	
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
		validate();
	}
	
	@Deprecated
	public CalendarEntry(String calendarStartDate, String calendarStartTime, String calendarEndDate,
			String calendarEndTime) throws Exception {
		this(LocalDateTime.parse(calendarStartDate + calendarStartTime, formatter),
				LocalDateTime.parse(calendarEndDate + calendarEndTime, formatter));
	}
	
	public String toString() {
		
		return toStringFormatter.format(beginEvent) + " - " + toStringFormatter.format(endEvent);
	}

	public void validate() throws Exception {
		if(!endEvent.isAfter(beginEvent))
			throw new Exception("end date is not after begin date!!");
		
		
	}
	
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
		return (beginEvent.isBefore(entry.getEndEvent()) && entry.getBeginEvent().isBefore(endEvent)) || endEvent.isEqual(entry.beginEvent) || entry.endEvent.isEqual(beginEvent);
		//return beginEvent.isBefore(entry.getEndEvent()) && entry.getBeginEvent().isBefore(endEvent);
	}
	
	public static LocalDateTime parseLegacyDateTime(String startDate, String startTime){
		return LocalDateTime.parse(startDate + startTime, formatter);
	}

};
