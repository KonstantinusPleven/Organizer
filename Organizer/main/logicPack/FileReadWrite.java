package logicPack;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import eventObjects.Event;

public class FileReadWrite {

	private final static String FILE_NAME = "SavesTest.bin";

	public void writingFile(ArrayList<Event> array) {
		try (ObjectOutputStream objectWriter = new ObjectOutputStream(new FileOutputStream(new File(FILE_NAME)))) {
			for (int i = 0; i < array.size(); i++)
				objectWriter.writeObject(array.get(i));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e){
		}
	}

	public ArrayList<Event> readingFile() {
		Object currentObject = null;
		ArrayList<Event> array = new ArrayList<Event>();
		try (ObjectInputStream objectReader = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
			while ((currentObject = objectReader.readObject()) != null) {
				Event event = (Event) currentObject;
				array.add(event);
			}
			return array;
		}catch(EOFException ex){
		} catch (FileNotFoundException ex) {
			System.out.println("There is no events saved yet.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return array;
	}
}
