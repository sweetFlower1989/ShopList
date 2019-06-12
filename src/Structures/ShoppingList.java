package Structures;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingList {
	private AlwaysList al; 
	private String[] meals;
	CookBook cb;

	public ShoppingList(AlwaysList alw, String[] m, CookBook ncb){
		this.al = alw;
		this.meals = m;
		this.cb = ncb;
	}
	
	public ShoppingList(AlwaysList alw, CookBook ncb){
		al = alw;
		meals = new String[7];
		cb = ncb;
	}
	
	public String[] getMeals(){
		return meals;
	}
	
	public void openList(){
		for(int i = 0;i<al.list.size();i++){
			System.out.println(al.list.get(i));
		}
		
		for(int i=0;i<meals.length;i++){
			if(meals[i]!=null){
				ArrayList<String> ingre =cb.getCookBook().get(meals[i]).ingre;
				System.out.println(meals[i]);
				for(int j =0;j<ingre.size();j++){
					System.out.println(ingre.get(i));
				}
				System.out.println();
			}
			
		}
	}
	
	
}
