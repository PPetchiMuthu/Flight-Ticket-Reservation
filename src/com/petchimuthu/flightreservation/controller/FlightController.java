package com.petchimuthu.flightreservation.controller;

import com.petchimuthu.flightreservation.model.PassengerInfo;
import com.petchimuthu.flightreservation.view.FlightReservationMain;
import com.petchimuthu.flightreservation.db.FlightDataBase;
import com.petchimuthu.flightreservation.model.FligthInfo;

import java.util.ArrayList;
import java.util.List;

public class FlightController {
    FlightReservationMain flightReservationMain;
    public List<FligthInfo> listOfListFlight = new ArrayList<>();


    public FlightController(FlightReservationMain flightReservationMain) {
        this.flightReservationMain = flightReservationMain;
    }

    public void getAvailableFlights(String fromStation, String toStation) {
        for (FligthInfo info : FlightDataBase.getInstance().getListOfFlight()) {
            List<String> list = info.getFlightRoutes();
            if (list.contains(fromStation) && list.contains(toStation) && (list.indexOf(fromStation) < list.indexOf(toStation))) {
                if (list.indexOf(fromStation) < list.indexOf(toStation)) listOfListFlight.add(info);
            }
        }
    }

    public void addFlight(int number, String name, List<String> list, String startingTime, String endingTime, int seat, int fare) {
        FligthInfo flight = new FligthInfo();
        flight.setFlightNumber(number);
        flight.setFlightName(name);
        flight.setFlightRoutes(list);
        flight.setStartingFlightTime(startingTime);
        flight.setEndingFlightTime(endingTime);
        flight.setNumberOfSeats(seat);
        flight.setFare(fare);
        FlightDataBase.getInstance().setListOfFlight(flight);
    }

    public void addPassengerInfo(String userName, int userAge, String gender, String fromStation, String toStation, int flightNumber) {
        PassengerInfo passengerInfo = new PassengerInfo();
        passengerInfo.setPassengerName(userName);
        int num = passengerInfo.getPassengerId();
        passengerInfo.setFlightNumber(flightNumber);
        passengerInfo.setPassengerId(num + 2);
        passengerInfo.setPassengerAge(userAge);
        passengerInfo.setPassengerGender(gender);
        passengerInfo.setStartingDestination(fromStation);
        passengerInfo.setEndingDestination(toStation);
        FlightDataBase.getInstance().setListOfPassenger(passengerInfo);
    }

    public void removeTicket(int ticketId) {
        FlightDataBase.getInstance().getTicketInfo().removeIf(ticketInfo -> ticketId == ticketInfo.getTicketId());
    }
}
