package com.driver.controllers;

import com.driver.model.Airport;
import com.driver.model.Flight;
import com.driver.model.Passenger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reporesitory {
      Map<String,Airport> dbOfAirport=new HashMap<>();

      Map<Integer, Flight> dbOfFlight=new HashMap<>();

      Map<Integer, Passenger> dbOfPassenger=new HashMap<>();



      public void addAirport(Airport airport){
          String airPortName=airport.getAirportName();
          dbOfAirport.put(airPortName,airport);
      }

      public List<Airport> getAllAirPort(){
          return dbOfAirport.values().stream().toList();
      }

      public void addFlightToDb(Flight flight){
          int flightId=flight.getFlightId();
          dbOfFlight.put(flightId,flight);
      }

      public List<Flight> getAllFlight(){
          return dbOfFlight.values().stream().toList();
      }

      public void addPassengerToDb(Passenger passenger){
          int passengerId=passenger.getPassengerId();
          dbOfPassenger.put(passengerId,passenger);
      }
}
