package FlightsControl;

import java.time.Duration;
import java.time.LocalDate;

public class ProgramHandle {

	public static void main(String[] args) {
	// hard code
		FlightsControl fc= new FlightsControl();
		
		LocalDate ld= LocalDate.of(2021, 5, 14);
		LocalDate ld1= LocalDate.of(2021, 5, 15);
		
		Duration d= Duration.ofMinutes(300);
		
		Flight f = new Flight("El al", "Israel", "Madrid", ld, d, ld1, "A1");
		
		fc.addFlight(f);
		
		System.out.println(f);

		









	//
		
	}

}
