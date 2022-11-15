package flightreservation.view;

import flightreservation.controller.FlightController;
import flightreservation.db.FlightDataBase;
import flightreservation.model.FligthInfo;
import flightreservation.model.PassengerInfo;
import flightreservation.model.TicketInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateFlight {

    FlightController flightController;
    Scanner scan = new Scanner(System.in);

    public void addFlightRoutes(FlightController controller) {
        flightController = controller;
        System.out.println("\n--------------------------------------------------------------------");
        System.out.println("            CREATE NEW FLIGHT    ");
        System.out.println("--------------------------------------------------------------------\n");
        System.out.print("Enter the fight No : ");
        int flightNumber = scan.nextInt();
        System.out.print("Enter the Fight Name : ");
        String flightName = scan.next();
        System.out.print("How many airport : ");
        List<String> list = new ArrayList<>();
        int num = scan.nextInt();
        for (int i = 0; i < num; i++) {
            System.out.print("Airport : ");
            list.add(scan.next().toUpperCase());
        }
        System.out.print("Departure Time : ");
        String departure = scan.next();
        System.out.print("Arrival Time : ");
        String arrival = scan.next();
        System.out.print("Number of seats : ");
        int seats = scan.nextInt();
        System.out.print("Flight Tickets : ");
        int ticketsPrice = scan.nextInt();
        flightController.addFlight(flightNumber, flightName, list, departure, arrival, seats, ticketsPrice);
    }

    public void showBookedTickets(FlightController flightController) {
        this.flightController = flightController;
        for (TicketInfo ticketInfo : FlightDataBase.getInstance().getTicketInfo()) {
            System.out.println("\n--------------------------------------------------------------------");
            System.out.println("                    Ticket Details");
            System.out.println("--------------------------------------------------------------------\n");
            System.out.println("Flight Details \n");
            for (FligthInfo fligthInfo : FlightDataBase.getInstance().getListOfFlight()) {
                if (ticketInfo.getFlightNumber() == fligthInfo.getFlightNumber()) {
                    System.out.println("Flight No: " + fligthInfo.getFlightNumber() + "\nName : " + fligthInfo.getFlightName());
                    System.out.println("Departure Time: " + fligthInfo.getStartingFlightTime() + "\nArrival Time : " + fligthInfo.getEndingFlightTime());
                    System.out.println("Fare : " + fligthInfo.getFare() + "\nSeats : " + fligthInfo.getNumberOfSeats() + "\n\n");
                }
                System.out.println("--------------------------------------------------------------------");
                System.out.println("Passenger Details");
                for (PassengerInfo passengerInfo : ticketInfo.getPassengerInfo()) {
                    System.out.println("\nName : " + passengerInfo.getPassengerName() + "\nAge : " + passengerInfo.getPassengerAge() + "\nGender : " + passengerInfo.getPassengerGender() + "\nId : " + passengerInfo.getPassengerId());
                }
            }
        }
    }

    public void cancelTicket(FlightController flightController) {
        this.flightController = flightController;
        System.out.println("\n--------------------------------------------------------------------");
        System.out.println("                   Ticket Cancellation ");
        System.out.println("--------------------------------------------------------------------\n");
        System.out.print("\nTicket Number : ");
        int ticketId = scan.nextInt();

        flightController.removeTicket(ticketId);

    }

    public void showFlightRoutes(FlightController flightController) {
        this.flightController = flightController;
        for (FligthInfo fligthInfo : FlightDataBase.getInstance().getListOfFlight()) {
            System.out.println("\n--------------------------------------------------------------------");
            System.out.println("Flight No: " + fligthInfo.getFlightNumber() + "\nName : " + fligthInfo.getFlightName());
            System.out.println("Departure Time: " + fligthInfo.getStartingFlightTime() + ".00\nArrival Time : " + fligthInfo.getEndingFlightTime());
            System.out.println("Fare : " + fligthInfo.getFare() + "\nSeats : " + fligthInfo.getNumberOfSeats() + "\n\n");
        }

    }
}

