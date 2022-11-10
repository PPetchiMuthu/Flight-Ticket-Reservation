package flightreservation.view;

import flightreservation.model.FligthInfo;
import flightreservation.model.PassengerInfo;
import flightreservation.controller.FlightController;

import java.util.Scanner;

public class BookingView {
    FlightController flightController ;
    Scanner scan = new Scanner(System.in);
     public void startBooking(FlightController controller ) {
         flightController = controller;
        System.out.print("From Station :");
        String fromStation = scan.next();
        System.out.println("To Station: ");
        String toStation = scan.next();
        System.out.println("Available Flights ");
        flightController.getAvaiableFlights(fromStation, toStation);
        for (FligthInfo info : flightController.listOfListFlight) {
            System.out.println("Flight No: " + info.getFlightNumber() + "\nName : " + info.getFlightName());
            System.out.println("Departure Time: " + info.getFlightTime().indexOf(0) + ".00\nArrival Time : " + info.getFlightTime().indexOf(info.getFlightTime().size() - 1));
            System.out.println("Fare : " + info.getFare() + "\nSeats : " + info.getNumberOfSeats()+"\n\n");
        }
        System.out.print("Enter the Flight Number: ");
        int fligthNumber = scan.nextInt();
        int fareAmount = 0;
        System.out.print("\nEnter the No of Passenger : ");
        int passenger = scan.nextInt();
        for (FligthInfo info : flightController.listOfListFlight)
            if(fligthNumber==info.getFlightNumber())
                fareAmount = info.getFare()*passenger;
            else{
                startBooking(flightController);
                break;
            }
        for(int i=0;i<passenger;i++)
            getUserInfo(fligthNumber);
        System.out.println("\nTotal Fare : "+fareAmount);
        readyToPay();
        System.out.println("\nFlight Details");
        getBookedDetails(fligthNumber);
    }

    private void getBookedDetails(int fligthNumber) {
        for (FligthInfo info : flightController.listOfListFlight) {
            if (fligthNumber == info.getFlightNumber()) {
                System.out.println("Flight No: " + info.getFlightNumber() + "\nName : " + info.getFlightName());
                System.out.println("Departure Time: " + info.getFlightTime().indexOf(0) + ".00\nArrival Time : " + info.getFlightTime().indexOf(info.getFlightTime().size() - 1));
                System.out.println("Fare : " + info.getFare() + "\nSeats : " + info.getNumberOfSeats() + "\n\n");
            }
        }
        for (PassengerInfo info: flightController.passengerInfo) {
            System.out.println("\nName : "+info.getPassengerName()+"\nAge : "+info.getPassengerAge()+"\nGender : "+info.getPassengerGender()+"\nId : "+info.getPassengerId());
        }
    }
    private void readyToPay() {
        System.out.println("\n                    PAY  ");
        System.out.print("\n1-Pay\n2-Cancel\n3-Reschedule");
        System.out.print("\nEnter any valid option : ");
        int option = scan.nextInt();
        switch (option) {
            case 1 -> System.out.println("\nTicket's Booked Successfully.");
            case 2 -> System.out.println("\nTicket Cancelled");
            default -> {
                System.out.println("\nSomething Error Please Try again");
                startBooking(flightController);
            }
        }
    }
    private void getUserInfo(int fligthNumber) {
        System.out.println("\n                        Please fill the user details ");
        System.out.print("\nName : ");
        String userName = scan.next();
        System.out.print("\nAge : ");
        int userAge = scan.nextInt();
        System.out.println("\nGender : ");
        String gender = scan.next();
        flightController.addPassengerInfo(userName,userAge,gender,fligthNumber);
    }

    public void bookedTickets(){
        for (FligthInfo info : flightController.listOfListFlight) {
            getBookedDetails(info.getFlightNumber());
            break;
        }
    }
}
