package menu;

import java.util.Scanner;

import logicPack.FileReadWrite;

public class Menu {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	private static void menu() {

		SubMenu submenu = new SubMenu();
		FileReadWrite readerWriter = new FileReadWrite();
		System.out.println("====== WELCOME TO YOUR ORGANIZER ======");
		try {
			submenu.setArray(readerWriter.readingFile());
		} catch (NullPointerException ex) {
			System.out.println("File is empty");
		}
		do {
			try {
				System.out.println("Choose option from the menu:");
				System.out.println("\t\t 1.Add Event.");
				System.out.println("\t\t 2.Print menu.");
				System.out.println("\t\t 3.Change menu.");
				System.out.println("\t\t 4.Delete Event.");
				System.out.println("\t\t 5.Exit");
				int choice = Integer.parseInt(scan.nextLine());
				if (choice == 1)
					submenu.createEventAddToArray();
				if (choice == 2)
					submenu.printEvents();
				if (choice == 3)
					submenu.changeEvent();
				if (choice == 4)
					submenu.deleteEvent();
				if (choice == 5)
					break;
			} catch (NumberFormatException ex) {
				System.out.println("Select option correctly!");
			}
		} while (true);
	}
}