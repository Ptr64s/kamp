package kamp;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CalendarEntryTest {
	
	@Test
	public void createCalendarEntry() throws Exception {
		CalendarEntry calendarEntry = new CalendarEntry("160301", "18:00", "160301", "19:00");
		assertThat(calendarEntry.toString(), equalTo("160301 kl.18:00 - 160301 kl.19:00") );
	}
	@Test(expected=Exception.class)
	public void doNotAllowStartTimeAfterEndTime() throws Exception {
		CalendarEntry calendarEntry = new CalendarEntry("160301", "20:00", "160301", "19:00");
	}
	@Test(expected=Exception.class)
	public void doNotAllowStartDateAfterEndDate() throws Exception {
		CalendarEntry calendarEntry = new CalendarEntry("160302", "18:00", "160301", "19:00");
	}

}
