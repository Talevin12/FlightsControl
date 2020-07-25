package FlightsControl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import FlightsControl.Flight.eStatus;
import FlightsControl.Flight.eType;



public class ControlTest {
	private final FlightsControl control = new FlightsControl();
		
	///Arithmetic
	@Test
	public void addFlightTest() {
		Flight flight = new Flight("TestAirline", eType.Departure, "TestCountry", "TestCity", "TestAirport", LocalDate.of(1, 1, 1), LocalTime.of(1,0), "A1");
		control.addFlight(flight);
		assertTrue(control.getFlights().contains(flight));
	}

	@Test
	public void cancelFlightTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Departure, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(1, 1, 1), LocalTime.of(1,0), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Arrival, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(2, 2, 2), LocalTime.of(2,0), "B2");
		control.addFlight(flight1);
		control.addFlight(flight2);
		control.cancelFlight(flight1.getFlightNumber());
		assertTrue(flight1.getStatus().equals(eStatus.Canceled));
		assertTrue(flight2.getStatus().equals(eStatus.OnTime));
		control.cancelFlight(flight2.getFlightNumber());
		assertTrue(flight2.getStatus().equals(eStatus.Canceled));
		
	}

	///Arithmetic


	///Sort
	@Test
	public void sortFlightsByDateTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2, 2, 2), LocalTime.of(1,0), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(1, 1, 1), LocalTime.of(2,0), "B2");

		control.addFlight(flight1);
		control.addFlight(flight2);
		control.sortFlightsByDate();
		Flight[] test = {flight2, flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}
	
	@Test
	public void sortFlightsByTimeTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2, 2, 2), LocalTime.of(2,0), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(1, 1, 1), LocalTime.of(1,0), "B2");

		control.addFlight(flight1);
		control.addFlight(flight2);
		control.sortFlightsByTime();
		Flight[] test = {flight2, flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}

	@Test
	public void sortFlightsByFlightTypeTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2, 2, 2), LocalTime.of(1,0), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(1, 1, 1), LocalTime.of(2,0), "B2");

		control.addFlight(flight1);
		control.addFlight(flight2);
		control.sortFlightsByFlightType();
		Flight[] test = {flight2, flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}

	@Test
	public void sortFlightsByStatusTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2, 2, 2), LocalTime.of(1,0), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(1, 1, 1), LocalTime.of(2,0), "B2");

		control.addFlight(flight1);
		control.cancelFlight(flight1.getFlightNumber());
		control.addFlight(flight2);
		control.sortFlightsByStatus();
		Flight[] test = {flight2, flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}

	///Sort

	///Filter

	@Test
	public void filterByAirlineTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2, 2, 2), LocalTime.of(1,0), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(1, 1, 1), LocalTime.of(2,0), "B2");

		control.addFlight(flight1);
		control.addFlight(flight2);
		control.filterByAirLine("TestAirline1");
		Flight[] test = {flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}

	@Test
	public void filterByCountryTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2, 2, 2), LocalTime.of(1,0), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(1, 1, 1), LocalTime.of(2,0), "B2");

		control.addFlight(flight1);
		control.addFlight(flight2);
		control.filterByCountry("TestCountry1");
		Flight[] test = {flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}

	@Test
	public void filterByCityTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2, 2, 2), LocalTime.of(1,0), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(1, 1, 1), LocalTime.of(2,0), "B2");

		control.addFlight(flight1);
		control.addFlight(flight2);
		control.filterByCity("TestCity1");
		Flight[] test = {flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}

	@Test
	public void filterByAirportTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2, 2, 2), LocalTime.of(1,0), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(1, 1, 1), LocalTime.of(2,0), "B2");

		control.addFlight(flight1);
		control.addFlight(flight2);
		control.filterByAirport("TestAirport1");
		Flight[] test = {flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}
	
	

	@Test
	public void filterByFlightDateMarginTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(20, 2, 2), LocalTime.of(1,0), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(10, 1, 1), LocalTime.of(2,0), "B2");

		control.addFlight(flight1);
		control.addFlight(flight2);
		control.filterByFlightDateMargin(LocalDate.of(11,1,1), LocalDate.of(30, 1, 1));
		Flight[] test = {flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}
	
	@Test
	public void filterByFlightDayOfWeekTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2020, 6, 12), LocalTime.of(1,0), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(10, 1, 2), LocalTime.of(2,0), "B2");

		control.addFlight(flight1);
		control.addFlight(flight2);
		control.filterByDayOfWeek("Friday");
		Flight[] test = {flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}
	
	@Test
	public void filterByFlightTimeMarginTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(20, 2, 2), LocalTime.of(4,0), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(10, 1, 1), LocalTime.of(16,0), "B2");

		control.addFlight(flight1);
		control.addFlight(flight2);
		control.filterByFlightTimeMargin(LocalTime.of(0,0), LocalTime.of(12, 0));
		Flight[] test = {flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}

	@Test
	public void filterByGateTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2, 2, 2), LocalTime.of(1,0), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(1, 1, 1), LocalTime.of(2,0), "B2");

		control.addFlight(flight1);
		control.addFlight(flight2);
		control.filterByGate("A1");
		Flight[] test = {flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}

	@Test
	public void filterByStatusTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2, 2, 2), LocalTime.of(1,0), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(1, 1, 1), LocalTime.of(2,0), "B2");

		control.addFlight(flight1);
		control.addFlight(flight2);
		control.cancelFlight(flight2.getFlightNumber());
		control.filterByStatus(eStatus.OnTime);
		Flight[] test = {flight1};
		assertArrayEquals(test, control.getPresentationFlights().toArray());
	}

	///Filter

	///Show
	@Test
	public void showFlighsTest() {
		Flight flight1 = new Flight("TestAirline1", eType.Arrival, "TestCountry1", "TestCity1", "TestAirport1", LocalDate.of(2021, 4, 4), LocalTime.of(4,0), "A1");
		Flight flight2 = new Flight("TestAirline2", eType.Departure, "TestCountry2", "TestCity2", "TestAirport2", LocalDate.of(2021, 3, 3), LocalTime.of(3,0), "B2");
		Flight flight3 = new Flight("TestAirline3", eType.Arrival, "TestCountry3", "TestCity3", "TestAirport3", LocalDate.of(2021, 2, 2), LocalTime.of(2,0), "C3");
		Flight flight4 = new Flight("TestAirline4", eType.Departure, "TestCountry4", "TestCity4", "TestAirport4", LocalDate.of(2021, 1, 1), LocalTime.of(1,0), "D4");
		control.addFlight(flight1);
		control.addFlight(flight2);
		control.cancelFlight(flight2.getFlightNumber());
		control.addFlight(flight3);
		control.addFlight(flight4);
		
		StringBuffer str = new StringBuffer("Flights: \n");
		str.append("1- Flight number: "+ flight1.getFlightNumber() +" of Airline: TestAirline1 | "
				   + "Arrival from: TestAirport1 airport- TestCity1, TestCountry1 "
				   + "in gate: A1 at SUNDAY 2021-04-04T04:00 | Current status: OnTime\n");
		str.append("2- Flight number: "+ flight2.getFlightNumber() +" of Airline: TestAirline2 | "
				   + "Departure from: TestAirport2 airport- TestCity2, TestCountry2 "
				   + "in gate: B2 at WEDNESDAY 2021-03-03T03:00 | Current status: Canceled\n");
		str.append("3- Flight number: "+ flight3.getFlightNumber() +" of Airline: TestAirline3 | "
				   + "Arrival from: TestAirport3 airport- TestCity3, TestCountry3 "
				   + "in gate: C3 at TUESDAY 2021-02-02T02:00 | Current status: OnTime\n");
		str.append("4- Flight number: "+ flight4.getFlightNumber() +" of Airline: TestAirline4 | "
				   + "Departure from: TestAirport4 airport- TestCity4, TestCountry4 "
				   + "in gate: D4 at FRIDAY 2021-01-01T01:00 | Current status: OnTime\n");
		
		String t = control.showFlights();
		assertEquals(str.toString(), t);
		
	}

	///Show
}
