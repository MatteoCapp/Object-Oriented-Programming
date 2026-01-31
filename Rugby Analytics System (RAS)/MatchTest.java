import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Iterator;

public class MatchTest {

    // test to see if is give me the specific error if i add a Match wrongly
    @Test
    public void testMatchSanitization() {

        // assertThrows because has to give me an error
        assertThrows(IllegalArgumentException.class, () -> {
            new Match("", "Sole", "01-01-2026", "25-26", true);
        });
    }

    // test to see if there is any error if i add an event
    @Test
    public void testAddEventToMatch() {
        Match match = new Match("PVR Rugby", "Pioggia", "10-10-2025", "25-26", false);
        Event event = new Event(1, 10, "Home", 10.0, 10.0);
        
        assertDoesNotThrow(() -> match.addEvent(event));
    }

    // test for pattern iterator
    @Test
    public void testMatchIterator() {
        Match match = new Match("Test Team", "Cloudy", "2026-01-01", "25-26", true);
        Event event1 = new Event(1, 5, "Home", 0, 0);
        match.addEvent(event1);

        Iterator<Event> it = match.iterator();
        
        //pointer goes to zero, so event is the first
        assertTrue(it.hasNext(), "Iterator has at least one element");
        assertEquals(event1, it.next(), "If true we are good");
    }
}