package Structures;

import java.util.ArrayList;
import java.util.Collections;
/*
 * This list is for things you always buy when shopping - like milk, juice and cereal.
 */
public class AlwaysList {
ArrayList<String> list;
	//Constructors
	public AlwaysList(ArrayList<String> l){
		this.list = l;
	}
	
	public AlwaysList(){
		list = new ArrayList<String>();
	}
	
	public void showList(){
		System.out.println("Indkøbsliste: ");
		if(list.size()==0){
			System.out.println("Ingen elementer på indkøbslisten");
		}else{
			for(int i=0;i<list.size();i++){
				System.out.println(i+1+" "+list.get(i));
			}
		}
	}
	
	public void insertItem(String item){
		list.add(item);
	}
		
	public void deleteItem(int[] elements){
			ArrayList<Integer> sElements = new ArrayList<Integer>();
			for(int i=0;i<elements.length;i++){
				sElements.add(elements[i]);
			}
			Collections.sort(sElements, Collections.reverseOrder());
			for(int i=0;i<sElements.size();i++){
				list.remove(i-1);
			}
		}
		
	}
				
	

