package kamp;

import org.junit.Test;
import static org.junit.Assert.assertThat;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

public class CollissionFreeCalendarTest {
	
	@Test
	public void addOneEntryEnclosingExistingEntry() throws Exception {
		CollissionFreeCalendar calendar = new CollissionFreeCalendar();
		calendar.add(new CalendarEntry("160202", "18:00", "160204", "17:00"));
		calendar.add(new CalendarEntry("160202", "17:00", "160204", "19:00"));
		
		List<CalendarEntry> cnstrCalendar = calendar.getEntries();
		
		assertThat(cnstrCalendar.size(), equalTo(1));
		assertThat(cnstrCalendar.get(0).toString(), equalTo("160202 kl.17:00 - 160204 kl.19:00") );
	}
	@Test
	public void addOneEntry() throws Exception {
		CollissionFreeCalendar calendar = new CollissionFreeCalendar();
		calendar.add(new CalendarEntry("160202", "18:00", "160204", "17:00"));
		
		List<CalendarEntry> cnstrCalendar = calendar.getEntries();
		
		assertThat(cnstrCalendar.size(), equalTo(1));
		assertThat(cnstrCalendar.get(0).toString(), equalTo("160202 kl.18:00 - 160204 kl.17:00") );
	}
	@Test
	public void addOneEntryNotOverlappingExistingEntry() throws Exception {
		CollissionFreeCalendar calendar = new CollissionFreeCalendar();
		calendar.add(new CalendarEntry("160202", "18:00", "160202", "19:00"));
		calendar.add(new CalendarEntry("160202", "20:00", "160204", "21:00"));
		
		List<CalendarEntry> cnstrCalendar = calendar.getEntries();
		
		assertThat(cnstrCalendar.size(), equalTo(2));
		assertThat(cnstrCalendar.get(0).toString(), equalTo("160202 kl.18:00 - 160202 kl.19:00") );
		assertThat(cnstrCalendar.get(1).toString(), equalTo("160202 kl.20:00 - 160204 kl.21:00") );

	}

}
