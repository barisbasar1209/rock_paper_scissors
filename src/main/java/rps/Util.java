package rps; 

public class Util {
	
	final static String RESET = "\u001B[0m"; 	
	final static String WHITE = "\u001B[97m"; 
	final static String RED = "\u001B[91m"; 
	final static String GREEN = "\u001B[92m"; 
	final static String YELLOW = "\u001B[93m";
	
	final static String[] R = {"#######   ","#      #  ","#      #  ","#      #  ","#######   ","#    #    ","#     #   ","#      #  "}; 
	final static String[] O = {" #####    ","#     #   ","#     #   ","#     #   ","#     #   ","#     #   ","#     #   "," #####    "}; 
	final static String[] C = {" ######   ","#     #   ","#     #   ","#         ","#         ","#     #   ","#     #   "," ######   "};
	final static String[] K = {"#     #   ","#    #    ","#   #     ","#  #      ","# ###     ","#    #    ","#     #   ","#     #   "};
	final static String[] P = {"#######   ","#      #  ","#      #  ","#      #  ","#######   ","#         ","#         ","#         "};
	final static String[] A = {" #####    ","#     #   ","#     #   ","#     #   ","#######   ","#     #   ","#     #   ","#     #   "};
	final static String[] E = {"#######   ","#         ","#         ","#         ","#######   ","#         ","#         ","#######   "};
	final static String[] S = {"          ","          ","          ","          ","          ","          ","          ","          "};
	final static String[] I = {"          ","          ","          ","          ","          ","          ","          ","          "};

	public static String insertIcon(String string, int idx, String replacement) {
		String retString = ""; 
		retString = string.substring(0, idx) + replacement + string.substring(idx+2);
		return retString; 
	}
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

	public static String padLeft(String string, int padSize, char symbol){
		for (int i = 0; i<padSize; i++){
			string = symbol + string; 		
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
