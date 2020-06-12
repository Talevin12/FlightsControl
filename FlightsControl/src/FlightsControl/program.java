package FlightsControl;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

import FlightsControl.Flight.eStatus;
import FlightsControl.Flight.eType;
//http://localhost:8000/departures?outformat=html&airline=El%20Al&country=Spain&city=Madrid&airport=Barajas&airline=El%20Al&day1=4&month1=1&year1=2020&day2=1&month2=1&year2=2022&sunday=false&monday=false&tuesday=false&wednesday=false&thursday=false&friday=true&saturday=false
//http://localhost:8000/departures?outformat=html&country=france&city=paris&airport=CDG&airline=elal&day1=4&month1=6&year1=2020&day2=31&month2=7&year2=2020&sunday=true&monday=false&tuesday=false&wednesday=true&thursday=false&friday=false&saturday=false
public class program { 

	public static void main(String[] args) throws FileNotFoundException {
		if(args.length > 0) {
			FlightsControl control = new FlightsControl();
			control.addHardCode();
			if(args.length > 1 && !args[1].equalsIgnoreCase("addFlight")) {
				String format = args[0];
				String airline = args[2];
				String country = args[3];
				String city = args[4];
				String airport = args[5];
				int day1 = Integer.parseInt(args[6]);
				int month1 = Integer.parseInt(args[7]);
				int year1 = Integer.parseInt(args[8]);
				LocalDate startDate = LocalDate.of(year1, month1, day1);
				int day2 = Integer.parseInt(args[9]);
				int month2 = Integer.parseInt(args[10]);
				int year2 = Integer.parseInt(args[11]);
				LocalDate endDate = LocalDate.of(year2, month2, day2);
				Boolean[] days = new Boolean[7];
				for(int i = 0; i < days.length; i++)
					days[i] = Boolean.parseBoolean(args[i+12]);
				String dayOfWeek = DayOfWeek.of(whichDayTrue(days)).toString();

				boolean isDepartures = args.length > 1 && args[1].equalsIgnoreCase("departures");
				if (isDepartures) {
					System.out.println("<h1>Departures</h1");
					control.removeFilters();
					control.filterByArgs(eType.Departure, airline, country, city, airport, startDate, endDate, dayOfWeek);
					System.out.println(control.showFlightsTable());
				}
				else {
					System.out.println("<h1>Arrivals</h1");
					control.removeFilters();
					control.filterByArgs(eType.Arrival, airline, country, city, airport, startDate, endDate, dayOfWeek);
					System.out.println(control.showFlightsTable());
				}
			}
			else {
				System.out.println(control.showAddFlightHTML());
			}
		}
		else { 
			int choice = 0;
			System.out.println("1- Want to load FlightsControl from flights.txt");
			System.out.println("2- Want to start regulary");
			Scanner scan = new Scanner(System.in);
			choice = scan.nextInt();
			switch(choice) {
			case 1:
				String fileName  = "flights";
				File file = new File(fileName);
				Scanner scanFile = new Scanner(file);
				FlightsControl controlFile = new FlightsControl(scanFile);
				ProgramHandle.startMain(controlFile, new Scanner(System.in));
				break;

			case 2:
				FlightsControl controlSystem = new FlightsControl();
				ProgramHandle.startMain(controlSystem, scan);
				break;
			default:
				System.out.println("Wrong input! try again");
				main(new String[0]);
			}
		}
	}

	private static int whichDayTrue(Boolean[] days) {
		int index = 0;
		for(int i = 0; i < days.length; i++)
			if(days[i]) {
				index = i+1;
				break;
			}

		if(index == 1)
			return 7;
		return index+1;
	}
}
