package FlightsControl;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Scanner;

import FlightsControl.Flight.eStatus;
import FlightsControl.Flight.eType;

public class ProgramHandle {
	static int choice = -1;

	public static void startMain(FlightsControl control, Scanner scan) {
		System.out.println("---------------------HELLO AND WELCOME----------------------");
		System.out.println("--------------You Enter To FlightControlApp 2.0--------------");
		System.out.println("Lets get started!");
		hardCode(control);

		while(choice != 10)
			showMainMenu(control, scan);
	}

	private static boolean performMainAction(FlightsControl control, Scanner scan)  {
		switch (choice) {
		case 10:
			System.out.println("Have a nice day!");
			return false;
		case 1:
			return addFlight(control, scan);
		case 2:
			return cancelFlight(control, scan);
		case 3:
			return performSortAction(control, scan);
		case 4:
			return performFilterAction(control, scan);
		case 5:
			System.out.println(control.showFlights());
			return true;
		default:
			System.out.println("Wrong input! try again");
			return performFilterAction(control, scan);
		}
	}

	///arithmetic///

	private static boolean addFlight(FlightsControl control, Scanner scan) {
		String airlineName;
		eType flightType;
		String country;
		String city;
		String airport;
		int year = 0;
		int month = 0;
		int day = 0;
		LocalDate flightDate;
		Duration durationOfFlight;
		String gate;
		boolean b = false;
		scan.nextLine();

		System.out.println("Enter Airline name: ");
		airlineName = scan.nextLine();
		
		System.out.println("Enter Flight Type: (Departure, Arrival)");
		flightType = eType.valueOf(scan.nextLine());

		System.out.println("Enter the country: ");
		country = scan.nextLine();

		System.out.println("Enter the city: ");
		city  = scan.nextLine();
		
		System.out.println("Enter the airport: ");
		airport  = scan.nextLine();

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

		flightDate = LocalDate.of(year, month, day); 

		System.out.println("Enter the duration of the flight (In minutes): ");
		durationOfFlight = Duration.ofMinutes(scan.nextInt());

		scan.nextLine();
		System.out.println("Enter gate number (ex: A1)");
		gate = scan.next();

		Flight flight = new Flight(airlineName, flightType, country, city, airport, flightDate, durationOfFlight, gate);
		return control.addFlight(flight);
	}

	private static boolean cancelFlight(FlightsControl control, Scanner scan) {
		int flightChoice = 0;
		boolean b = false;
		while(!b) {
			System.out.println("Choose a flight to cancel");
			
			control.filterByStatus(eStatus.OnTime);
			System.out.println(control.showFlights());
			control.removeFilters();
			
			flightChoice = scan.nextInt();
			if(flightChoice >= 1 || flightChoice <= control.getFlights().size())
				b = true;
			else
				System.out.println("Wrong input");
		}
		return control.cancelFlight(control.getFlights().get(flightChoice-1).getFlightNumber());
	}

	///arithmetic///

	///Sort///

	private static boolean performSortAction(FlightsControl control, Scanner scan)  {
		showSortMenu();

		choice = scan.nextInt();

		switch (choice) {
		case 0:
			return false;
		case 1:
			sortFlightsByDate(control);
			return true;
		case 2:
			sortFlightsByFlightType(control);
			return true;
		case 3:
			sortFlightsByDurationOfflight(control);
			return true;
		case 4:
			sortFlightsByStatus(control);
			return true;
		default:
			System.out.println("Wrong input! try again");
			return performSortAction(control, scan);
		}
	}

	private static void sortFlightsByDate(FlightsControl control) {
		control.sortFlightsByDate();
		System.out.println(control.showFlights());	
	}
	
	private static void sortFlightsByFlightType(FlightsControl control) {
		control.sortFlightsByFlightType();
		System.out.println(control.showFlights());	
	}

	private static void sortFlightsByDurationOfflight(FlightsControl control) {
		control.sortFlightsByDurationOfflight();
		System.out.println(control.showFlights());
	}

	private static void sortFlightsByStatus(FlightsControl control) {
		control.sortFlightsByStatus();
		System.out.println(control.showFlights());
	}

	///sort///


	///Filter///

	private static boolean performFilterAction(FlightsControl control, Scanner scan)  {
		showFilterMenu();

		choice = scan.nextInt();

		switch (choice) {
		case 0:
			System.out.println(control.showFlights());
			return true;
		case 1:
			filterByAirline(control, scan);
			return performFilterAction(control, scan);
		case 2:
			filterByCountry(control, scan);
			return performFilterAction(control, scan);
		case 3:
			filterByCity(control, scan);
			return performFilterAction(control, scan);
		case 4:
			filterByAirport(control, scan);
			return performFilterAction(control, scan);
		case 5:
			filterByFlightDate(control, scan);
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
		case 9: 
			control.removeFilters();
			return true;
		default:
			System.out.println("Wrong input! try again");
			return performFilterAction(control, scan);

		}
	}

	private static void filterByAirline(FlightsControl control, Scanner scan) {
		System.out.println("Enter desired air line: ");
		scan.nextLine();
		String airline = scan.nextLine();
		control.filterByAirLine(airline);
	}

	private static void filterByCountry(FlightsControl control, Scanner scan) {
		System.out.println("Enter desired country: ");
		scan.nextLine();
		String country = scan.nextLine();
		control.filterByCountry(country);
	}

	private static void filterByCity(FlightsControl control, Scanner scan) {
		System.out.println("Enter desired city: ");
		scan.nextLine();
		String city = scan.nextLine();
		control.filterByCity(city);
	}
	
	private static void filterByAirport(FlightsControl control, Scanner scan) {
		System.out.println("Enter desired airport: ");
		scan.nextLine();
		String airport = scan.nextLine();
		control.filterByAirport(airport);
	}

	private static void filterByFlightDate(FlightsControl control, Scanner scan) {
		boolean b = false;
		int year1 = 0, year2 = 0;
		int month1 = 0, month2 = 0;
		int day1 = 0, day2 = 0;

		while(!b) {
			System.out.println("Enter start date: ");
			System.out.println("Year: ");
			year1 = scan.nextInt();

			System.out.println("Month: ");
			month1 = scan.nextInt();

			System.out.println("Day: ");
			day1 = scan.nextInt();

			if(checkDate(year1, month1, day1))
				b = true;
			else
				System.out.println("Invalid date!");
		}
		
		b = false;
		while(!b) {
			System.out.println("Enter end date: ");
			System.out.println("Year: ");
			year2 = scan.nextInt();

			System.out.println("Month: ");
			month2 = scan.nextInt();

			System.out.println("Day: ");
			day2 = scan.nextInt();

			if(checkDate(year2, month2, day2))
				b = true;
			else
				System.out.println("Invalid date!");
		}

		LocalDate start = LocalDate.of(year1, month1, day1);
		LocalDate end = LocalDate.of(year2, month2, day2);
		control.filterByFlighteDateMargin(start, end);
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

	private static void showMainMenu(FlightsControl control, Scanner scan) {
		System.out.println("\nMENU: please enter the number of the desired action:");
		System.out.println("1: Add Flight");
		System.out.println("2: Cancel Flight");
		System.out.println("3: Sort Flights");
		System.out.println("4: Filter Flights");
		System.out.println("5: Show Flights");
		System.out.println("10: EXIT");

		choice = scan.nextInt();
		if ((choice <= 5 && choice >= 1) || choice == 10) {
			if (performMainAction(control, scan))
				System.out.println("Action performed successfuly!!");

			else
				System.out.println("No action performed");
		}
	}

	private static void showSortMenu() {
		System.out.println("\nSort menu: please enter the number of the desired action:");
		System.out.println("0: Go Back To Menu");
		System.out.println("1: Sort Flights By Date");
		System.out.println("2: Sort Flights By Flight Type");
		System.out.println("3: Sort Flights By Duration Of Flight");
		System.out.println("4: Sort By Status");
	}

	private static void showFilterMenu() {
		System.out.println("\nFilter menu: please enter the number of the desired action:");
		System.out.println("0: Go Back To Menu and see filtered flights");
		System.out.println("1: Filter Flights By Air Line");
		System.out.println("2: Filter Flights By Country");
		System.out.println("3: Filter Flights By City");
		System.out.println("4: Filter Flights By Airport");
		System.out.println("5: Filter Flights By Flight Date");
		System.out.println("6: Filter Flights By Duration Of Flight");
		System.out.println("7: Filter Flights By Gate");
		System.out.println("8: Filter Flights By Status");
		System.out.println("9: Remove Filters");
	}

	///show menus///

	private static void hardCode(FlightsControl control) {
		///hard code///

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

		///hard code///
	}

	private static boolean checkDate(int year, int month, int day) { // check if date is from now on
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
