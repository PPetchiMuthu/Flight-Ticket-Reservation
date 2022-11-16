package com.petchimuthu.flightreservation.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.petchimuthu.flightreservation.model.FligthInfo;
import com.petchimuthu.flightreservation.model.PassengerInfo;
import com.petchimuthu.flightreservation.model.TicketInfo;


public class FlightDataBase {
    private static FlightDataBase flightDataBase = null;
    private final List<FligthInfo> listOfFlight;
    private final List<PassengerInfo> listOfPassenger;
    private final List<TicketInfo> ticketInfo;

    public FlightDataBase() {
        listOfFlight = new ArrayList<>();
        listOfPassenger = new ArrayList<>();
        ticketInfo = new ArrayList<>();
    }

    public static FlightDataBase getInstance() {
        if (flightDataBase == null) {
            flightDataBase = new FlightDataBase();
            setFlight();
        }
        return flightDataBase;
    }

    public List<FligthInfo> getListOfFlight() {
        return listOfFlight;
    }

    public void setListOfFlight(FligthInfo listOfFlight) {
        this.listOfFlight.add(listOfFlight);
    }

    public List<PassengerInfo> getListOfPassenger() {
        return listOfPassenger;
    }

    public void setListOfPassenger(PassengerInfo listOfPassenger) {
        this.listOfPassenger.add(listOfPassenger);
    }

    public List<TicketInfo> getTicketInfo() {
        return ticketInfo;
    }

    private static void setFlight() {
        FligthInfo flight1 = new FligthInfo();
        flight1.setFlightNumber(2345);
        flight1.setFlightName("Kolkata Airways");
        flight1.setFlightRoutes(Arrays.asList("CHENNAI", "BENGALURU", "HYDERABAD", "KOLKATA"));
        flight1.setStartingFlightTime("1.00");
        flight1.setEndingFlightTime("23.00");
        flight1.setNumberOfSeats(10);
        flight1.setFare(430);
        FlightDataBase.getInstance().listOfFlight.add(flight1);
        FligthInfo flight2 = new FligthInfo();
        flight2.setFlightNumber(2346);
        flight2.setFlightName("Delhi Airways");
        flight2.setFlightRoutes(Arrays.asList("CHENNAI", "BENGALURU", "HYDERABAD", "KOLKATA", "DELHI"));
        flight2.setStartingFlightTime("5.00");
        flight2.setEndingFlightTime("1.00");
        flight2.setNumberOfSeats(10);
        flight2.setFare(470);
        FlightDataBase.getInstance().listOfFlight.add(flight2);
        FligthInfo flight3 = new FligthInfo();
        flight3.setFlightNumber(2347);
        flight3.setFlightName("Kovai Express");
        flight3.setFlightRoutes(Arrays.asList("CHENNAI", "BENGALURU", "HYDERABAD", "KOLKATA", "DELHI", "AHMEDABAD"));
        flight3.setStartingFlightTime("11.00");
        flight3.setEndingFlightTime("6.00");
        flight3.setNumberOfSeats(10);
        flight3.setFare(530);
        FlightDataBase.getInstance().listOfFlight.add(flight3);
    }
}
