package com.petchimuthu.flightreservation.model;

import java.util.List;

public class FligthInfo {
    private int flightNumber;
    private String flightName;
    private List<String> flightRoutes;
    private String  startingFlightTime;
    private String  endingFlightTime;
    private int numberOfSeats;
    private int fare;

    public String  getStartingFlightTime() {
        return startingFlightTime;
    }

    public void setStartingFlightTime(String startingFlightTime) {
        this.startingFlightTime = startingFlightTime;
    }

    public String getEndingFlightTime() {
        return endingFlightTime;
    }

    public void setEndingFlightTime(String endingFlightTime) {
        this.endingFlightTime = endingFlightTime;
    }
    public int getFlightNumber() {
        return flightNumber;
    }

    public String getFlightName() {
        return flightName;
    }

    public List<String> getFlightRoutes() {
        return flightRoutes;
    }


    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public int getFare() {
        return fare;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public void setFlightRoutes(List<String> flightRoutes) {
        this.flightRoutes = flightRoutes;
    }



    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }
}
