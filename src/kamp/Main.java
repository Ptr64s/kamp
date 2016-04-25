package kamp;

import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args) throws Exception  {
		//oldStuff();
		//System.out.println("================================");
		CollissionFreeCalendar calendar = new CollissionFreeCalendar();
		calendar.add(new CalendarEntry("160205", "16:00", "160205", "21:00"));
		calendar.add(new CalendarEntry("160205", "17:00", "160205", "20:00"));
		calendar.add(new CalendarEntry("160206", "16:00", "160206", "21:00"));
		calendar.add(new CalendarEntry("160207", "11:00", "160207", "13:00"));
		calendar.add(new CalendarEntry("160207", "10:00", "160207", "12:00"));
		calendar.add(new CalendarEntry("160209", "09:00", "160209", "14:00"));
		calendar.add(new CalendarEntry("160211", "22:00", "160211", "23:00"));
		//calendar.add(new CalendarEntry("160205", "18:00", "160205", "19:00"));

		//System.out.println(calendar);
		//System.out.println("++++++++++++++++++++++++++++++ +++++ +++");
		calendar.sort();
		System.out.println(calendar);
		//System.out.println(calendar.calendar.get(2).inside(new CalendarTime("160204", "20:00")));
		//System.out.println(new CalendarEntry("160202", "17:00", "160202", "21:00")
		//		.contains(CalendarEntry.parseLegacyDateTime("160202", "22:00")));
		
		LocalDateTime start = LocalDateTime.now().withMonth(2).withDayOfMonth(1);
		LocalDateTime end = start.plusMonths(10);
		
		System.out.println(calendar.invert(start, end));
		start = LocalDateTime.now().withMonth(2).withDayOfMonth(5).withHour(17);
		System.out.println(calendar.invert(start, end));
		
	}

}
