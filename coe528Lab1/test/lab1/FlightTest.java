package lab1;

/**
 *
 * @author sajoshi
 */



import org.junit.Test;
import static org.junit.Assert.*;

public class FlightTest {

    @Test
    public void testConstructor() {
        Flight flight = new Flight(1001, "Toronto", "Tokyo", "5pm", 2, 1000.00);

        assertEquals(1001, flight.getFlightNumber());
        assertEquals("Toronto", flight.getOrigin());
        assertEquals("Tokyo", flight.getDestination());
        assertEquals("5pm", flight.getDepartureTime());
        assertEquals(2, flight.getCapacity());
        assertEquals(2, flight.getNumberOfSeatsLeft());
        assertEquals(1000.00, flight.getOriginalPrice(), 0.001);
    }

    @Test
    public void testInvalidConstructor() {
        boolean thrown = false;
        try {
            new Flight(2, "Toronto", "Toronto", "5pm", 7, 1010.10);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testBookASeat() {
        Flight flight = new Flight(1002, "Toronto", "Tokyo", "6pm", 1, 1400.00);

        assertTrue(flight.bookASeat());
        assertEquals(0, flight.getNumberOfSeatsLeft());
        assertFalse(flight.bookASeat());
    }

    @Test
    public void testToString() {
        Flight flight = new Flight(1001, "Toronto", "Tokyo", "5pm", 2, 1000.00);

        String expected = "Flight 1001, Toronto to Tokyo, 5pm, original price: $1000.00";
        assertEquals(expected, flight.toString());
    }
}

