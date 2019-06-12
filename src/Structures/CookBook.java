package Structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CookBook {
	private HashMap<String,Recipe> cb; 
	private ArrayList<String> names;
	
	public CookBook(){
		cb = new HashMap<String,Recipe>();
		names = new ArrayList<String>();
	}
	
	public CookBook(HashMap<String,Recipe> cb,ArrayList<String> n){
		this.cb = cb;
		names = n;
	}
	
	
	public void setCookBook(HashMap<String,Recipe> ncb){
		cb = ncb;
	}
	
	public void setNames(ArrayList<String> nn){
		names = nn;
	}
	
	public HashMap<String,Recipe> getCookBook(){
		return cb;
	}
	
	public ArrayList<String> getNames() {
		return names;
	}

	//Add dish to proper places
 	public void addDish(String name, String newIngre){
 		ArrayList<String> ingre = new ArrayList<String>();
 		String[] supplyList = newIngre.split(",");
 		for(int i = 0;i<supplyList.length;i++){
 			ingre.add(supplyList[i].trim());
 		}
 		Recipe r = new Recipe(name.trim(),ingre);
 		
 		cb.put(name.trim(), r);
 		names.add(name.trim());
 		Collections.sort(names);
 	}
 	
 	//Remove disg from cook book 
 	public void removeDish(String dish){
 		cb.remove(dish);
 		int val=0; 
 		for(int i = 0; i<names.size();i++){
 			if(names.get(i).equals(dish)){
 				val = i;
 			}
 		}
 		names.remove(val);
 		System.out.println(dish+ " er blevet slettet.");
 	}
 	
 	public void addIngreToDish(String dishName, String ingre){
 		ArrayList<String> ingreList = cb.get(dishName).ingre;
 		String[] iList = ingre.split(",");
 		for(int i = 0;i<iList.length;i++){
 			ingreList.add(iList[i]);
 		}
 		Recipe r = new Recipe(dishName, ingreList);
 		
 		cb.replace(dishName, r);
 	}
 	//Show list of all available dishes
 	public void showDishes(){
 		for(int i =0;i<names.size();i++){
 			int nr = i+1;
 			System.out.println(nr+" "+names.get(i));
 		}
 	}
 	
	
}
