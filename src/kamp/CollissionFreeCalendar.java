package kamp;

public class CollissionFreeCalendar extends Calendar {

	@Override
	public void add(CalendarEntry newEntry) {
		// TODO Auto-generated method stub
		if(calendar.isEmpty()) {
			super.add(newEntry);
		} else {
			//startiden skall positionera sig efter index för previousStartEntry
			CalendarEntry previousStartEntry = null;
			for(CalendarEntry entry:calendar) {
				if(!entry.startsBefore(newEntry.getBeginEvent())) {
					
					break;
				}
				previousStartEntry = entry;
			}
			//sluttiden skall positionera sig innan index för firstEndEntryAfter
			CalendarEntry firstEndEntryAfter = null;
			for(CalendarEntry entry:calendar) {
				if(entry.endsAfter(newEntry.getEndEvent())) {
					firstEndEntryAfter = entry;
					break;
				}
			}
			//Check if newEntry surrounds one existing CalendarEntry
			if(previousStartEntry.equals(firstEndEntryAfter)) {
				calendar.set(calendar.indexOf(previousStartEntry), newEntry);
			}
			
			
			
		}	
		
		
	}

}
