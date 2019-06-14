package tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


import Structures.Recipe;
import Structures.AlwaysList;
import Structures.CookBook;
import Structures.MealPlan;
import Structures.PeoplePlaces;

public class IO {
	
	//Read in and see if the app has been used before
	public ArrayList<Boolean> readAvailable(){
		//creating File instance to reference text file in Java
        ArrayList<Boolean> list = new ArrayList<Boolean>();
 		File text = new File("ava.eat");
 		int n = 0;
        try {
			Scanner scnr = new Scanner(text);
			if(scnr.hasNextLine()){
				String newLine = scnr.nextLine();
				String[] check = newLine.split(" ");
				if(check[1].equals("1")){
					list.add(true);
				}else{
					list.add(false);
				}
			}
			return list;
			
		} catch (FileNotFoundException e) {
		System.out.println("Filen kunne ikke indlæses");
		}
        return null;
		
		
	}
	//Read in cookbook 
	public void readCookBook(CookBook cb){
		boolean name = false; 
		boolean ingre = false;
		ArrayList<String> nl = new ArrayList<String>();
		HashMap<String,Recipe> cbl = new HashMap<String,Recipe>();
 		File text = new File("cb.eat");
        try {
			Scanner scnr = new Scanner(text);
			while(scnr.hasNextLine()){
				String line = scnr.nextLine();
				if(line.equals("name")){
					name = true;
				}
				if(line.equals("ingre")){
					name = false;
					ingre = true;
				}
				if(name==true && !line.equals("name")){
					String[] recipeNames = line.split(",");
					for(int i =0;i<recipeNames.length;i++){
						nl.add(recipeNames[i]);
					}
				}
				
				if(ingre==true && !line.equals("ingre")){
					String[] rec = line.split(":");
					String cbn = rec[0];
					String[] ingreL= rec[1].split(",");
					ArrayList<String> ingL = new ArrayList<String>();
					for(int i = 0;i<ingreL.length;i++){
						ingL.add(ingreL[i]);
					}
					Recipe r = new Recipe(cbn,ingL);
					cbl.put(cbn, r);
				}
			
			}
			cb.setCookBook(cbl);
			cb.setNames(nl);
		} catch (FileNotFoundException e) {
		System.out.println("cb.eat kunne ikke indlæses");
		}
		
	}
	//Read in the friends and restaurant
	public void readPeoplePlaces(PeoplePlaces pp){
 		File text = new File("pp.eat");
 		
        try {
			Scanner scnr = new Scanner(text);
			while(scnr.hasNextLine()){
				String nameArdr = scnr.nextLine();
				String[] nA = nameArdr.split(":");
				pp.addOutside(nA[0], nA[1]);
			}
			
		} catch (FileNotFoundException e) {
		System.out.println("pp.eat kunne ikke indlæses");
		}
	}
	//Read in meal plan
	public void readMealPlan(MealPlan mp){
		File text = new File("mp.eat");
 		int l = 0;
        try {
			Scanner scnr = new Scanner(text);
			while(scnr.hasNextLine()){
				
			}
		} catch (FileNotFoundException e) {
		System.out.println("mp.eat kunne ikke indlæses");
		}
	}
	//Read in always list
	public void readAlwaysList(AlwaysList al){
		File text = new File("al.eat");
 		
        try {
			Scanner scnr = new Scanner(text);
			
		} catch (FileNotFoundException e) {
		System.out.println("al.eat kunne ikke indlæses");
		}	
	}
	/* 
	 * Save the files - hasn't been implemented
	 */
	public void saveCookBook(CookBook cb){
		
	}
	public void savePeoplePlaces(PeoplePlaces pp){
		
	}
	
	public void saveMealPlan(MealPlan mp){
		
	}
	
	public void saveAlwaysList(AlwaysList al){
		
	}
	
	
}
