package menu;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import eventObjects.Event;
import eventObjects.EventsException;
import eventObjects.SetEventObject;
import logicPack.*;

public class SubMenu {

	private final static Scanner SCAN = new Scanner(System.in);
	private static final String DATE_FORMAT = "dd/MM/yyyy/hh";

	private ChangeEvent change = new ChangeEvent();
	private PrintEvents print = new PrintEvents();
	private SetEventObject eventSet = new SetEventObject();
	private FileReadWrite readWriteFile = new FileReadWrite();
	private ChecksTimeLine check = new ChecksTimeLine();

	private ArrayList<Event> array = new ArrayList<Event>();

	public void createEventAddToArray() {
		do {
			try {
				Event event = new Event();
				System.out.println("Enter date for your event(" + DATE_FORMAT + "):");
				event.setDate(eventSet.setDate(SCAN));
				eventSet.printTypeMenu();
				event.setType(eventSet.setType(SCAN.nextLine()));
				eventSet.printMarkerMenu();
				event.setMarker(eventSet.setMarker(SCAN.nextLine()));
				System.out.println("Enter little description");
				event.setDescription(eventSet.setDescription(SCAN));
				check.checkForAnotherEvent(array, event);
				array.add(event);
				readWriteFile.writingFile(array);
				print.printEvent(event);
				break;

			} catch (NumberFormatException ex) {
				System.out.println("Incorrect option!");
			} catch (NullPointerException ex) {
				System.out.println("Incorrect value!");
			} catch (EventsException ex) {
				System.out.println("");
			}
		} while (true);
	}

	public void printEvents() {
		do {
			try {
				System.out.println("Select option from the menu:");
				System.out.println("\t\t1.Print events for the day.");
				System.out.println("\t\t2.Print events for next 7 days.");
				System.out.println("\t\t3.Print events for next month.");
				System.out.println("\t\t4.Print all events.");
				System.out.println("\t\t5.Exit this menu.");
				int choice = Integer.parseInt(SCAN.nextLine());
				if (choice == 1)
					print.printDay(array);
				if (choice == 2)
					print.printWeek(array);
				if (choice == 3)
					print.printMonth(array);
				if (choice == 4)
					print.printEventTable(array);
				if (choice == 5)
					break;
			} catch (NumberFormatException ex) {
				System.out.println("Select option correctly!");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} while (true);
	}

	public void changeEvent() {
		do {
			try {
				System.out.println("Select option from the menu:");
				System.out.println("\t\t1.Date.");
				System.out.println("\t\t2.Type.");
				System.out.println("\t\t3.Marker.");
				System.out.println("\t\t4.Description.");
				System.out.println("\t\t5.Exit.");
				int choice = Integer.parseInt(SCAN.nextLine());
				if (choice == 5)
					break;
				print.printEventTable(array);
				System.out.println("Enter the identification number of the event:");
				Event event = change.findEvent(array, SCAN.nextLine());
				if (event == null)
					System.out.println("There is no event:");
				else {
					if (choice == 1) {
						event = change.changeDate(event);
					}
					if (choice == 2) {
						event = change.changeType(event);
					}
					if (choice == 3) {
						event = change.changeMarker(event);
					}
					if (choice == 4) {
						event = change.changeDescription(event, SCAN.nextLine());
					}
				}
				print.printEvent(event);
				array.remove(event);
				array.add(event);
				readWriteFile.writingFile(array);
			} catch (NumberFormatException ex) {
				System.out.println("Select option correctly.");
			} catch (NullPointerException ex) {
				System.out.println("There isn't such element.");
			}
		} while (true);
	}

	public void deleteEvent() {
		if(array.isEmpty())
			System.out.println("There arent events yet");
		else{
		print.printEventTable(array);
		System.out.println("Enter the identification number of the event:");
		Event event = change.findEvent(array, SCAN.nextLine());
		if (array.remove(event))
			System.out.println("\t\tDone!");
		readWriteFile.writingFile(array);
		}
	}

	public void setArray(ArrayList<Event> array) {
		this.array = array;
	}

}
