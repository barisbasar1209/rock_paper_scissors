package rps; 

public class Util {

	public static void refresh(){
		System.out.print("\033[H\033[2J"); 
		System.out.flush(); 	
	}

	public static String padLeft(String string, int padSize){
		for (int i = 0; i<padSize; i++){
			string = " " + string; 		
		}	
		return string; 
	}
	
	public static String padRight(String string, int padSize){
		for (int i = 0; i<padSize; i++){
			string = string + " "; 		
		}	
		return string; 
	}

}
