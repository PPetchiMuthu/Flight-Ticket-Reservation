package flightreservation.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import flightreservation.model.FligthInfo;
import flightreservation.model.PassengerInfo;


public class FlightDataBase {
    private  PassengerInfo passengerInfo;
    public List<FligthInfo> listOfFligth = new ArrayList<>();
    public List<PassengerInfo> listOfPassenger = new ArrayList<>();
    public FlightDataBase() {
        setFlightInfo();
    }
    private void setFlightInfo() {
        FligthInfo flight1 = new FligthInfo();
        flight1.setFlightNumber(2345);
        flight1.setFlightName("Kolkatta Airways");
        flight1.setFlightRoutes(Arrays.asList("Chennai", "Bengalure", "Hydrabad", "Kolkatta"));
        List<Integer> temp1 = Arrays.asList(1, 4, 5, 11);
        flight1.setFlightTime(temp1);
        flight1.setNumberOfSeats(10);
        flight1.setFare(430);
        listOfFligth.add(flight1);
        FligthInfo flight2 = new FligthInfo();
        flight2.setFlightNumber(2346);
        flight2.setFlightName("Delhi Airways");
        flight2.setFlightRoutes(Arrays.asList("Chennai", "Bengalure", "Hydrabad", "Kolkatta", "Delhi"));
        List<Integer> temp2 = Arrays.asList(23, 3, 6, 10, 13, 16);
        flight2.setFlightTime(temp2);
        flight2.setNumberOfSeats(10);
        flight2.setFare(530);
        listOfFligth.add(flight2);
        FligthInfo flight3 = new FligthInfo();
        flight3.setFlightNumber(2347);
        flight3.setFlightName("Kovai Express");
        flight3.setFlightRoutes(Arrays.asList("Chennai", "Bengalure", "Hydrabad", "Delhi", "Ahamadabath"));
        List<Integer> temp3 = Arrays.asList(23, 3, 6, 10, 13, 16);
        flight3.setFlightTime(temp3);
        flight3.setNumberOfSeats(10);
        flight3.setFare(530);
        listOfFligth.add(flight3);
    }

    public void addPassenger(String userName, int userAge, String gender) {
        int id = passengerInfo.getPassengerId();
        listOfPassenger.add(new PassengerInfo(id+2,userName,userAge,gender));
    }
}
