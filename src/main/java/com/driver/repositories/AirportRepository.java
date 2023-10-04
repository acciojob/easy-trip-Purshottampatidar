package com.driver.repositories;

import com.driver.model.Airport;
import com.driver.model.Flight;
import com.driver.model.Passenger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class AirportRepository {
    private HashMap<String, Airport> airportDb = new HashMap<>();
    private HashMap<Integer, Flight> flightDb = new HashMap<>();
    private HashMap<Integer, Passenger> passengerDb = new HashMap<>();
    private HashMap<Integer, List<Integer>> passengerFlightDb = new HashMap<>();

    public void addAirport(Airport airport) {
        airportDb.put(airport.getAirportName(), airport);
    }

    public Airport getAirportByName(String airportName) {
        return airportDb.get(airportName);
    }

    public List<Airport> getAllAirports() {
        return new ArrayList<>(airportDb.values());
    }

    public void addFlight(Flight flight) {
        flightDb.put(flight.getFlightId(), flight);
    }

    public Flight getFlightById(Integer flightId) {
        return flightDb.get(flightId);
    }

    public List<Flight> getAllFlights() {
        return new ArrayList<>(flightDb.values());
    }

    public void addPassenger(Integer passengerId, Passenger passenger) {
        passengerDb.put(passengerId, passenger);
    }
    public Passenger getPassengerById(Integer passengerId) {
        return passengerDb.get(passengerId);
    }

    public void bookTicket(Integer flightId, Integer passengerId) {
        List<Integer> passengerList = passengerFlightDb.getOrDefault(flightId, new ArrayList<>());
        passengerList.add(passengerId);

        passengerFlightDb.put(flightId, passengerList);
    }

    public void cancelTicket(Integer flightId, Integer passengerId) {
        List<Integer> passengerList = passengerFlightDb.getOrDefault(flightId, new ArrayList<>());
        passengerList.remove(passengerId);

        passengerFlightDb.put(flightId, passengerList);
    }

    public List<Integer> getPassengersByFlight(Integer flightId) {
        return passengerFlightDb.getOrDefault(flightId, new ArrayList<>());
    }
}
