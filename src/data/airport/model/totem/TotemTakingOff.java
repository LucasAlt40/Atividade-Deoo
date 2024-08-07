package data.airport.model.totem;

import data.airport.model.FlightData;
import data.airport.states.TakingOff;

import java.util.ArrayList;
import java.util.List;

public class TotemTakingOff implements ITotem {

    private List<FlightData> flights;

    public TotemTakingOff() {
        this.flights = new ArrayList<>();
    }

    @Override
    public void update(FlightData flight) {
        if(flight.getState().equals(TakingOff.getInstance())) {
            flights.add(flight);
        }

        removeFlights();
    }

    @Override
    public String show() {
        StringBuilder totemTakingOff = new StringBuilder();

        totemTakingOff.append("+____________________________________________________________+\n");
        totemTakingOff.append("|__________________________+TakingOff+________________________|\n");
        totemTakingOff.append("|____________________________________________________________|\n");
        for(FlightData flight: flights){
            totemTakingOff.append("|-").append(flight.toString()).append("|\n");
        }
        totemTakingOff.append("+____________________________________________________________+\n");

        return totemTakingOff.toString();
    }

    @Override
    public void removeFlights() {
        if(!flights.isEmpty()) {
            flights.removeIf(flight -> flight.getState() != TakingOff.getInstance());
        }
    }
}
