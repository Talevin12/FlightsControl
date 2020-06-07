package FlightsControl;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Flight {
	public static enum eType {Departure, Arrival}
	public static enum eStatus {OnTime, Canceled}
	
	private String flightNumber;
	private eType flightType;
	private String airlineName;
	private String country;
	private String city;
	private String airport;
	private LocalDate flightDate;
	private Duration flightDuration;
	private String gate;
	private eStatus status;
	
	public Flight(String airlineName, eType flightType, String country, String city, String airport, LocalDate flightDate, Duration durationOfFlight, String gate) {
		this.airlineName = airlineName;
		this.flightType = flightType;
		
		this.country = country;
		this.city = city;
		this.airport = airport;
		
		this.flightDate = flightDate;
		this.flightDuration = durationOfFlight;

		this.gate = gate;
		this.status = eStatus.OnTime;
	}
	
	public Flight(Scanner scan) throws FileNotFoundException {
		this.airlineName = scan.nextLine();
		this.flightType = eType.valueOf(scan.next());
		scan.nextLine();
		
		this.country = scan.nextLine();
		this.city = scan.nextLine();
		this.airport = scan.nextLine();
		
		this.flightDate = LocalDate.of(scan.nextInt(), scan.nextInt(), scan.nextInt());
		this.flightDuration = Duration.ofMinutes(scan.nextInt());
		
		scan.nextLine();
		this.gate = scan.next();
		scan.nextLine();
		this.status = eStatus.valueOf(scan.next());
	}
	
	public void save(PrintWriter pw) throws FileNotFoundException {
		pw.write(this.flightNumber + "\t");
		pw.write(this.airlineName + "\t");
		pw.write(this.flightType.toString() + "\t");
		
		pw.write(this.country +"\t");
		pw.write(this.city + "\t");
		pw.write(this.airport + "\t");
		
		pw.write(this.flightDate.getYear() +" "+ this.flightDate.getMonth() +" "+ this.flightDate.getDayOfMonth() +"\n");
		pw.write((int)this.flightDuration.toMinutes() +"\n");
		
		pw.write(this.gate +"\n");
		pw.write(this.status.toString() +"\n");
	}
	
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public LocalDate getFlightDate() {
		return this.flightDate;
	}
	
	public Duration getDurationOfFlight() {
		return this.flightDuration;
	}

	public eStatus getStatus() {
		return this.status;
	}

	public String getFlightNumber() {
		return this.flightNumber;
	}

	public void setStatus(eStatus status) {
		this.status = status;
	}

	public void setFlightDate(LocalDate newDate) {
		this.flightDate = newDate;
	}
	
	@Override
	public String toString() {
		String str = "Flight number: "+ this.flightNumber + " "
				   + "of Airline: "+ this.airlineName +" | "
				   + this.flightType.toString() +" from: "+ this.airport +" airport- "+ this.city +", "+ this.country +" "
				   + "in gate: "+ this.gate +" "
				   + "at "+ this.flightDate.toString() +" | "
				   + "Flight duration: "+ this.flightDuration.toMinutes() +" minutes | "
				   + "Current status: "+ this.status.toString();
		return str;
	}

	public String getDestination() {
		return this.country;
	}

	public String getAirline() {
		return this.airlineName;
	}

	public String getGate() {
		return this.gate;
	}

	public eType getType() {
		return this.flightType;
	}

	public String getCity() {
		return this.city;
	}

	public String getAirport() {
		return this.airport;
	}
}
