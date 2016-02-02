package kamp;

public class Main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		CalendarEntry testEntry = new CalendarEntry();
		System.out.println(testEntry.toString());
		CalendarTime newBeginEvent = new CalendarTime("160101", "17:00");
		CalendarTime newEndEvent = new CalendarTime("160101", "19:00");
		CalendarEntry test2Entry = new CalendarEntry(newBeginEvent, newEndEvent);
		System.out.println(test2Entry.toString());
		CalendarEntry test3Entry;
		try {
			test3Entry = new CalendarEntry("160202", "17:00", "160202", "19:00");
			System.out.println(test3Entry.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("validerar ej "+ e.getMessage());
		}
		
	}

}
