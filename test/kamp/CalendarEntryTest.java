package kamp;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CalendarEntryTest {
	
	@Test
	public void createCalendarEntry() throws Exception {
		CalendarEntry calendarEntry = new CalendarEntry("160301", "1800", "160301", "1900");
		assertThat(calendarEntry.toString(), equalTo("160301 kl.1800 - 160301 kl.1900") );
	}
}
