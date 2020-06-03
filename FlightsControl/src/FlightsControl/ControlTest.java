package FlightsControl;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import FlightsControl.Flight.eType;



public class ControlTest {

	@Test
	public void addFlightTest() {
		
	}

	private FlightsControl createControl() {
		FlightsControl control = new FlightsControl();
		
		//1
		LocalDate ld= LocalDate.of(2021, 5, 14);
		Duration d= Duration.ofMinutes(420);
		Flight f = new Flight("El Al", eType.Departure, "Spain", "Madrid", "Barajas", ld, d, "A1");
		control.addFlight(f);
		//2
		LocalDate ld1= LocalDate.of(2021, 6, 26);
		Duration d1= Duration.ofMinutes(650);
		Flight f1 = new Flight("Air France", eType.Arrival, "France", "Paris", "Charles de Gaulle", ld1, d1, "B5");
		control.addFlight(f1);
		//3
		LocalDate ld2= LocalDate.of(2021, 1, 10);
		Duration d2= Duration.ofMinutes(500);
		Flight f2 = new Flight("Air India", eType.Departure, "India", "Delhi", "Indira Gandhi", ld2, d2, "C2");
		control.addFlight(f2);
		//4
		LocalDate ld3= LocalDate.of(2021, 4, 10);
		Duration d3= Duration.ofMinutes(160);
		Flight f3 = new Flight("Turkish Airlines", eType.Departure, "Turkey", "Istanbul", "Istanbul", ld3, d3, "A2");
		control.addFlight(f3);
		//5
		LocalDate ld4= LocalDate.of(2021, 3, 28);
		Duration d4= Duration.ofMinutes(650);
		Flight f4 = new Flight("Air Canada", eType.Arrival, "Canada", "Toronto", "Pearson", ld4, d4, "B2");
		control.addFlight(f4);
		//6
		LocalDate ld5= LocalDate.of(2021, 8, 16);
		Duration d5= Duration.ofMinutes(900);
		Flight f5 = new Flight("Thai Airways", eType.Arrival, "Thailand", "Bangkok", "Suvarnabhumi ", ld5, d5, "C1");
		control.addFlight(f5);
		//7
		LocalDate ld6= LocalDate.of(2021, 10, 10);
		Duration d6= Duration.ofMinutes(450);
		Flight f6 = new Flight("Pegasus Airlines", eType.Departure, "Greece", "Athens", "Eleftherios Venizelos", ld6, d6, "C3");
		control.addFlight(f6);
		//8 
		LocalDate ld7= LocalDate.of(2021, 12, 3);
		Duration d7= Duration.ofMinutes(200);
		Flight f7 = new Flight("Israir", eType.Arrival, "Italy", "Rome", "Aeroporto Leonardo da Vinci di Fiumicino", ld7, d7, "A3");
		control.addFlight(f7);
		//9
		LocalDate ld8= LocalDate.of(2021, 7, 28);
		Duration d8= Duration.ofMinutes(700);
		Flight f8 = new Flight("Vietnam Airlines", eType.Departure, "Vietnam", "Hanoi", "Noi Bai", ld8, d8, "B3");
		control.addFlight(f8);
		//10
		LocalDate ld9= LocalDate.of(2021, 2, 7);
		Duration d9= Duration.ofMinutes(940);
		Flight f9 = new Flight("El Al", eType.Departure, "Austria", "Vienna", "Vienna", ld9, d9, "A1");
		control.addFlight(f9);
		//11
		LocalDate ld10= LocalDate.of(2021, 4, 15);
		Duration d10= Duration.ofMinutes(25);
		Flight f10 = new Flight("Turkish Airlines", eType.Arrival, "United States", "New York", "JFK", ld10, d10, "B1");
		control.addFlight(f10);
		//12
		LocalDate ld11= LocalDate.of(2021, 5, 19);
		Duration d11= Duration.ofMinutes(360);
		Flight f11 = new Flight("El Al", eType.Departure, "England", "London", "Heathrow", ld11, d11, "B17");
		control.addFlight(f11);
		
		return control;
	}
}
