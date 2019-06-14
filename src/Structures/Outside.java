package Structures;
import java.time.*;
public class Outside {
	Info i;
	LocalTime lt;
	//Constructor
	public Outside(Info i, LocalTime lt){
		//Which person or place
		this.i = i;
		//What time?
		this.lt = lt;
	}
	
	public Info getInfo(){
		return i;
	}
	
	
	
	}
