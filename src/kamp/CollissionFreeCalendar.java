package kamp;

public class CollissionFreeCalendar extends Calendar {

	@Override
	public void add(CalendarEntry newEntry) {
		// TODO Auto-generated method stub
		if(calendar.isEmpty()) {
			super.add(newEntry);
		} else {
			CalendarEntry previousStartEntry = null;
			for(CalendarEntry entry:calendar) {
				if(entry.startsBefore(newEntry.getBeginEvent())) {
					
					break;
				}
				previousStartEntry = entry;
			}
			CalendarEntry previousEndEntry = null;
			for(CalendarEntry entry:calendar) {
				if(entry.endsAfter(newEntry.getEndEvent())) {
					previousEndEntry = entry;
					break;
				}
			}
			//Check if newEntry surrounds one existing CalendarEntry
			if(previousStartEntry.equals(previousEndEntry)) {
				calendar.set(calendar.indexOf(previousStartEntry), newEntry);
			}
			
			
			
		}	
		
		
	}

}
