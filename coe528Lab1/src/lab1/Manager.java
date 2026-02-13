package lab1;

/**
 *
 * @author sajoshi
 */

import java.util.ArrayList;

public class Manager {

    private ArrayList<Flight> flights = new ArrayList<>();
    private ArrayList<Ticket> tickets = new ArrayList<>();

    public void createFlights() {
    flights.add(new Flight(1000,"Toronto","Sydney","4pm",2,700));
    flights.add(new Flight(1001,"Toronto","Tokyo","5pm",2,1000));
    flights.add(new Flight(1002,"Toronto","Tokyo","6pm",3,1400));
}


    public void displayAvailableFlights(String origin, String dest) {
        for (Flight f : flights) {
            if (f.getOrigin().equals(origin)
                    && f.getDestination().equals(dest)
                    && f.getNumberOfSeatsLeft() > 0) {
                System.out.println(f);
            }
        }
    }

    public Flight getFlight(int num) {
        for (Flight f : flights) {
            if (f.getFlightNumber() == num)
                return f;
        }
        return null;
    }

    public void bookSeat(int flightNumber, Passenger p) {
        Flight f = getFlight(flightNumber);
        if (f == null) return;

        if (f.bookASeat()) {
            double finalPrice = p.applyDiscount(f.getOriginalPrice());
            tickets.add(new Ticket(p, f, finalPrice));
            System.out.println("Booked: " + p.getName());
        } else {
            System.out.println("Flight full.");
        }
    }

    public static void main(String[] args) {
        Manager m = new Manager();

        Passenger[] passengers = {
                new Member("Sam", 22, 6),
                new Member("Curry", 24, 4),
                new Member("Lebron", 26, 0),
                new Member("Brady", 27, 0),
                new NonMember("Messi", 36),
                new NonMember("Ronaldo", 66)
        };

        m.createFlights();
        m.displayAvailableFlights("Toronto", "Tokyo");

        m.bookSeat(1001, passengers[0]);
        m.bookSeat(1001, passengers[1]);
        m.bookSeat(1001, passengers[2]);

        m.bookSeat(1002, passengers[3]);
        m.bookSeat(1002, passengers[4]);
        m.bookSeat(1002, passengers[5]);
    }
} 

