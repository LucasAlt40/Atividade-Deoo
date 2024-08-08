package data.airport.model.totem;

import data.airport.model.FlightData;
import data.airport.states.Arriving;
import data.airport.states.State;

import java.util.ArrayList;
import java.util.List;

public class Totem implements ITotem{
    private List<FlightData> flights;
    private String title;
    private List<State> states;

    public Totem(String title, State... states) {
        flights = new ArrayList<>();
        this.states = new ArrayList<>(List.of(states));
        this.title = title;
    }

    @Override
    public String show() {
        StringBuilder result = new StringBuilder();

        result.append("+____________________________________________________________+\n");
        result.append("|__________________________+");
        result.append(title);
        result.append("+________________________|\n");
        result.append("|____________________________________________________________|\n");
        for(FlightData flight: flights){
            result.append("|-").append(flight.toString()).append("|\n");
        }
        result.append("+____________________________________________________________+\n");

        return result.toString();
    }

    @Override
    public void removeFlights() {
        if(!flights.isEmpty()) {
            flights.removeIf(flight -> !states.contains(flight.getState()));
        }
    }

    @Override
    public void update(FlightData flight) {
        if(states.contains(flight.getState())) {
            flights.add(flight);
        }

        removeFlights();

    }
}
