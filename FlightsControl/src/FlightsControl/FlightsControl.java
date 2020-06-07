package FlightsControl;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import FlightsControl.Flight.eStatus;

public class FlightsControl {
	private ArrayList<Flight> flights;
	private ArrayList<Flight> presentationFlights;

	public FlightsControl() {
		this.flights = new ArrayList<>();
		this.presentationFlights = new ArrayList<>();
	}
	
	public FlightsControl(Scanner scan) throws FileNotFoundException {
		int flightsSize = scan.nextInt();
		this.flights = new ArrayList<>(flightsSize);
		for(int i = 0; i < flightsSize; i++) {
			this.flights.set(i, new Flight(scan));
		}
	}
	
	public void save(String fileName) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName);
		pw.write(this.flights.size() + "\n");
		for(Flight flight : this.flights) {
			flight.save(pw);
		}
	}
	///Sorting
	public void sortFlightsByDate(){
		int n = this.presentationFlights.size(); 
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i-1; j++) { 
				if (this.presentationFlights.get(j).getFlightDate().isAfter(this.presentationFlights.get(j+1).getFlightDate())) { 
					Flight temp = this.presentationFlights.get(j); 
					this.presentationFlights.set(j, this.presentationFlights.get(j+1)); 
					this.presentationFlights.set(j+1, temp); 
				} 
			}
		}
	}

	public void sortFlightsByFlightType(){
		int n = this.presentationFlights.size(); 
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i-1; j++) { 
				if (this.presentationFlights.get(j).getType().ordinal() > this.presentationFlights.get(j+1).getType().ordinal()) { 
					Flight temp = this.presentationFlights.get(j); 
					this.presentationFlights.set(j, this.presentationFlights.get(j+1)); 
					this.presentationFlights.set(j+1, temp); 
				} 
			}
		}
	}
	
	public void sortFlightsByDurationOfflight(){
		int n = this.presentationFlights.size(); 
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i-1; j++) { 
				if (this.presentationFlights.get(j).getDurationOfFlight().toMinutes() > this.presentationFlights.get(j+1).getDurationOfFlight().toMinutes()) { 
					Flight temp = this.presentationFlights.get(j); 
					this.presentationFlights.set(j, this.presentationFlights.get(j+1)); 
					this.presentationFlights.set(j+1, temp); 
				} 
			}
		}
	}
	
	public void sortFlightsByStatus() {
		int n = this.presentationFlights.size(); 
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i-1; j++) { 
				if (this.presentationFlights.get(j).getStatus().ordinal() > this.presentationFlights.get(j+1).getStatus().ordinal()) { 
					Flight temp = this.presentationFlights.get(j); 
					this.presentationFlights.set(j, this.presentationFlights.get(j+1)); 
					this.presentationFlights.set(j+1, temp); 
				} 
			}
		}
	}
	
	///Filtering
	
	public void filterByAirLine(String airline) {
		for(int i = 0; i < this.presentationFlights.size(); i++) {
			if(!this.presentationFlights.get(i).getAirline().equals(airline)) {
				this.presentationFlights.remove(i);
				i--;
			}
		}
	}
	
	public void filterByCountry(String country) {
		for(int i = 0; i < this.presentationFlights.size(); i++) {
			if(!this.presentationFlights.get(i).getDestination().equals(country)) {
				this.presentationFlights.remove(i);
				i--;
			}
		}
	}
	
	public void filterByCity(String city) {
		for(int i = 0; i < this.presentationFlights.size(); i++) {
			if(!this.presentationFlights.get(i).getCity().equals(city)) {
				this.presentationFlights.remove(i);
				i--;
			}
		}
	}
	
	public void filterByAirport(String airport) {
		for(int i = 0; i < this.presentationFlights.size(); i++) {
			if(!this.presentationFlights.get(i).getAirport().equals(airport)) {
				this.presentationFlights.remove(i);
				i--;
			}
		}
	}

	public void filterByFlighteDateMargin(LocalDate start, LocalDate end) {
		for(int i = 0; i < this.presentationFlights.size(); i++) {
			if(!(this.presentationFlights.get(i).getFlightDate().isAfter(start) && this.presentationFlights.get(i).getFlightDate().isBefore(end))) {
				this.presentationFlights.remove(i);
				i--;
			}
		}
	}
	
	public void filterByDurationOfFlight(int minHoursFlightDuration, int maxHoursFlightDuration) {
		Duration duration;
		for(int i = 0; i < this.presentationFlights.size(); i++) {
			duration = this.presentationFlights.get(i).getDurationOfFlight();
			if(((float)duration.toMinutes()/60) < minHoursFlightDuration || ((float)duration.toMinutes()/60) > maxHoursFlightDuration) {
				this.presentationFlights.remove(i);
				i--;
			}
		}
	}
	public void filterByGate(String gate) {
		for(int i = 0; i < this.presentationFlights.size(); i++) {
			if(!this.presentationFlights.get(i).getGate().equals(gate)) {
				this.presentationFlights.remove(i);
				i--;
			}
		}
	}
	public void filterByStatus(eStatus status) {
		for(int i = 0; i < this.presentationFlights.size(); i++) {
			if(!this.presentationFlights.get(i).getStatus().equals(status)) {
				this.presentationFlights.remove(i);
				i--;
			}
		}
	}
	
	public void removeFilters() {
		this.presentationFlights = this.flights;
	}
	
	
	
	/// arithmetic
	
	public ArrayList<Flight> getFlights() {
		return this.flights;
	}
	
	public ArrayList<Flight> getPresentationFlights() {
		return this.presentationFlights;
	}
	
    public static String generateFlightNumber(int n) 
    { 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"; 
  
        StringBuilder sb = new StringBuilder(n); 
 
        for (int i = 0; i < n; i++) { 
            int index 
                = (int)(AlphaNumericString.length() * Math.random()); 
  
            sb.append(AlphaNumericString.charAt(index)); 
        } 
        return sb.toString(); 
    }

	public boolean addFlight(Flight flight) {
		String flightNum = "";
		boolean b = false;
		while(!b) {
			flightNum = generateFlightNumber(8);
			if(!isFlightNumExist(flightNum))
				b = true;
		}
		flight.setFlightNumber(flightNum);
		this.flights.add(flight);
		this.presentationFlights.add(flight);
		return true;
	} 
	
	private boolean isFlightNumExist(String flightNum) {
		for(Flight flight : this.flights)
			if(flight.getFlightNumber().equals(flightNum))
				return true;
		return false;
	}

	public boolean cancelFlight(String flightNumber) {
		for(int i = 0; i < this.flights.size(); i++) {
			if(this.flights.get(i).getFlightNumber().equals(flightNumber)) {
				this.flights.get(i).setStatus(eStatus.Canceled);
				return true;
			}
		}
		return false;
	}
	
	private void refresh() {
		Flight temp = null;
		
		for(int i = 0; i < this.flights.size(); i++) {
			if(!this.flights.get(i).getFlightDate().isAfter(LocalDate.now())) {
				temp = this.flights.get(i);
				this.flights.remove(i);
				i--;
				removeFlightFromPresentList(temp);
			}
		}
	}

	private void removeFlightFromPresentList(Flight flight) {
		for(int i = 0; i < this.presentationFlights.size(); i++) {
			if(this.presentationFlights.get(i).equals(flight))
				this.presentationFlights.remove(i);
		}
	}
	
	///Displaying

	public String showFlights() {
		refresh();
		
		StringBuffer str = new StringBuffer("Flights: \n");
		for(int i = 0; i < presentationFlights.size(); i++) {
			str.append((i+1) +"- "+presentationFlights.get(i).toString() + "\n");
		}
		
		return str.toString();
	}
	
//	public String showOnTimeFlights() {
//		refresh();
//		int index = 1;
//		
//		StringBuffer str = new StringBuffer("Flights: \n");
//		for(int i = 0; i < flights.size(); i++) {
//			if(this.flights.get(i).getStatus().equals(eStatus.OnTime)) {
//				str.append((index) +"- "+flights.get(i).toString() + "\n");
//				index++;
//			}
//		}
//		return str.toString();
//	}
}
