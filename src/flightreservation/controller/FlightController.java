package flightreservation.controller;

import flightreservation.model.PassengerInfo;
import flightreservation.view.FlightReservationMain;
import flightreservation.db.FlightDataBase;
import flightreservation.model.FligthInfo;

import java.util.ArrayList;
import java.util.List;

public class FlightController {
    FlightReservationMain fligthReservationMain;
    public List<FligthInfo> listOfListFlight = new ArrayList<>();

    public List<PassengerInfo> passengerInfo = new ArrayList<>();
    FlightDataBase flightDataBase = new FlightDataBase();
    public FlightController(FlightReservationMain fligthReservationMain) {
        this.fligthReservationMain = fligthReservationMain;
    }
    public void getAvaiableFlights(String fromStation, String toStation) {
        List<FligthInfo> flight = flightDataBase.listOfFligth;
        for (FligthInfo info: flight) {
            List<String> list = info.getFlightRoutes();
                if (list.contains(fromStation) && list.contains(toStation)) {
                    listOfListFlight.add(info);
            }
        }
    }

    public void addPassengerInfo(String userName, int userAge, String gender,int flightNumber) {
        flightDataBase.addPassenger(userName, userAge, gender);
        passengerInfo.add((PassengerInfo) flightDataBase.listOfPassenger);
    }
}
