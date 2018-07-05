/**
 *
 */
package flight;

import java.io.Serializable;
import java.util.ArrayList;

//import driver.Driver;
import system.Database;

/**
 * A class that keeps track of all of the flights from the origin to the final
 * destination.
 */
public class Itinerary implements Serializable {

    /**
     * The Array List of all of the flights in an itinerary.
     */
    ArrayList<Flight> flights = new ArrayList<Flight>();

    /**
     * The total cost of all of the flights in an itinerary.
     */
    private double totalCost = 0;

    /**
     * The total travel time of all of the flights in an itinerary.
     */
    private int totalTime = 0;

    public Itinerary(ArrayList<Flight> flights) {
        super();
        this.flights = flights;
        this.totalCost = addTotalCost(getCosts(flights));
    }

    /**
     * Empty Itinerary constructor used for creating itineraries for user.
     */
    public Itinerary() {
        super();
    }

    /**
     * Returns how many flights are in this itinerary.
     *
     * I took this concept of Itinery's from this repo: https://github.com/seanjameshan/Flight-X
     * .
     */
    public int size() {
        return flights.size();
    }

    /**
     * returns ArrayList of all the flights.
     *
     */
    public ArrayList<Flight> getFlights() {
        return flights;
    }

    /**
     * Adds an individual flight to itinerary.
     *
     */
    public void addIndividualFlight(Flight flight) {
        this.flights.add(flight);
    }

    /**
     * Returns all of the costs from each flight in an itinerary.
     *
     */
    public ArrayList<Double> getCosts(ArrayList<Flight> flights) {
        ArrayList<Double> costs = new ArrayList<Double>();

        for (Flight flight : flights) {
            costs.add(flight.getCost());
        }

        return costs;
    }

    /**
     * Calculates the total cost from all flights in this itinerary.
     */
    public double addTotalCost(ArrayList<Double> arrayList) {
        for (double cost : arrayList) {
            totalCost += cost;
        }

        return totalCost;

    }

    /**
     * Returns a Flight at the specified index.
     *
     */
    public Flight getFlightFromIndex(int flightIndex) {
        return this.flights.get(flightIndex);
    }

    /**
     * Adds the flights from another itinerary to the current itinerary.
     */
    public void mergeItineraries(Itinerary otherItinerary) {
        this.flights.addAll(otherItinerary.getFlights());
    }

    /**
     * Calculates the total cost from all flights in this itinerary.
     */
    public double getCreatedItineraryCost() {
        double returnCost = 0.00;
        for (Flight currFlight : this.flights) {
            returnCost += currFlight.getCost();
        }
        return returnCost;
    }

    /**
     * Calculates the total travel time from all flights in this itinerary.
     */
    public int getCreatedItineraryTime() {
        int returnTime = 0;
        long StopOver;
        int i = 1;

        for (Flight currFlight : flights) {
            returnTime += currFlight.getTravelTime();
            if (i < flights.size()) {
                StopOver = currFlight.getStopOverTime(flights.get(i));
                returnTime += StopOver;
            }
            i++;
        }
        return returnTime;
    }

    /**
     * Returns True if this itinerary is bookable.
     */
    public boolean ifBookable() {
        for (Flight currFlight : this.flights) {
            if (currFlight.getNumSeats() == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Itinerary other = (Itinerary) obj;
        boolean equal = false;
        for (Flight f : this.flights) {
            for (Flight o : other.flights) {
                if (f.equals(o)) {
                    equal = true;
                }
            }
        }
        return equal;
    }


    /**
     * returns a string representation of the Itinerary.
     */
    @Override
    public String toString() {
        String returnString = "";
        int time = this.getCreatedItineraryTime();
        double cost = this.getCreatedItineraryCost();
        int hours = time / 60;
        int minutes = time % 60;

        for (Flight flight : this.flights) {
            returnString += flight.getFlightNum() + ","
                    + flight.getDepartureDateTime() + ","
                    + flight.getArrivalDateTime() + "," + flight.getAirline()
                    + "," + flight.getOrigin() + "," + flight.getDestination()
                    + "\n";
        }
        returnString += String.format("%.2f", cost) + "\n"
                + String.format("%02d", hours) + ":"
                + String.format("%02d", minutes);
        return returnString;
    }
}