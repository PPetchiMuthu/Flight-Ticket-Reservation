package flightreservation.view;

import flightreservation.db.FlightDataBase;
import flightreservation.model.FligthInfo;
import flightreservation.model.PassengerInfo;
import flightreservation.controller.FlightController;
import flightreservation.model.TicketInfo;

import java.util.Scanner;

public class BookingView {
    FlightController flightController;
    Scanner scan = new Scanner(System.in);

    public void startBooking(FlightController controller) {
        flightController = controller;
        System.out.println("--------------------------------------------------------------------");
        System.out.print("From Station :");
        String fromStation = scan.next();
        System.out.print("To Station: ");
        String toStation = scan.next();
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Available Flights ");
        flightController.getAvailableFlights(fromStation.toUpperCase(), toStation.toUpperCase());
        if (flightController.listOfListFlight.isEmpty()) {
            System.out.println("No Flights are Available for your Routes");
        } else {
            for (FligthInfo info : flightController.listOfListFlight) {
                System.out.println("--------------------------------------------------------------------");
                System.out.println("Flight No: " + info.getFlightNumber() + "\nName : " + info.getFlightName());
                System.out.println("Departure Time: " + info.getStartingFlightTime() + "\nArrival Time : " + info.getEndingFlightTime());
                System.out.println("Fare : " + info.getFare() + "\nSeats : " + info.getNumberOfSeats() + "\n");
            }
            System.out.println("--------------------------------------------------------------------");
            System.out.print("Enter the Flight Number: ");
            int flightNumber = scan.nextInt();
            int fareAmount = 0;
            System.out.println("--------------------------------------------------------------------");
            for (FligthInfo info : flightController.listOfListFlight)
                if (flightNumber != info.getFlightNumber()) {
                    System.out.println("Please enter the valid Flight Number");
                    startBooking(flightController);
                } else {
                    System.out.print("\nEnter the No of Passenger : ");
                    int passenger = scan.nextInt();
                    fareAmount = info.getFare() * passenger;
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("                        Please fill the user details ");
                    System.out.println("--------------------------------------------------------------------");
                    for (int i = 0; i < passenger; i++)
                        getUserInfo(flightNumber, fromStation, toStation);
                    System.out.println("\nTotal Fare : " + fareAmount);
//        readyToPay();
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("\nFlight Details");
                    getBookedDetails(flightNumber, fromStation, toStation, fareAmount);
                }
        }
    }

    private void getUserInfo(int flightNumber, String fromStation, String toStation) {
        System.out.print("\nName : ");
        String userName = scan.next();
        System.out.print("\nAge : ");
        int userAge = scan.nextInt();
        System.out.println("\nGender : ");
        String gender = scan.next();
        System.out.println("--------------------------------------------------------------------");
        flightController.addPassengerInfo(userName, userAge, gender, fromStation, toStation, flightNumber);
    }

    private void getBookedDetails(int flightNumber, String fromStation, String toStation, int fareAmount) {
        TicketInfo ticketInfo = new TicketInfo();
        ticketInfo.setTicketId(ticketInfo.getTicketId() + 2);
        ticketInfo.setFlightNumber(flightNumber);
        ticketInfo.setStartingDestination(fromStation);
        ticketInfo.setEndingDestination(toStation);
        ticketInfo.setPriceAmount(fareAmount);
        for (FligthInfo info : FlightDataBase.getInstance().getListOfFlight()) {
            if (flightNumber == info.getFlightNumber()) {
                System.out.println("--------------------------------------------------------------------");
                System.out.println("Flight No: " + info.getFlightNumber() + "\nName : " + info.getFlightName());
                System.out.println("Departure Time: " + info.getStartingFlightTime() + "\nArrival Time : " + info.getEndingFlightTime());
                System.out.println("Fare : " + info.getFare() + "\nSeats : " + info.getNumberOfSeats() + "\n\n");
            }
        }
        for (PassengerInfo info : FlightDataBase.getInstance().getListOfPassenger()) {
            if (flightNumber == info.getFlightNumber()) {
                System.out.println("--------------------------------------------------------------------");
                System.out.println("\nName : " + info.getPassengerName() + "\nAge : " + info.getPassengerAge() + "\nGender : " + info.getPassengerGender() + "\nId : " + info.getPassengerId());
                ticketInfo.setPassengerInfo(info);
            }
        }
    }

    public void searchPassenger(FlightController flightController) {
        this.flightController = flightController;
        System.out.println("--------------------------------------------------------------------");
        System.out.print("\nEnter the Passenger Id : ");
        System.out.println("--------------------------------------------------------------------");
        int id = scan.nextInt();
        for (PassengerInfo passengerInfo : FlightDataBase.getInstance().getListOfPassenger()) {
            if (passengerInfo.getPassengerId() == id)
                System.out.println("\nName : " + passengerInfo.getPassengerName() + "\nAge : " + passengerInfo.getPassengerAge() + "\nGender : " + passengerInfo.getPassengerGender() + "\nId : " + passengerInfo.getPassengerId());
        }
    }

//    private void readyToPay() {
//        System.out.println("\n                    PAY  ");
//        System.out.print("\n1-Pay\n2-Cancel\n3-Reschedule");
//        System.out.print("\nEnter any valid option : ");
//        int option = scan.nextInt();
//        switch (option) {
//            case 1 -> System.out.println("\nTicket's Booked Successfully.");
//            case 2 -> System.out.println("\nTicket Cancelled");
//            default -> {
//                System.out.println("\nSomething Error Please Try again");
//                startBooking(flightController);
//            }
//        }
//    }
}
