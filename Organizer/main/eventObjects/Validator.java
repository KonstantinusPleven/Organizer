package eventObjects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface Validator{
	
	public default void validateDate(String date){
		Pattern p = Pattern.compile("[0-9]{1,2}/[0-9]{1,2}/[0-9]{1,4}/[0-9]{1,2}");
		Matcher m = p.matcher(date);
		if(m.matches()){
		}
		else{
			throw new NumberFormatException();
		}
	}
}
