package flightreservation.view;

import flightreservation.controller.FlightController;
import flightreservation.db.FlightDataBase;

import java.util.Scanner;

public class FlightReservationMain {
    FlightController flightController;
    CreateFlight createFlight;
    Scanner scan = new Scanner(System.in);
    FlightReservationMain() {
        flightController = new FlightController(this);
    }
    public static void main(String[] args) {
        FlightReservationMain flightReservationMain = new FlightReservationMain();
        flightReservationMain.getStart();
    }
    private void getStart() {
        BookingView bookingView = new BookingView();
        System.out.println("\n--------------------------------------------------------------------");
        System.out.println("                        Flight Ticket Booking");
        System.out.println("--------------------------------------------------------------------\n");
        System.out.println("1 - Booking\n2 - Add flight routes\n3 - Booked tickets\n4 - Cancel Tickets\n5 - Search passenger\n6 - List flight routes\n7 - Exit\n");
        System.out.println("--------------------------------------------------------------------");
        int num = scan.nextInt();
        switch (num) {
            case 1:
                bookingView.startBooking(flightController);
                getStart();
                break;
            case 2:
                createFlight.addFlightRoutes(flightController);
                getStart();
                break;
            case 3:
                createFlight.showBookedTickets(flightController);
                getStart();
                break;
            case 4:
                createFlight.cancelTicket(flightController);
                getStart();
                break;
            case 5:
                bookingView.searchPassenger(flightController);
                getStart();
                break;
            case 6:
                createFlight.showFlightRoutes(flightController);
                getStart();
                break;
            case 7:
                break;
            default:
                System.out.println("Enter the Valid Number : ");
                getStart();
        }
    }

}
