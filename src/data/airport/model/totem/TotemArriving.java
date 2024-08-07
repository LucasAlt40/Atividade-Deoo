package data.airport.model.totem;

import data.airport.model.FlightData;
import data.airport.states.Arriving;

import java.util.ArrayList;
import java.util.List;

public class TotemArriving implements ITotem {

    private List<FlightData> flights;

    public TotemArriving() {
        this.flights = new ArrayList<>();
    }

    @Override
    public void update(FlightData flight) {
        if(flight.getState().equals(Arriving.getInstance())) {
            flights.add(flight);
        }

        removeFlights();
    }

    @Override
    public String show() {
        StringBuilder totemArriving = new StringBuilder();

        totemArriving.append("+____________________________________________________________+\n");
        totemArriving.append("|__________________________+Arriving+________________________|\n");
        totemArriving.append("|____________________________________________________________|\n");
        for(FlightData flight: flights){
            totemArriving.append("|-").append(flight.toString()).append("|\n");
        }
        totemArriving.append("+____________________________________________________________+\n");

        return totemArriving.toString();
    }

    @Override
    public void removeFlights() {
       if(!flights.isEmpty()) {
           flights.removeIf(flight -> flight.getState() != Arriving.getInstance());
       }
    }


}
