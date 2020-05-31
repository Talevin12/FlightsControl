package FlightsControl;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Scanner;

import FlightsControl.Flight.eStatus;

public class ProgramHandle {
	static int choice = 0;

	public static boolean performMainAction(FlightsControl control, Scanner scan)  {
		showMainMenu();

		switch (choice) {
		case 1:
			return addFlight(control, scan);
		case 2:
			return cancelFlight(control, scan);
		case 3:
			performSortAction(control, scan);
			return true;
		case 4:
			performFilterAction(control, scan);
			return true;
		default:
			System.out.println("Wrong input! try again");
			return performFilterAction(control, scan);
		}
	}

	///arithmetic///

	private static boolean addFlight(FlightsControl control, Scanner scan) {
		String airlineName;
		String origin;
		String destination;
		int year = 0;
		int month = 0;
		int day = 0;
		LocalDate departureDate;
		Duration durationOfFlight;
		LocalDate returnDate;
		String gate;
		boolean b = false;

		System.out.println("Enter Airline name: ");
		airlineName = scan.nextLine();

		System.out.println("Enter the origin location: ");
		origin = scan.nextLine();

		System.out.println("Enter the destination location: ");
		destination  = scan.nextLine();

		while(!b) {
			System.out.println("Enter departure date: ");
			System.out.println("Year: ");
			year = scan.nextInt();

			System.out.println("Month: ");
			month = scan.nextInt();

			System.out.println("Day: ");
			day = scan.nextInt();

			if(checkDate(year, month, day))
				b = true;
			else
				System.out.println("Invalid date!");
		}

		departureDate = LocalDate.of(year, month, day); 

		System.out.println("Enter the duration of the flight (In minutes): ");
		durationOfFlight = Duration.ofMinutes(scan.nextInt());

		while(!b) {
			System.out.println("Enter return date: ");
			System.out.println("Year: ");
			year = scan.nextInt();

			System.out.println("Month: ");
			month = scan.nextInt();

			System.out.println("Day: ");
			day = scan.nextInt();

			if(checkDate(year, month, day))
				if(LocalDate.of(year, month, day).isAfter(departureDate))
					b = true;
				else
					System.out.println("Invalid date!");
		}

		returnDate = LocalDate.of(year, month, day); 
		scan.nextLine();

		System.out.println("Enter gate number (ex: A1)");
		gate = scan.next();

		Flight flight = new Flight(airlineName, origin, destination, departureDate, durationOfFlight, returnDate, gate);
		return control.addFlight(flight);
	}

	private static boolean cancelFlight(FlightsControl control, Scanner scan) {
		int choice = 0;
		boolean b = false;
		while(!b) {
			System.out.println("Choose a flight to cancel");
			System.out.println(control.showFlights());
			choice = scan.nextInt();
			if(choice >= 1 || choice <= control.getFlights().size())
				b = true;
			else
				System.out.println("Wrong input");
		}
		return control.cancelFlight(control.getFlights().get(choice-1).getFlightNumber());
	}

	///arithmetic///

	///Sort///

	public static boolean performSortAction(FlightsControl control, Scanner scan)  {
		showSortMenu();
		switch (choice) {
		case 0:
			return performMainAction(control, scan);
		case 1:
			sortFlightsByDate(control);
			return performMainAction(control, scan);
		case 2:
			sortFlightsByStayingDuration(control);
			return performMainAction(control, scan);
		case 3:
			sortFlightsByDurationOfflight(control);
			return performMainAction(control, scan);
		case 4:
			sortFlightsByStatus(control);
			return performMainAction(control, scan);
		default:
			System.out.println("Wrong input! try again");
			return performSortAction(control, scan);
		}
	}

	private static void sortFlightsByDate(FlightsControl control) {
		control.sortFlightsByDate();
		control.showFlights();
	}

	private static void sortFlightsByStayingDuration(FlightsControl control) {
		control.sortFlightsByStayingDuration();
		control.showFlights();
	}

	private static void sortFlightsByDurationOfflight(FlightsControl control) {
		control.sortFlightsByDurationOfflight();
		control.showFlights();
	}

	private static void sortFlightsByStatus(FlightsControl control) {
		control.sortFlightsByStatus();
		control.showFlights();
	}

	///sort///


	///Filter///

	public static boolean performFilterAction(FlightsControl control, Scanner scan)  {
		showFilterMenu();

		switch (choice) {
		case 0:
			return performMainAction(control, scan);
		case 1:
			filterByAirLine(control, scan);
			return performFilterAction(control, scan);
		case 2:
			filterByDestination(control, scan);
			return performFilterAction(control, scan);
		case 3:
			filterByOrigin(control, scan);
			return performFilterAction(control, scan);
		case 4:
			filterByDepartureDate(control, scan);
			return performFilterAction(control, scan);
		case 5:
			filterByReturnDate(control, scan);
			return performFilterAction(control, scan);
		case 6:
			filterByDurationOfFlight(control, scan);
			return performFilterAction(control, scan);
		case 7:
			filterByGate(control, scan);
			return performFilterAction(control, scan);
		case 8:
			filterByStatus(control, scan);
			return performFilterAction(control, scan);
		default:
			System.out.println("Wrong input! try again");
			return performFilterAction(control, scan);

		}
	}

	private static void filterByAirLine(FlightsControl control, Scanner scan) {
		System.out.println("Enter desired air line: ");
		String airline = scan.nextLine();
		control.filterByAirLine(airline);
	}

	private static void filterByDestination(FlightsControl control, Scanner scan) {
		System.out.println("Enter desired destination location: ");
		String destination = scan.nextLine();
		control.filterByDestination(destination);
	}

	private static void filterByOrigin(FlightsControl control, Scanner scan) {
		System.out.println("Enter desired origin location: ");
		String origin = scan.nextLine();
		control.filterByOrigin(origin);
	}

	private static void filterByDepartureDate(FlightsControl control, Scanner scan) {
		boolean b = false;
		int year = 0;
		int month = 0;
		int day = 0;
		
		
		while(!b) {
			System.out.println("Enter departure date: ");
			System.out.println("Year: ");
			year = scan.nextInt();

			System.out.println("Month: ");
			month = scan.nextInt();

			System.out.println("Day: ");
			day = scan.nextInt();

			if(checkDate(year, month, day))
				b = true;
			else
				System.out.println("Invalid date!");
		}

		LocalDate departureDate = LocalDate.of(year, month, day);
		control.filterByDepartureDate(departureDate);
	}

	private static void filterByReturnDate(FlightsControl control, Scanner scan) {
		boolean b = false;
		int year = 0;
		int month = 0;
		int day = 0;
		
		
		while(!b) {
			System.out.println("Enter return date: ");
			System.out.println("Year: ");
			year = scan.nextInt();

			System.out.println("Month: ");
			month = scan.nextInt();

			System.out.println("Day: ");
			day = scan.nextInt();

			if(checkDate(year, month, day))
				b = true;
			else
				System.out.println("Invalid date!");
		}

		LocalDate returnDate = LocalDate.of(year, month, day);
		control.filterByReturnDate(returnDate);
	}

	private static void filterByDurationOfFlight(FlightsControl control, Scanner scan) {
		System.out.println("Enter desired min and max minutes for flight duration: ");
		System.out.println("Minimum: ");
		int min = scan.nextInt();
		System.out.println("Maximum: ");
		int max = scan.nextInt();
		control.filterByDurationOfFlight(min, max);
	}

	private static void filterByGate(FlightsControl control, Scanner scan) {
		System.out.println("Enter desired gate number: ");
		String gate = scan.next();
		control.filterByGate(gate);
	}

	private static void filterByStatus(FlightsControl control, Scanner scan) {
		System.out.println("Enter desired status: ");
		String status = scan.next();
		control.filterByStatus(eStatus.valueOf(status));
	}

	///Filter///

	///show menus///

	public static void showMainMenu() {
		System.out.println("\nMENU: please enter the number of the desired action:");
		System.out.println("0: EXIT");
		System.out.println("1: Add Flight");
		System.out.println("2: Cancel Flight");
		System.out.println("3: Sort Flights");
		System.out.println("4: Filter Flights");
	}

	public static void showSortMenu() {
		System.out.println("0: Go Back To Menu");
		System.out.println("1: Sort Flights By Date");
		System.out.println("2: Sort Flights By Staying Duration");
		System.out.println("3: Sort Flights By Duration Of Flight");
		System.out.println("4: Sort By Status");
	}

	public static void showFilterMenu() {
		System.out.println("0: Go Back To Menu");
		System.out.println("1: Filter Flights By Air Line");
		System.out.println("2: Filter Flights By Destination");
		System.out.println("3: Filter Flights By Origin");
		System.out.println("4: Filter Flights By Departure Date");
		System.out.println("5: Filter Flights By Return Date");
		System.out.println("6: Filter Flights By Duration Of Flight");
		System.out.println("7: Filter Flights By Gate");
		System.out.println("8: Filter Flights By Status");
	}

	///show menus///

	public void hardCode() {
		///hard code///

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

		///hard code///
	}

	public static boolean checkDate(int year, int month, int day) { // check if date is from now on
		int currentYear = LocalDate.now().getYear();
		int currentMonth = LocalDate.now().getMonthValue();
		int currentDay = LocalDate.now().getDayOfMonth();

		if (day < 1 || day > 31)
			return false;
		if (month < 1 || month > 12)
			return false;
		if (year < currentYear)
			return false;
		if (year == currentYear && month < currentMonth)
			return false;
		if (year == currentYear && month == currentMonth && day < currentDay)
			return false;
		return true;
	}
}
