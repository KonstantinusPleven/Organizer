package logicPack;

import java.util.ArrayList;

import eventObjects.Event;

public class DeleteEvent {
	
	public boolean deleting(ArrayList<Event> array, String indentification){
		Event event  = null;
		for(int i = 0; i<array.size();i++){
			event =(Event) array.get(i);
			if(event.getIdentificationNumber()==Integer.parseInt(indentification)){
				array.remove(event);
				return true;
			}
		}
		return false;
	}
	
}
