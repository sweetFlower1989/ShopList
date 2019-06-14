package Structures;

import java.util.ArrayList;

public class Recipe {
String name; 
ArrayList<String> ingre; 


	//Constructor
	public Recipe(String n, ArrayList<String> i){
		this.name = n;
		this.ingre = i;
	}
	
	//Get ingredients for a recipe
	public ArrayList<String> getIngre(){
		return ingre;
	}

 	
 	
}
