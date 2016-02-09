package kamp;

public class Main {

	public static void main(String[] args) throws Exception  {
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
		System.out.println("================================");
		Calendar calendar = new Calendar();
		calendar.add(new CalendarEntry("160202", "18:00", "160202", "19:00"));
		calendar.add(new CalendarEntry("160202", "17:00", "160202", "19:00"));
		calendar.add(new CalendarEntry("160202", "16:00", "160202", "19:00"));
		calendar.add(new CalendarEntry("160202", "17:00", "160202", "19:00"));
		System.out.println(calendar);
		System.out.println("++++++++++++++++++++++++++++++ +++++ +++");
		calendar.sort();
		System.out.println(calendar);
	}

}
