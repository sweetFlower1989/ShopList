package Structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PeoplePlaces {
	private HashMap<String,Info> friendList;
	private ArrayList<String> names;
	
	//All information about people and places
	//Constructor
	public PeoplePlaces(){
		friendList = new HashMap<String,Info>();
		names = new ArrayList<String>();
	}
	
	public PeoplePlaces(HashMap<String,Info> nfl,ArrayList<String> n){
		this.friendList = nfl;
		this.names = n;
	}
	
	//Get and set 
	public void setFriendlist(HashMap<String,Info> nfl){
		friendList = nfl;
	}
	
	public HashMap<String,Info> getFriendList(){
		return friendList;
	}
	//Add a new person or place to list 
	public void addOutside(String name, String address){
		Info i = new Info(name,address);
		friendList.put(name, i);
		names.add(name);
		Collections.sort(names);
	}
	//SEcond method to add people or places
	public void addOutside(String name, Outside o ){
		Info i = o.i;
		friendList.put(name, i);
		names.add(name);
		Collections.sort(names);
	}
	
	//Remove person from list 
	public void removeOutside(String name){
 		friendList.remove(name);
 		int val=0; 
 		for(int i = 0; i<names.size();i++){
 			if(names.get(i).equals(name)){
 				val = i;
 			}
 		}
 		names.remove(val);
 		System.out.println(name+ " er blevet slettet.");
 	}
	
	//Change address of person or place
	public void changeAddress(Info i, String na){
		i.changeAddress(na);
	}
	
	//Change name of place or person
	public void changeName(Info i, String nn){
		i.changeName(nn);
	}
	
	
}
