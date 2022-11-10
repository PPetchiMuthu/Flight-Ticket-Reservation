package flightreservation.model;

public class PassengerInfo {

    private String passengerName;

    private int passengerAge;

    private String passengerGender;

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

    private int passengerId = 2435;

    public PassengerInfo( int passengerId,String passengerName, int passengerAge, String passengerGender) {
        this.passengerName = passengerName;
        this.passengerAge = passengerAge;
        this.passengerGender = passengerGender;
        this.passengerId = passengerId;
    }
}
