package Structures;

public class Info {
String name; 
String address;
	//Information about a person/restaurant
	public Info(String nn, String na){
		this.name = nn;
		this.address = na;
	}

	//Change name or address for a person/restaurant
	public void changeName(String newName){
		name = newName;
	
	}

	public void changeAddress(String newAddr){
		address = newAddr;
	}

}
