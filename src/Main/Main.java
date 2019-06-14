package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Structures.AlwaysList;
import Structures.CookBook;
import Structures.MealPlan;
import Structures.Outside;
import Structures.Info;
import Structures.PeoplePlaces;
import Structures.Recipe;
import Structures.ShoppingList;
import tools.IO;

public class Main {
	static MealPlan mp; 
	static ShoppingList sl;
	static AlwaysList al;
	static CookBook cb;
	static PeoplePlaces pp;
	static boolean isCb;
	static boolean isMp;
	static boolean isAl;
	static boolean isPp;
	static IO io;
	
	
	

	
	public static void main(String[] args) {
		readIn();
		mainMenu(); 

	}
	//Basic read read - checks if already used or not
	public static void readIn(){
		int na = newApp();
		if(na==0){
			initApp();
		}else{
			ArrayList<Boolean> list = io.readAvailable();
			if(list.get(0)==true){
				isCb = true;
				io.readCookBook(cb);
			}else{
				isCb= false;
			}
			
			if(list.get(1)==true){
				isPp = true;
				io.readPeoplePlaces(pp);
			}else{
				isPp = false;
			}
			if(list.get(2)){
				isMp = true;
				io.readMealPlan(mp);
			}else{
				isMp = false;
			}
			if(list.get(3)==true){
				isAl = true;
				io.readAlwaysList(al);
			}else{
				isAl=false;
			}
		}
	}

	//Initializes all parts 
	public static void initApp(){
		mp = new MealPlan();
		al = new AlwaysList();
		cb = new CookBook();		
		sl = new ShoppingList(al,cb);
		pp = new PeoplePlaces();
	}
	
	//Create file if program has never been used
	public static int newApp(){
		//creating File instance to reference text file in Java
        File text = new File("app.eat");
      
        try {
			Scanner scnr = new Scanner(text);
			if(scnr.hasNextLine()){
			int n = scnr.nextInt();	
			
			if (n==0){
				return 0;
			}else if (n==1){
				return 1;
			}
			}			
		} catch (FileNotFoundException e) {
		System.out.println("Filen kunne ikke indlæses");
		}
        return 0;
		
	}
	
	
	
	
	/*
	 * Main menu with options
	 */
	public static void mainMenu(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Velkommen til madplan");
		System.out.println("Vælg: ");
		System.out.println("1 Opskrifter");
		System.out.println("2 Madplan");
		System.out.println("3 Indkøbsliste");
		System.out.println("4 Venner og restauranter");
		int val =sc.nextInt();
		switch(val){
			case 1: menuCookbook(cb); break;
			case 2: menuMealPlan(mp); break;
			case 3: menuShoppingList(sl); break;
			case 4: menuOutside();
			default: mainMenu();
		}
		
	}
	
	/* 
	 * Menu for recipes in the database
	 */
	public static void menuCookbook(CookBook cb){
		Scanner sc = new Scanner(System.in);
		System.out.println("Opskrifter");
		ArrayList<String> dishes = cb.getNames();
		System.out.println("Hvad vil med retterne?");
		System.out.println("1 tilføje en ret");
		System.out.println("2 slette en ret");
		System.out.println("3 ændre hvad der mangler i en ret");
		int val= sc.nextInt();
		switch(val){
		case 1: addMealToCookBook();break;
		case 2: removeMealFromCookBook();break;
		case 3:
		default: mainMenu();
		}
	}
	
	/*
	 * Mealplan for the week
	 */
	public static void menuMealPlan(MealPlan mp){
		Scanner sc = new Scanner(System.in);
		mp.showPlan();
		System.out.println("1 Tilføj ret/ven til en dag");
		System.out.println("2 Slet valget for en dag");
		System.out.println("3 Ryd hele madplanen");
	}
	/*
	 * Shopping list
	 */
	public static void menuShoppingList(ShoppingList sl){
		Scanner sc = new Scanner(System.in);
		sl.openList();
		
	}
	
	
	/*
	 *List of friends and restaurant
	 */
	public static void menuOutside(){
		
	}
	
	
	//Not finished - will be used to change list of ingredients for a dish
	public static void changeIngreInDish(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Find ret");
		String name = sc.nextLine();
		
		
		
	}
	
	public static void addMealToCookBook(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Navn på ret:");
		String name = sc.nextLine();
		System.out.println("Hvilke ingredienser skal købes ind?");
		System.out.println("Adskil hvert element med ,");
		String ingre = sc.nextLine();
		cb.addDish(name, ingre);
		menuCookbook(cb);
	}
	
	public static void removeMealFromCookBook(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Skriv navn på ret som skal slettes");
		String name = sc.nextLine();
		cb.removeDish(name);
	}
	
	//This adds a meal to the meal plan, varies if recipe is new or old
	public void addMealToMealplan(String name, String ingre, Boolean old,int day ){
			if(old==true){
				mp.setMealinMealPlan(day, name);
				mp.setAppInList('r', day);
				
			}else{
				cb.addDish(name, ingre);
				mp.setMealinMealPlan(day, name);
				mp.setAppInList('r', day);
			}
	}
	
	//Adds a friend/restauranr to meal plan
	public void addFoRToMealplan(String name, Outside o, Boolean old,int day ){
		if(old==true){
			mp.setMeetInOutList(day, o);
			mp.setAppInList('o', day);
			
		}else{
			pp.addOutside(name, o);
			mp.setMeetInOutList(day, o);
			mp.setAppInList('o', day);
		}
	}
	
	
	public void removeDishFromMealPlan(int day){
		mp.clearDay(day, true);
		sl.getMeals()[day-1] = null;
	}
	
	public void removeFoRFromMealPlan(int day){
		mp.clearDay(day, false);
		sl.getMeals()[day-1]=null;
	}

	/*
	 * Lets you choose a dish or friend/restaurant from a list
	 */
	public int getNumberFromList(ArrayList<String> list, Boolean meal){
		for(int i =0;i<list.size();i++){
			System.out.println(i+" "+list.get(i));
		}
		Scanner sc = new Scanner(System.in);
		if(meal==true){
			System.out.println("Vælg ret");
		}else{
			System.out.println("vælg ven/sted");
		}
		int val =sc.nextInt();
		return val;
	}
}