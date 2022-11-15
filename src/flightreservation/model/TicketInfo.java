package flightreservation.model;

import java.util.List;

public class TicketInfo {

    private static  int ticketId = 3456456;

    public TicketInfo() {
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        TicketInfo.ticketId = ticketId;
    }
    private int flightNumber;
    private String startingDestination;
    private String endingDestination;
    private int priceAmount;

    private List<PassengerInfo> passengerInfo;

    public List<PassengerInfo> getPassengerInfo() {
        return passengerInfo;
    }

    public void setPassengerInfo(PassengerInfo passengerInfo) {
        this.passengerInfo.add(passengerInfo);
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getStartingDestination() {
        return startingDestination;
    }

    public void setStartingDestination(String startingDestination) {
        this.startingDestination = startingDestination;
    }

    public String getEndingDestination() {
        return endingDestination;
    }

    public void setEndingDestination(String endingDestination) {
        this.endingDestination = endingDestination;
    }

    public int getPriceAmount() {
        return priceAmount;
    }

    public void setPriceAmount(int priceAmount) {
        this.priceAmount = priceAmount;
    }


}
