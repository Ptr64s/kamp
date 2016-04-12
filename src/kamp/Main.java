package kamp;

public class Main {

	public static void main(String[] args) throws Exception  {
		//oldStuff();
		//System.out.println("================================");
		CollissionFreeCalendar calendar = new CollissionFreeCalendar();
		calendar.add(new CalendarEntry("160205", "16:00", "160205", "21:00"));
		calendar.add(new CalendarEntry("160205", "22:00", "160205", "23:00"));
		//calendar.add(new CalendarEntry("160205", "18:00", "160205", "19:00"));

		System.out.println(calendar);
		System.out.println("++++++++++++++++++++++++++++++ +++++ +++");
		calendar.sort();
		System.out.println(calendar);
		//System.out.println(calendar.calendar.get(2).inside(new CalendarTime("160204", "20:00")));
		System.out.println(new CalendarEntry("160202", "17:00", "160202", "21:00")
				.contains(CalendarEntry.parseLegacyDateTime("160202", "22:00")));
	}

}
