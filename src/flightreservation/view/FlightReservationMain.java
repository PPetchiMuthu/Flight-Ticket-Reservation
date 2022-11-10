package flightreservation.view;

import flightreservation.controller.FlightController;
import java.util.Scanner;

public class FlightReservationMain {
    FlightController flightController;
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
        System.out.println("\n                           Flight Ticket Booking");
        System.out.println("1-Booking\n2-Get PNR status\n3-Booked tickets\n4-Cancel Tickets\n5-Search passenger\n6- Change ticket status of a passenger\n7-List flight routes\n8-Add flight routes");
        int num = scan.nextInt();
        switch (num) {
            case 1:
                bookingView.startBooking(flightController);
                break;
            case 2:
               break;
            case 3 :


        }
    }

}
