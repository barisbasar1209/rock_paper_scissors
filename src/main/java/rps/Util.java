package rps; 

public class Util {
	public static String replaceIdx(String string, int idx, char replacement) throws RuntimeException{
		char[] tmp = string.toCharArray(); 
		if (idx>=0 && idx<tmp.length){
			tmp[idx] = replacement; 
		}
		else {
			throw new RuntimeException ("invalid index in util.replace. Index is " + idx + " length is " + tmp.length + "."); 
		}	
		String retString = new String(tmp); 
		return retString; 
		
	}
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
