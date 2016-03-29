package kamp;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;

public class CalendarEntryTest {
	@Test
	public void createCalendarEntry() throws Exception{
		CalendarEntry calendarEntry = new CalendarEntry("160301", "20:00", "160301", "23:00");
		assertThat(calendarEntry.toString(),equalTo("160301 kl.20:00 - 160301 kl.23:00"));
	}
	@Test(expected = Exception.class)
	public void doNotAllowEndtimeBeforeStartTime() throws Exception{
		CalendarEntry calendarEntry = new CalendarEntry("160301", "20:00", "160301", "19:00");
		
	}
	@Test(expected=Exception.class)
	public void doNotAllowStartDateAfterEndDate() throws Exception {
		CalendarEntry calendarEntry = new CalendarEntry("160302", "18:00", "160301", "19:00");
	}
	
	@Test
	public void aBeforeBIntersectsReturnsFalse() throws Exception {
		CalendarEntry a = new CalendarEntry("160301", "18:00", "160301", "19:00");
		CalendarEntry b = new CalendarEntry("160302", "18:00", "160302", "19:00");
		assertFalse(a.intersects(b));
	}
	
	@Test
	public void aEndInsideBIntersectsReturnsTrue() throws Exception {
		CalendarEntry a = new CalendarEntry("160301", "18:00", "160302", "19:00");
		CalendarEntry b = new CalendarEntry("160302", "18:00", "160302", "20:00");
		assertTrue(a.intersects(b));
	}
	
	@Test
	public void aEndsAtStartOfBIntersectsReturnsTrue() throws Exception {
		CalendarEntry a = new CalendarEntry("160301", "18:00", "160301", "19:00");
		CalendarEntry b = new CalendarEntry("160301", "19:00", "160302", "19:00");
		assertTrue(a.intersects(b));
	}
	
	@Test
	public void aInsideBIntersectsReturnsTrue() throws Exception {
		CalendarEntry a = new CalendarEntry("160301", "18:00", "160301", "19:00");
		CalendarEntry b = new CalendarEntry("160301", "17:00", "160302", "19:00");
		assertTrue(a.intersects(b));
	}
	
	@Test
	public void aEqualsBIntersectsReturnsTrue() throws Exception {
		CalendarEntry a = new CalendarEntry("160301", "18:00", "160301", "19:00");
		CalendarEntry b = new CalendarEntry("160301", "18:00", "160301", "19:00");
		assertTrue(a.intersects(b));
	}
	
}
