package logicPack;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import eventObjects.Event;

public class PrintEvents {

	private final static String DATE_FORMAT = "dd/mm/yyyy/hh";
	private final static String PRINT_TABLE = "|%24s|%32s|%16s|%28s|%n";
	private final static String DESC_TABLE = "|%103s|%n";
	private final static String LINE = "|=======================================================================================================|";

	public void printEventTable(ArrayList<Event> array) {
		System.out.println(LINE);
		System.out.format(PRINT_TABLE, "Identification:     ", "Date:     ", "Type:     ", "Marker:     ");
		System.out.println(LINE);
		for (int i = 0; i < array.size(); i++) {
			Event event = (Event) array.get(i);
			System.out.format(PRINT_TABLE, event.getIdentificationNumber(), event.getDate().toString(), event.getType(),
					event.getMarker());
			System.out.format(DESC_TABLE, event.getDescription());
			System.out.println(LINE);
		}
	}

	public void printDay(ArrayList<Event> array) throws ParseException {
		System.out.println(LINE);
		System.out.format(PRINT_TABLE, "Identification:", "Date", "Type:", "Marker:");
		System.out.println(LINE);
		for (int i = 0; i < array.size(); i++) {
			Event event = (Event) array.get(i);
			if (event.getDate().before(getCurrentDay()))
				System.out.format(PRINT_TABLE, event.getIdentificationNumber(), event.getDate().toString(), event.getType(),
						event.getMarker());
			System.out.format(DESC_TABLE, event.getDescription());
			System.out.println(LINE);
		}
	}

	public void printEvent(Event event) {
		System.out.println(LINE);
		System.out.format(PRINT_TABLE, "Identification:", "Date", "Type:", "Marker:");
		System.out.println(LINE);
		System.out.format(PRINT_TABLE, event.getIdentificationNumber(), event.getDate().toString(), event.getType(),
				event.getMarker());
		System.out.format(DESC_TABLE, event.getDescription());
		System.out.println(LINE);
	}

	public void printWeek(ArrayList<Event> array) throws ParseException {
		System.out.println(LINE);
		System.out.format(PRINT_TABLE, "Identification:", "Date", "Type:", "Marker:");
		System.out.println(LINE);
		for (int i = 0; i < array.size(); i++) {
			Event event = (Event) array.get(i);
			if (event.getDate().before(getCurrentTimePlusSevenDays()))
				System.out.format(PRINT_TABLE, event.getIdentificationNumber(), event.getDate().toString(), event.getType(),
						event.getMarker());
			System.out.format(DESC_TABLE, event.getDescription());
			System.out.println(LINE);
		}
	}

	public void printMonth(ArrayList<Event> array) throws ParseException {
		System.out.println(LINE);
		System.out.format(PRINT_TABLE, "Identification:", "Date", "Type:", "Marker:");
		System.out.println(LINE);
		for (int i = 0; i < array.size(); i++) {
			Event event = (Event) array.get(i);
			if (event.getDate().before(getCurrentTimePlusOneMonth())) {
				System.out.format(PRINT_TABLE, event.getIdentificationNumber(), event.getDate().toString(), event.getType(),
						event.getMarker());
				System.out.format(DESC_TABLE, event.getDescription());
				System.out.println(LINE);
			}
		}

	}

	private Date getCurrentTimePlusSevenDays() throws ParseException {
		
		LocalDate today = LocalDate.now();
		LocalDate date1Day = today.plus(7, ChronoUnit.DAYS);
		String[] splittedDate = date1Day.toString().split("-");
		StringBuilder timeAfteSevenDays = new StringBuilder();
		DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		timeAfteSevenDays.append(splittedDate[2]);
		timeAfteSevenDays.append("/");
		timeAfteSevenDays.append(splittedDate[1]);
		timeAfteSevenDays.append("/");
		timeAfteSevenDays.append(splittedDate[0]);
		timeAfteSevenDays.append("/00");
		Date date = (Date) formatter.parse(timeAfteSevenDays.toString());

		return date;
	}

	private Date getCurrentTimePlusOneMonth() throws ParseException {
		
		LocalDate today = LocalDate.now();
		LocalDate date1Day = today.plus(1, ChronoUnit.MONTHS);
		String[] splittedDate = date1Day.toString().split("-");
		StringBuilder timeAfteMonth = new StringBuilder();
		DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		timeAfteMonth.append(splittedDate[2]);
		timeAfteMonth.append("/");
		timeAfteMonth.append(splittedDate[1]);
		timeAfteMonth.append("/");
		timeAfteMonth.append(splittedDate[0]);
		timeAfteMonth.append("/00");
		Date date = (Date) formatter.parse(timeAfteMonth.toString());
		return date;
	}

	private Date getCurrentDay() throws ParseException {
		
		LocalDate today = LocalDate.now();
		LocalDate date1Day = today.plus(1, ChronoUnit.DAYS);
		String[] splittedDate = date1Day.toString().split("-");
		StringBuilder timeAfteSevenDays = new StringBuilder();
		DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		timeAfteSevenDays.append(splittedDate[2]);
		timeAfteSevenDays.append("/");
		timeAfteSevenDays.append(splittedDate[1]);
		timeAfteSevenDays.append("/");
		timeAfteSevenDays.append(splittedDate[0]);
		timeAfteSevenDays.append("/23");
		Date date = (Date) formatter.parse(timeAfteSevenDays.toString());

		return date;
	}
}
