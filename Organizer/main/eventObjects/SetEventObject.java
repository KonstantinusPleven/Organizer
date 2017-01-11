package eventObjects;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SetEventObject implements Validator {

	private static final String DATE_FORMAT = "dd/MM/yyyy/hh";

	public String setMarker(String choice) {
		try {
			switch (Integer.parseInt(choice)) {
			case 1:
				return "public";
			case 2:
				return "private";
			case 3:
				return "confidential";
			default:
				return "Undifined";
			}
		} catch (NumberFormatException ex) {
			return "Undifined";
		}
	}

	public String setType(String choice) {
		try {
			switch (Integer.parseInt(choice)) {
			case 1:
				return "Meeting";
			case 2:
				return "Task";
			default:
				return "Undifined";
			}
		} catch (NumberFormatException ex) {
			return "Undifined";
		}
	}

	public Date setDate(Scanner scan) {
		do {
			try {
				String date = scan.nextLine();
				validateDate(date);
				DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
				Date dateObject = formatter.parse(date);
				return dateObject;
			} catch (NumberFormatException e) {
				System.out.println("Invalid format! Enter correct format:");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} while (true);
	}

	public void printTypeMenu() {
		System.out.println("Choose type of your event:");
		System.out.println("\t\t1.Meeting");
		System.out.println("\t\t2.Task");
	}

	public void printMarkerMenu() {
		System.out.println("Choose marker of your event:");
		System.out.println("\t\t1.Public");
		System.out.println("\t\t2.Private");
		System.out.println("\t\t3.Confidential");

	}

	public String setDescription(Scanner scan) {
		StringBuilder description = new StringBuilder();
		String input = scan.nextLine();
		description.append("Description:");
		if (input != null)
			description.append(input);
		String descriptionString = description.toString();
		return descriptionString;
	}
}
