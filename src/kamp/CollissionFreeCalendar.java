package kamp;

public class CollissionFreeCalendar extends Calendar {

	@Override
	public void add(CalendarEntry newEntry) {
		// TODO Auto-generated method stub
		if(calendar.isEmpty()) {
			super.add(newEntry);
		} 
		//else if(calendar.get(0).startsAfter(newEntry.getEndEvent())){
			
		//}
		else{
			//startiden skall positionera sig efter index för previousStartEntry
			CalendarEntry previousStartEntry = null;
			for(CalendarEntry entry:calendar) {
				if(!entry.startsBefore(newEntry.getBeginEvent())) {
					
					break;
				}
				previousStartEntry = entry;
			}
			System.out.println(previousStartEntry);
			//sluttiden skall positionera sig innan index för firstEndEntryAfter
			CalendarEntry firstEndEntryAfter = null;
			for(CalendarEntry entry:calendar) {
				if(entry.endsAfter(newEntry.getEndEvent())) {
					firstEndEntryAfter = entry;
					break;
				}
			}
			System.out.println(firstEndEntryAfter);
			
			//Kollar om den andra tiden läggs in på plats två när det bara finns ett tidigare inlägg
			if(calendar.indexOf(previousStartEntry) == 0 && firstEndEntryAfter == null) {
				System.out.println("new second slot");
			}
			
			if(previousStartEntry == null && calendar.indexOf(firstEndEntryAfter) == 0) {
				System.out.println("new first slot");
			}
			
			//Check if newEntry is surrounded by one existing CalendarEntry
			if(calendar.indexOf(previousStartEntry) == calendar.indexOf(firstEndEntryAfter)) {
				//calendar.set(calendar.indexOf(previousStartEntry), newEntry);
				System.out.println("surrounded");
			}
			
			if(calendar.indexOf(previousStartEntry) < calendar.indexOf(firstEndEntryAfter)) {
				if(firstEndEntryAfter.startsBefore(newEntry.getEndEvent())) {
					//lite till + sätt firstentryafters sluttid som sluttid till PreviousEntry och ta bort allt mellan previousentry och firstentryafter inkl. firstentryafter
					System.out.println("First entry after begins before end of new event");
				}
				else {
					if(previousStartEntry.endsAfter(newEntry.getBeginEvent())) {
						System.out.println("new slot");
						
					} else {
						System.out.println("extent slot that begins before new entry");
					}
					
				}
			}
			
			
		}	
		
		
	}
	
	public void add2(CalendarEntry newEntry) {
		// TODO Auto-generated method stub
		if(calendar.isEmpty()) {
			super.add(newEntry);
		} 
		else{
			
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
			
			//startiden skall positionera sig efter index för previousStartEntry
			CalendarEntry previousStartEntry = null;
			for(CalendarEntry entry:calendar) {
				if(!entry.startsBefore(newEntry.getBeginEvent())) {
					
					break;
				}
				previousStartEntry = entry;
			}
			System.out.println(previousStartEntry);
			//sluttiden skall positionera sig innan index för firstEndEntryAfter
			CalendarEntry firstEndEntryAfter = null;
			for(CalendarEntry entry:calendar) {
				if(entry.endsAfter(newEntry.getEndEvent())) {
					firstEndEntryAfter = entry;
					break;
				}
			}
			System.out.println(firstEndEntryAfter);
			
			//Kollar om den andra tiden läggs in på plats två när det bara finns ett tidigare inlägg
			if(calendar.indexOf(previousStartEntry) == 0 && firstEndEntryAfter == null) {
				System.out.println("new second slot");
			}
			
			if(previousStartEntry == null && calendar.indexOf(firstEndEntryAfter) == 0) {
				System.out.println("new first slot");
			}
			
			//Check if newEntry is surrounded by one existing CalendarEntry
			if(calendar.indexOf(previousStartEntry) == calendar.indexOf(firstEndEntryAfter)) {
				//calendar.set(calendar.indexOf(previousStartEntry), newEntry);
				System.out.println("surrounded");
			}
			
			if(calendar.indexOf(previousStartEntry) < calendar.indexOf(firstEndEntryAfter)) {
				if(firstEndEntryAfter.startsBefore(newEntry.getEndEvent())) {
					//lite till + sätt firstentryafters sluttid som sluttid till PreviousEntry och ta bort allt mellan previousentry och firstentryafter inkl. firstentryafter
					System.out.println("First entry after begins before end of new event");
				}
				else {
					if(previousStartEntry.endsAfter(newEntry.getBeginEvent())) {
						System.out.println("new slot");
						
					} else {
						System.out.println("extent slot that begins before new entry");
					}
					
				}
			}
			
			
		}	
		
		
	}

}
