package com.driver.controllers;

import com.driver.model.Airport;
import com.driver.model.Flight;
import com.driver.model.Passenger;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;

import java.util.List;

public class Service {
    Reporesitory reporesitory=new Reporesitory();

    public void addAirport(Airport airport){
        reporesitory.addAirport(airport);
    }


    public String getLargest(){
        List<Airport> allairport=reporesitory.getAllAirPort();
        int max=0;
        String res="";
        for(int i=0;i<allairport.size();i++){
            if(max<allairport.get(i).getNoOfTerminals()){
                max=allairport.get(i).getNoOfTerminals();
                res=allairport.get(i).getAirportName();
            }
        }
        return res;
    }

    public void addFlightToDb(Flight flight){
        reporesitory.addFlightToDb(flight);
    }

    public void addPassengerToDb(Passenger passenger){
        reporesitory.addPassengerToDb(passenger);
    }
}
