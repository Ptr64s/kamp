package kamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CollissionFreeCalendar extends Calendar {
	
	public CollissionFreeCalendar invert(LocalDateTime start, LocalDateTime end) throws Exception {
		CollissionFreeCalendar result = new CollissionFreeCalendar();
		
		List<LocalDateTime> list = new ArrayList<>();
		list.add(start);
		for (CalendarEntry e : eventsToConsider(start, end)) {
			list.add(e.getBeginEvent());
			list.add(e.getEndEvent());
		}
		list.add(end);
		
		int i = 0;
		while (i < list.size()) {
			result.add(new CalendarEntry(list.get(i++), list.get(i++)));
		}
		
		return result;
	}
	
	private List<CalendarEntry> eventsToConsider(LocalDateTime start, LocalDateTime end) {
		List<CalendarEntry> result = new ArrayList<>();
		
		for (CalendarEntry e : calendar) {
			
		}
		
		return result;
	}
	
	@Override
	public void add(CalendarEntry newEntry) throws Exception {
		// vi måste skapa intersects-metoden
		
			List<CalendarEntry> tempColissionFreeCalendar = new ArrayList<CalendarEntry>();
			List<CalendarEntry> tempColissionCalendar = new ArrayList<CalendarEntry>();
			tempColissionCalendar.add(newEntry);
			for (CalendarEntry entry:calendar) {
				if (entry.intersects(newEntry)) {
					tempColissionCalendar.add(entry);
				} else {
					tempColissionFreeCalendar.add(entry);
				}
			}
			LocalDateTime tempStart = null;
			LocalDateTime tempEnd = null;
			
			for (CalendarEntry entry:tempColissionCalendar) {
				if (tempStart == null || tempStart.compareTo(entry.getBeginEvent())> 0) {
					tempStart = entry.getBeginEvent(); 
				}
				if (tempEnd == null || tempEnd.compareTo(entry.getEndEvent())< 0) {
					tempEnd = entry.getEndEvent(); 
				}
			}
			CalendarEntry tempEntry = new CalendarEntry(tempStart, tempEnd);
				tempColissionFreeCalendar.add(tempEntry);
				calendar = tempColissionFreeCalendar;
				
				
				
/*			för varje entry i calendar: testa om det överlappar med newEntry
				Om det inte överlappar - hoppa till nästa entry i calendar
				Om det överlappar - hoppa till "så länge som det överlappar"
			
			
			Så länge som det det överlappar: 
				1. Ta entryt som överlappade och flyttar till ny temp. lista
				2. Hoppa till nästa entry i calendar
		
				
			När det inte överlappar längre: Då ska vi jobba med temp.listan
			
			Templistjobb: ta den starttid som är först och den sluttid som är sist och av detta skapar vi ett nytt CalendarEntry
			
			Efter skapande av nytt CalendarEntry lägger vi in detta i Calendar
			
			Sist sorterar vi calendar
			
			
			Om inget överlapp hittades: lägg in newEntry sist i calendar och sortera calendar
	*/		
	}

}
