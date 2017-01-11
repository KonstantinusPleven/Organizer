package logicPack;

import java.util.ArrayList;
import java.util.Scanner;

import eventObjects.Event;
import eventObjects.SetEventObject;

public class ChangeEvent {

	private static final String DATE_FORMAT = "dd/MM/yyyy/hh";
	private final static Scanner SCAN = new Scanner(System.in);
	private final SetEventObject set = new SetEventObject();
	
	public Event findEvent(ArrayList<Event> array, String indentification) {
		Event event = null;
		for (int i = 0; i < array.size(); i++) {
			event = (Event) array.get(i);
			if (Integer.parseInt(indentification)==event.getIdentificationNumber()) {
				return event;
			}
		}
		return null;
	}

	public Event changeType(Event event) {
		set.printTypeMenu();
		event.setType(set.setType(SCAN.nextLine()));
		return event;
	}

	public Event changeMarker(Event event) {
		set.printMarkerMenu();
		event.setMarker(set.setMarker(SCAN.nextLine()));
		return event;
	}

	public Event changeDescription(Event event, String description) {
		System.out.println("Enter little description");
		event.setDescription(description);
		return event;
	}

	public Event changeDate(Event event) {
		System.out.println("Enter date for your event(" + DATE_FORMAT + "):");
		event.setDate(set.setDate(SCAN));
		return event;
	}
}
