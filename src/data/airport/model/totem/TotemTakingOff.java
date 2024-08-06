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
        return "";

    }

    @Override
    public void removeFlights() {
        if(!flights.isEmpty()) {
            flights.removeIf(flight -> flight.getState() != TakingOff.getInstance());
        }
    }
}
