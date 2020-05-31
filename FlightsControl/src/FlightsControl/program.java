package FlightsControl;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class program {

	public static void main(String[] args) throws FileNotFoundException {
//		String fileName  = "FlightsControl\\FlightControlFile.txt";
//		Scanner scanFile = new Scanner(fileName);
//		FlightsControl controlFile = new FlightsControl(scanFile);
//		ProgramHandle.performMainAction(controlFile, scanFile);
		
		
		FlightsControl controlSystem = new FlightsControl();
		Scanner scanSystem = new Scanner(System.in);
		ProgramHandle.performMainAction(controlSystem, scanSystem);
	}
}
