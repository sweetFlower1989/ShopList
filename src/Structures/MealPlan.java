package Structures;

public class MealPlan {
private Outside[] outList;
private String[] mealList;
 private char[] list;

 	//The meal plan has 3 arrrays 
 	//First is the list for if you are eaten outside your home
 	//Second is the meals in the mealplan
 	//Last is the mealplan which indicates what has been chosen either a
 	//or a place outside.
 	public MealPlan(){
 		outList = new Outside[7];
 		mealList = new String[7];
 		list = new char[7];
	
 		for(int i=0;i<list.length;i++){
 			list[i]='0';
 		}
 	}
 
 	public void initLists(){
 		outList = new Outside[7];
 		mealList = new String[7];
 		list = new char[7];
	
 		for(int i=0;i<list.length;i++){
 			list[i]='0';
 		}
 	}
 	//Getters and setters
	public Outside[] getOutside(){
		return outList;
	}

	public String[] getMealList(){
		return mealList;
	}
	
	public char[] getList(){
		return list;
	}
	
	public void setOutside(Outside[] no){
		outList = no;
	}
	public void setMealList(String[] nm){
		mealList =nm;
	}
	
	public void setList(char[] nl){
		list = nl;
	}
	
	public void setMealinMealPlan(int day,String name){
		int val = day-1;
		mealList[val]=name;
	}
	
	public void setMeetInOutList(int day, Outside o){
		int val = day-1;
		outList[val]=o;
	}
	
	public void setAppInList(char c, int day){
		int val = day-1;
		list[val]=c;
	}
	
	//Clear a day in plan
	public void clearDay(int day, Boolean meal){
		list[day-1] = '0';
		if(meal==true){
			mealList[day-1] = null;
		}else{
			outList[day-1]=null;
		}
	}
	//Clear all lists
	public void clearLists(){
		initLists();
	}
	//Show mealplan
	public void showPlan(){
		for(int i=0;i<list.length;i++){
			String day = weekday(i);
			String thing = "";
			String time = "";
			if(list[i]=='o'){
				thing = outList[i].i.name;
				time = outList[i].lt.toString();
			}else if (list[i]=='r'){
				thing = mealList[i];
			}else{
				thing = "Intet planlagt";
			}
			
			System.out.println(day+"\t"+thing+" "+time);
		}
	}
	
	
	
	
	public String weekday(int i){
		switch(i){
		case 0: return "Mandag";
		case 1: return "Tirsdag";
		case 2: return "Onsdag";
		case 3: return "Torsdag";
		case 4: return "Fredag";
		case 5: return "Lørdag";
		case 6: return "Søndag";
		default: return "Ikke en gyldig ugedag";
		}
	}

}
