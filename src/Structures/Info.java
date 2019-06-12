package Structures;

public class Info {
String name; 
String address;

	public Info(String nn, String na){
		this.name = nn;
		this.address = na;
	}


	public void changeName(String newName){
		name = newName;
	
	}

	public void changeAddress(String newAddr){
		address = newAddr;
	}

}
