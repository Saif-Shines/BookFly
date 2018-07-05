package driver;

import java.io.IOException;
import java.util.ArrayList;

import flight.Flight;
import flight.FlightAlreadyExistsException;
import flight.Itinerary;
import user.Admin;
import user.UserAlreadyExistsException;
import user.UserDoesNotExistException;

/** A Driver used for autotesting the project backend. */
public class Driver {

  /**
   * Used for testing to upload the Client Info
   * Resource: https://github.com/spencerogawa/UofT/blob/master/csc207/PIII/Driver.java*/

    public static void uploadClientInfo(String path) {
    	try {
			Admin.uploadUserFile(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
  /**
   * Similar for testing parllely along with Client info*/
    public static void uploadFlightInfo(String path) {
		try {
			Admin.uploadFlightFile(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
/** This method checks for any any exception and gets the email ID of the Client*/
 public static String getClient(String email) {
		try {
			return Admin.getClient(email).toString();
		}
		catch (UserDoesNotExistException e) {
			System.err.println("UserDoesNotExistException: " + e.getMessage());
		}
		return null;
    }

    /**
     * Returns all flights that depart from origin and arrive at destination on
     * the given date.
     * date a departure date (in the format YYYY-MM-DD)
     * origin a flight origin
     * destination a flight destination
     * The flights that depart from origin and arrive at destination
     *  on the given date formatted with one flight per line in exactly this
     *  format:
     * Number,DepartureDateTime,ArrivalDateTime,Airline,Origin,Destination,Price
     * (the departure and arrival date and time are in the format
     * YYYY-MM-DD HH:MM; the price has exactly two decimal places) 
     */
    public static String getFlights(String date, String origin, String destination) {
		ArrayList<Flight> flights = Admin.getDirectFlights(
				date, origin, destination);
		return Admin.flightsToString(flights);
    }

    /**
     * Returns all itineraries that depart from origin and arrive at
     * destination on the given date. If an itinerary contains two consecutive
     * flights F1 and F2, then the destination of F1 should match the origin of
     * F2. To simplify our task, if there are more than 6 hours between the
     * arrival of F1 and the departure of F2, then we do not consider this
     * sequence for a possible itinerary (we judge that the stopover is too
     * long). In addition, the itineraries returned do not contain cycles, i.e., 
     * they do not visit the same place more than once.
     *
     * Every flight in an itinerary must have at least one seat
     * available for sale. That is, the itinerary must be bookable.
     *
     */
    public static String getItineraries(String date, String origin, String destination) {
		ArrayList<Itinerary> itineraries = new ArrayList<Itinerary>();
		itineraries = Admin.getBookableItineraries(date, origin, destination);
		return Admin.itinerariesToString(itineraries);
    }

    public static String getItinerariesSortedByCost(String date, String origin, String destination) {
		ArrayList<Itinerary> itineraries = new ArrayList<Itinerary>();
		itineraries = Admin.getBookableItineraries(date, origin, destination);
		ArrayList<Itinerary> sortedItinerary = Admin.sortItinerariesByCost(itineraries);
		return Admin.itinerariesToString(sortedItinerary);
    }
    
    /**
     * Returns the same itineraries as getItineraries produces, but sorted according
     * to total itinerary travel time, in non-decreasing order.
     */
    public static String getItinerariesSortedByTime(String date, String origin, String destination) {
		ArrayList<Itinerary> itineraries = new ArrayList<Itinerary>();
		itineraries = Admin.getBookableItineraries(date, origin, destination);
		ArrayList<Itinerary> sortedItinerary = Admin.sortItinerariesByTravelTime(itineraries);
		return Admin.itinerariesToString(sortedItinerary);
    }
}