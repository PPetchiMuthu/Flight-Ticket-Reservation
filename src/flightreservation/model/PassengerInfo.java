package flightreservation.model;

public class PassengerInfo {
    private static int passengerId = 2435;

    private int flightNumber;
    private String passengerName;

    private int passengerAge;

    private String passengerGender;

    private String startingDestination;

    public String getStartingDestination() {
        return startingDestination;
    }

    public String getEndingDestination() {
        return endingDestination;
    }

    private String endingDestination;

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }


    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public void setPassengerAge(int passengerAge) {
        this.passengerAge = passengerAge;
    }

    public void setPassengerGender(String passengerGender) {
        this.passengerGender = passengerGender;
    }

    public void setStartingDestination(String startingDestination) {
        this.startingDestination = startingDestination;
    }

    public void setEndingDestination(String endingDestination) {
        this.endingDestination = endingDestination;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public int getPassengerAge() {
        return passengerAge;
    }

    public String getPassengerGender() {
        return passengerGender;
    }

    public int getPassengerId() {
        return passengerId;
    }


}
