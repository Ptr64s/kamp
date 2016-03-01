package kamp;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalendarTest {

	@Test
	public void equals() throws Exception {
		Calendar calendar = new Calendar();
		calendar.add(new CalendarEntry("160202", "18:00", "160204", "17:00"));
		calendar.add(new CalendarEntry("160204", "17:00", "160204", "19:00"));
		calendar.add(new CalendarEntry("160202", "16:00", "160202", "20:00"));
		calendar.add(new CalendarEntry("160202", "17:00", "160202", "21:00"));
		
		List<CalendarEntry> cnstrCalendar = calendar.getEntries();
		
		assertThat(cnstrCalendar.get(0).toString(), equalTo("160202 kl.18:00 - 160204 kl.17:00") );
		assertThat(cnstrCalendar.get(1).toString(), equalTo("160204 kl.17:00 - 160204 kl.19:00") );
		assertThat(cnstrCalendar.get(2).toString(), equalTo("160202 kl.16:00 - 160202 kl.20:00") );
		assertThat(cnstrCalendar.get(3).toString(), equalTo("160202 kl.17:00 - 160202 kl.21:00") );
	}
	@Test
	public void sort() throws Exception {
		Calendar calendar = new Calendar();
		calendar.add(new CalendarEntry("160202", "18:00", "160204", "17:00"));
		calendar.add(new CalendarEntry("160204", "17:00", "160204", "19:00"));
		calendar.add(new CalendarEntry("160202", "16:00", "160202", "20:00"));
		calendar.add(new CalendarEntry("160202", "17:00", "160202", "21:00"));
		
		calendar.sort();
		List<CalendarEntry> sortedCalendar = calendar.getEntries();
		
		assertThat(sortedCalendar.get(0).toString(), equalTo("160202 kl.16:00 - 160202 kl.20:00") );
		assertThat(sortedCalendar.get(1).toString(), equalTo("160202 kl.17:00 - 160202 kl.21:00") );
		assertThat(sortedCalendar.get(2).toString(), equalTo("160202 kl.18:00 - 160204 kl.17:00") );
		assertThat(sortedCalendar.get(3).toString(), equalTo("160204 kl.17:00 - 160204 kl.19:00") );
	}

}
