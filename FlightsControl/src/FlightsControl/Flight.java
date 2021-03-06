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
	private LocalTime flightTime;
	private String gate;
	private eStatus status;
	
	public Flight(String airlineName, eType flightType, String country, String city, String airport, LocalDate flightDate, LocalTime flightTime,  String gate) {
		this.airlineName = airlineName;
		this.flightType = flightType;
		
		this.country = country;
		this.city = city;
		this.airport = airport;
		
		this.flightDate = flightDate;
		this.flightTime = flightTime;

		this.gate = gate;
		this.status = eStatus.OnTime;
	}
	
	public Flight(Scanner scan) throws FileNotFoundException {

		this.flightNumber = scan.next();
		this.flightType = eType.valueOf(scan.next());
		this.airlineName = scan.nextLine();
		
		this.country = scan.nextLine();
		this.city = scan.nextLine();
		this.airport = scan.nextLine();
		int year = scan.nextInt();
		this.flightDate = LocalDate.of(year, scan.nextInt(), scan.nextInt());
		scan.nextLine();
		this.flightTime = LocalTime.of(scan.nextInt(), scan.nextInt());
		 
		scan.nextLine();
		this.gate = scan.next();
		this.status = eStatus.valueOf(scan.next());
	}
	
	public void save(PrintWriter pw) throws FileNotFoundException { // from write to println 
		pw.print(this.flightNumber +" ");
		pw.print(this.flightType.toString() +" ");
		pw.print(this.airlineName +"\n");
		
		pw.print(this.country +"\n");
		pw.print(this.city +"\n");
		pw.print(this.airport +"\n");
		
		pw.print(this.flightDate.getYear() +" "+ this.flightDate.getMonthValue() +" "+ this.flightDate.getDayOfMonth() +"\n");
		pw.print(this.flightTime.getHour() +" "+ this.flightTime.getMinute() +"\n");
		
		pw.print(this.gate +"\t");
		pw.print(this.status.toString() +"\n");
		
	}
	
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public LocalDate getFlightDate() {
		return this.flightDate;
	}
	
	public LocalTime getFlightTime() {
		return this.flightTime;
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
				   + "at "+ this.flightDate.getDayOfWeek().toString() +" "
				   + LocalDateTime.of(this.flightDate, flightTime).toString() +" | "
				   + "Current status: "+ this.status.toString();
		return str;
	}
	public String toStringTable() {
		StringBuffer str = new StringBuffer();
		str.append("<td>"+ airlineName +"</td>");
		str.append("<td>"+ flightNumber +"</td>");
		str.append("<td>"+ flightDate +"</td>");
		str.append("<td>"+ flightDate.getDayOfWeek() +"</td>");
		str.append("<td>"+ flightTime +"</td>");
		str.append("<td>"+ country +"</td>");
		str.append("<td>"+ airport +"</td>");
		str.append("<td>"+ city +"</td>");
		str.append("<td>"+ gate +"</td>");
		str.append("<td>"+ status +"</td>");
		return str.toString();
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
