package FlightsControl;

import java.time.Duration;
import java.time.LocalDate;

public class ProgramHandle {

	public static void main(String[] args) {
	// hard code
		FlightsControl fc= new FlightsControl();
		//1
		LocalDate ld= LocalDate.of(2021, 5, 14);
		LocalDate ld1= LocalDate.of(2021, 5, 19);
		Duration d= Duration.ofMinutes(300);
		Flight f = new Flight("El Al", "Israel", "Madrid", ld, d, ld1, "A1");
		fc.addFlight(f);
		//2
		LocalDate ld2= LocalDate.of(2021, 6, 26);
		LocalDate ld3= LocalDate.of(2021, 7, 15);
		Duration d1= Duration.ofMinutes(250);
		Flight f1 = new Flight("Air France", "Israel", "Paris", ld2, d1, ld3, "B5");
		fc.addFlight(f1);
		//3
		LocalDate ld4= LocalDate.of(2021, 1, 10);
		LocalDate ld5= LocalDate.of(2021, 2, 1);
		Duration d2= Duration.ofMinutes(500);
		Flight f2 = new Flight("Air India", "Israel", "Delhi", ld4, d2, ld5, "C2");
		fc.addFlight(f2);
		//4
		LocalDate ld6= LocalDate.of(2021, 4, 10);
		LocalDate ld7= LocalDate.of(2021, 4, 17);
		Duration d3= Duration.ofMinutes(90);
		Flight f3 = new Flight("Turkish Airlines", "Israel", "Istanbul", ld6, d3, ld7, "A2");
		fc.addFlight(f3);
		//5
		LocalDate ld8= LocalDate.of(2021, 3, 28);
		LocalDate ld9= LocalDate.of(2021, 4, 26);
		Duration d4= Duration.ofMinutes(800);
		Flight f4 = new Flight("Air Canada", "Israel", "Toronto", ld8, d4, ld9, "B2");
		fc.addFlight(f4);
		//6
		LocalDate ld10= LocalDate.of(2021, 8, 16);
		LocalDate ld11= LocalDate.of(2021, 9, 1);
		Duration d5= Duration.ofMinutes(640);
		Flight f5 = new Flight("Thai Airways", "Israel", "Bangkok", ld10, d5, ld11, "C1");
		fc.addFlight(f5);
		//7
		LocalDate ld12= LocalDate.of(2021, 10, 10);
		LocalDate ld13= LocalDate.of(2021, 11, 10);
		Duration d6= Duration.ofMinutes(110);
		Flight f6 = new Flight("Pegasus Airlines", "Israel", "Athens", ld12, d6, ld13, "C3");
		fc.addFlight(f6);
		//8 
		LocalDate ld14= LocalDate.of(2021, 12, 3);
		LocalDate ld15= LocalDate.of(2021, 12, 14);
		Duration d7= Duration.ofMinutes(200);
		Flight f7 = new Flight("Israir", "Israel", "Rome", ld14, d7, ld15, "A3");
		fc.addFlight(f7);
		//9
		LocalDate ld16= LocalDate.of(2021, 7, 28);
		LocalDate ld17= LocalDate.of(2021, 8, 16);
		Duration d8= Duration.ofMinutes(700);
		Flight f8 = new Flight("Vietnam Airlines", "Israel", "Hanoi", ld16, d8, ld17, "B3");
		fc.addFlight(f8);
		//10
		LocalDate ld18= LocalDate.of(2021, 2, 7);
		LocalDate ld19= LocalDate.of(2021, 2, 28);
		Duration d9= Duration.ofMinutes(230);
		Flight f9 = new Flight("El Al", "Israel", "Vienna", ld18, d9, ld19, "A1");
		fc.addFlight(f9);
		//11
		LocalDate ld20= LocalDate.of(2021, 4, 15);
		LocalDate ld21= LocalDate.of(2021, 6, 1);
		Duration d10= Duration.ofMinutes(850);
		Flight f10 = new Flight("Air Canada", "Israel", "New York", ld20, d10, ld21, "B1");
		fc.addFlight(f10);
		//12
		LocalDate ld22= LocalDate.of(2021, 5, 19);
		LocalDate ld23= LocalDate.of(2021, 6, 1);
		Duration d11= Duration.ofMinutes(360);
		Flight f11 = new Flight("Air France", "Israel", "London", ld22, d11, ld23, "B1");
		fc.addFlight(f11);
		
		
		System.out.println(fc.showFlights());
		

	//
		
	}

}
