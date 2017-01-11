package eventObjects;


@SuppressWarnings("serial")
public class EventsException extends Exception{
	

	@Override
	public String getMessage(){
		return "You have another event at that moment!";
		
	}

}
