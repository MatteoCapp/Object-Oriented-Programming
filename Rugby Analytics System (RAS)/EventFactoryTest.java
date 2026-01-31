import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EventFactoryTest {

    @Test
    public void testCreateScrum () {

        // create a new factory
        EventFactory factory = new EventFactory();

        // create an test event scrum
        Event result = factory.createEvent(1, 10, "PVR", 50.0, 20.0, "Dominante", "", "SCRUM", "", false, "Ocio nero", "Picci", "Completa", "2", "No", "PRV", "Tenuto", "Pali", true,"");

        //let's control the object created if it is false test is going to fail
        assertTrue(result instanceof Scrum);

        //let's control one data inside
        assertEquals(10, result.getDurationSeconds());
    }
}