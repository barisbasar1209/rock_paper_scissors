package rps; 

import java.util.Random; 

public class Util {
	
	final static char NULLCHAR  = '\u0000'; 	

	final static String BOLD 	= "\u001B[1m";
	final static String RESET 	= "\u001B[0m"; 	
	final static String WHITE 	= "\u001B[97m"; 
	final static String RED  	= "\u001B[91m"; 
	final static String GREEN 	= "\u001B[92m"; 
	final static String YELLOW 	= "\u001B[93m"+BOLD;
	final static String BLUE 	= "\u001B[94m"; 

	final static String dividerH 	= Util.padLeft("", 185, '#');	
	final static String dividerV 	= Util.padLeft("", 22, "#"); 
	
	// different letters needed for constructing the menu page. each entry in the array corresponds to one line of the character. 
	final static String[] smallWhiteH = {"#   #   ","#   #   ","#####   ","#   #   ","#   #   "};
	final static String[] smallWhiteT = {"#####   ","  #     ","  #     ","  #     ","  #     "};
	final static String[] smallWhiteN = {"#   #   ","##  #   ","# # #   ","#  ##   ","#   #   "};
	final static String[] smallWhiteF = {"#####   ","#       ","###     ","#       ","#       "};
	final static String[] smallWhiteG = {" ####   ","#       ","# ###   ","#   #   "," ####   "};
	final static String[] smallWhiteX = {"#   #   "," # #    ","  #     "," # #    ","#   #   "};
	final static String[] smallWhiteC = {" ###    ","#   #   ","#       ","#   #   "," ###    "}; 
	final static String[] smallWhiteE = {"#####   ","#       ","#####   ","#       ","#####   "}; 
	final static String[] smallWhiteI = {"#####   ","  #     ","  #     ","  #     ","#####   "}; 
	final static String[] smallWhiteO = {" ###    ","#   #   ","#   #   ","#   #   "," ###    "}; 
	final static String[] smallWhiteS = {" ####   ","#       "," ###    ","    #   ","####    "}; 

	final static String[] smallBlueH = {BLUE+"#   #   "+RESET,BLUE+"#   #   "+RESET,BLUE+"#####   "+RESET,BLUE+"#   #   "+RESET,BLUE+"#   #   "+RESET};
	final static String[] smallBlueT = {BLUE+"#####   "+RESET,BLUE+"  #     "+RESET,BLUE+"  #     "+RESET,BLUE+"  #     "+RESET,BLUE+"  #     "+RESET};
	final static String[] smallBlueN = {BLUE+"#   #   "+RESET,BLUE+"##  #   "+RESET,BLUE+"# # #   "+RESET,BLUE+"#  ##   "+RESET,BLUE+"#   #   "+RESET};
	final static String[] smallBlueF = {BLUE+"#####   "+RESET,BLUE+"#       "+RESET,BLUE+"###     "+RESET,BLUE+"#       "+RESET,BLUE+"#       "+RESET};
	final static String[] smallBlueG = {BLUE+" ####   "+RESET,BLUE+"#       "+RESET,BLUE+"# ###   "+RESET,BLUE+"#   #   "+RESET,BLUE+" ####   "+RESET};
	final static String[] smallBlueX = {BLUE+"#   #   "+RESET,BLUE+" # #    "+RESET,BLUE+"  #     "+RESET,BLUE+" # #    "+RESET,BLUE+"#   #   "+RESET};
	final static String[] smallBlueC = {BLUE+" ###    "+RESET,BLUE+"#   #   "+RESET,BLUE+"#       "+RESET,BLUE+"#   #   "+RESET,BLUE+" ###    "+RESET}; 
	final static String[] smallBlueE = {BLUE+"#####   "+RESET,BLUE+"#       "+RESET,BLUE+"#####   "+RESET,BLUE+"#       "+RESET,BLUE+"#####   "+RESET}; 
	final static String[] smallBlueI = {BLUE+"#####   "+RESET,BLUE+"  #     "+RESET,BLUE+"  #     "+RESET,BLUE+"  #     "+RESET,BLUE+"#####   "+RESET}; 
	final static String[] smallBlueO = {BLUE+" ###    "+RESET,BLUE+"#   #   "+RESET,BLUE+"#   #   "+RESET,BLUE+"#   #   "+RESET,BLUE+" ###    "+RESET}; 
	final static String[] smallBlueS = {BLUE+" ####   "+RESET,BLUE+"#       "+RESET,BLUE+" ###    "+RESET,BLUE+"    #   "+RESET,BLUE+"####    "+RESET}; 

	final static String[] whiteR = {"#######   ","#      #  ","#      #  ","#      #  ","#######   ","#    #    ","#     #   ","#      #  "}; 
	final static String[] whiteO = {" #####    ","#     #   ","#     #   ","#     #   ","#     #   ","#     #   ","#     #   "," #####    "}; 
	final static String[] whiteC = {" ######   ","#     #   ","#     #   ","#         ","#         ","#     #   ","#     #   "," ######   "};
	final static String[] whiteK = {"#     #   ","#    #    ","#   #     ","#  #      ","# ###     ","#    #    ","#     #   ","#     #   "};
	final static String[] whiteP = {"#######   ","#      #  ","#      #  ","#      #  ","#######   ","#         ","#         ","#         "};
	final static String[] whiteA = {" #####    ","#     #   ","#     #   ","#     #   ","#######   ","#     #   ","#     #   ","#     #   "};
	final static String[] whiteE = {"#######   ","#         ","#         ","#         ","#######   ","#         ","#         ","#######   "};
	final static String[] whiteS = {" #####    ","#         ","#         "," #####    ","      #   ","      #   ","      #   ","######    "};
	final static String[] whiteI = {"#######   ","   #      ","   #      ","   #      ","   #      ","   #      ","   #      ","#######   "};

	final static String[] redR = {RED+"#######   "+RESET,RED+"#      #  "+RESET,RED+"#      #  "+RESET,RED+"#      #  "+RESET,RED+"#######   "+RESET,RED+"#    #    "+RESET,RED+"#     #   "+RESET,RED+"#      #  "+RESET}; 
	final static String[] redO = {RED+" #####    "+RESET,RED+"#     #   "+RESET,RED+"#     #   "+RESET,RED+"#     #   "+RESET,RED+"#     #   "+RESET,RED+"#     #   "+RESET,RED+"#     #   "+RESET,RED+" #####    "+RESET}; 
	final static String[] redC = {RED+" ######   "+RESET,RED+"#     #   "+RESET,RED+"#     #   "+RESET,RED+"#         "+RESET,RED+"#         "+RESET,RED+"#     #   "+RESET,RED+"#     #   "+RESET,RED+" ######   "+RESET};
	final static String[] redK = {RED+"#     #   "+RESET,RED+"#    #    "+RESET,RED+"#   #     "+RESET,RED+"#  #      "+RESET,RED+"# ###     "+RESET,RED+"#    #    "+RESET,RED+"#     #   "+RESET,RED+"#     #   "+RESET};
	final static String[] redP = {RED+"#######   "+RESET,RED+"#      #  "+RESET,RED+"#      #  "+RESET,RED+"#      #  "+RESET,RED+"#######   "+RESET,RED+"#         "+RESET,RED+"#         "+RESET,RED+"#         "+RESET};
	final static String[] redA = {RED+" #####    "+RESET,RED+"#     #   "+RESET,RED+"#     #   "+RESET,RED+"#     #   "+RESET,RED+"#######   "+RESET,RED+"#     #   "+RESET,RED+"#     #   "+RESET,RED+"#     #   "+RESET};
	final static String[] redE = {RED+"#######   "+RESET,RED+"#         "+RESET,RED+"#         "+RESET,RED+"#         "+RESET,RED+"#######   "+RESET,RED+"#         "+RESET,RED+"#         "+RESET,RED+"#######   "+RESET};
	final static String[] redS = {RED+" #####    "+RESET,RED+"#         "+RESET,RED+"#         "+RESET,RED+" #####    "+RESET,RED+"      #   "+RESET,RED+"      #   "+RESET,RED+"      #   "+RESET,RED+"######    "+RESET};
	final static String[] redI = {RED+"#######   "+RESET,RED+"   #      "+RESET,RED+"   #      "+RESET,RED+"   #      "+RESET,RED+"   #      "+RESET,RED+"   #      "+RESET,RED+"   #      "+RESET,RED+"#######   "+RESET};

	final static String[] yellowR = {YELLOW+"#######   "+RESET,YELLOW+"#      #  "+RESET,YELLOW+"#      #  "+RESET,YELLOW+"#      #  "+RESET,YELLOW+"#######   "+RESET,YELLOW+"#    #    "+RESET,YELLOW+"#     #   "+RESET,YELLOW+"#      #  "+RESET}; 
	final static String[] yellowO = {YELLOW+" #####    "+RESET,YELLOW+"#     #   "+RESET,YELLOW+"#     #   "+RESET,YELLOW+"#     #   "+RESET,YELLOW+"#     #   "+RESET,YELLOW+"#     #   "+RESET,YELLOW+"#     #   "+RESET,YELLOW+" #####    "+RESET}; 
	final static String[] yellowC = {YELLOW+" ######   "+RESET,YELLOW+"#     #   "+RESET,YELLOW+"#     #   "+RESET,YELLOW+"#         "+RESET,YELLOW+"#         "+RESET,YELLOW+"#     #   "+RESET,YELLOW+"#     #   "+RESET,YELLOW+" ######   "+RESET};
	final static String[] yellowK = {YELLOW+"#     #   "+RESET,YELLOW+"#    #    "+RESET,YELLOW+"#   #     "+RESET,YELLOW+"#  #      "+RESET,YELLOW+"# ###     "+RESET,YELLOW+"#    #    "+RESET,YELLOW+"#     #   "+RESET,YELLOW+"#     #   "+RESET};
	final static String[] yellowP = {YELLOW+"#######   "+RESET,YELLOW+"#      #  "+RESET,YELLOW+"#      #  "+RESET,YELLOW+"#      #  "+RESET,YELLOW+"#######   "+RESET,YELLOW+"#         "+RESET,YELLOW+"#         "+RESET,YELLOW+"#         "+RESET};
	final static String[] yellowA = {YELLOW+" #####    "+RESET,YELLOW+"#     #   "+RESET,YELLOW+"#     #   "+RESET,YELLOW+"#     #   "+RESET,YELLOW+"#######   "+RESET,YELLOW+"#     #   "+RESET,YELLOW+"#     #   "+RESET,YELLOW+"#     #   "+RESET};
	final static String[] yellowE = {YELLOW+"#######   "+RESET,YELLOW+"#         "+RESET,YELLOW+"#         "+RESET,YELLOW+"#         "+RESET,YELLOW+"#######   "+RESET,YELLOW+"#         "+RESET,YELLOW+"#         "+RESET,YELLOW+"#######   "+RESET};
	final static String[] yellowS = {YELLOW+" #####    "+RESET,YELLOW+"#         "+RESET,YELLOW+"#         "+RESET,YELLOW+" #####    "+RESET,YELLOW+"      #   "+RESET,YELLOW+"      #   "+RESET,YELLOW+"      #   "+RESET,YELLOW+"######    "+RESET};
	final static String[] yellowI = {YELLOW+"#######   "+RESET,YELLOW+"   #      "+RESET,YELLOW+"   #      "+RESET,YELLOW+"   #      "+RESET,YELLOW+"   #      "+RESET,YELLOW+"   #      "+RESET,YELLOW+"   #      "+RESET,YELLOW+"#######   "+RESET};

	final static String[] greenR = {GREEN+"#######   "+RESET,GREEN+"#      #  "+RESET,GREEN+"#      #  "+RESET,GREEN+"#      #  "+RESET,GREEN+"#######   "+RESET,GREEN+"#    #    "+RESET,GREEN+"#     #   "+RESET,GREEN+"#      #  "+RESET}; 
	final static String[] greenO = {GREEN+" #####    "+RESET,GREEN+"#     #   "+RESET,GREEN+"#     #   "+RESET,GREEN+"#     #   "+RESET,GREEN+"#     #   "+RESET,GREEN+"#     #   "+RESET,GREEN+"#     #   "+RESET,GREEN+" #####    "+RESET}; 
	final static String[] greenC = {GREEN+" ######   "+RESET,GREEN+"#     #   "+RESET,GREEN+"#     #   "+RESET,GREEN+"#         "+RESET,GREEN+"#         "+RESET,GREEN+"#     #   "+RESET,GREEN+"#     #   "+RESET,GREEN+" ######   "+RESET};
	final static String[] greenK = {GREEN+"#     #   "+RESET,GREEN+"#    #    "+RESET,GREEN+"#   #     "+RESET,GREEN+"#  #      "+RESET,GREEN+"# ###     "+RESET,GREEN+"#    #    "+RESET,GREEN+"#     #   "+RESET,GREEN+"#     #   "+RESET};
	final static String[] greenP = {GREEN+"#######   "+RESET,GREEN+"#      #  "+RESET,GREEN+"#      #  "+RESET,GREEN+"#      #  "+RESET,GREEN+"#######   "+RESET,GREEN+"#         "+RESET,GREEN+"#         "+RESET,GREEN+"#         "+RESET};
	final static String[] greenA = {GREEN+" #####    "+RESET,GREEN+"#     #   "+RESET,GREEN+"#     #   "+RESET,GREEN+"#     #   "+RESET,GREEN+"#######   "+RESET,GREEN+"#     #   "+RESET,GREEN+"#     #   "+RESET,GREEN+"#     #   "+RESET};
	final static String[] greenE = {GREEN+"#######   "+RESET,GREEN+"#         "+RESET,GREEN+"#         "+RESET,GREEN+"#         "+RESET,GREEN+"#######   "+RESET,GREEN+"#         "+RESET,GREEN+"#         "+RESET,GREEN+"#######   "+RESET};
	final static String[] greenS = {GREEN+" #####    "+RESET,GREEN+"#         "+RESET,GREEN+"#         "+RESET,GREEN+" #####    "+RESET,GREEN+"      #   "+RESET,GREEN+"      #   "+RESET,GREEN+"      #   "+RESET,GREEN+"######    "+RESET};
	final static String[] greenI = {GREEN+"#######   "+RESET,GREEN+"   #      "+RESET,GREEN+"   #      "+RESET,GREEN+"   #      "+RESET,GREEN+"   #      "+RESET,GREEN+"   #      "+RESET,GREEN+"   #      "+RESET,GREEN+"#######   "+RESET};

	// each array hold all three different colors a normal sized letter for the banner can have so that the color of the letter can later on be randomly decided by accessing the index with randomInt	
	final static String[][] R = {whiteR, redR, yellowR, greenR};
	final static String[][] O = {whiteO, redO, yellowO, greenO};
	final static String[][] C = {whiteC, redC, yellowC, greenC};
	final static String[][] K = {whiteK, redK, yellowK, greenK};
	final static String[][] P = {whiteP, redP, yellowP, greenP};
	final static String[][] A = {whiteA, redA, yellowA, greenA};
	final static String[][] E = {whiteE, redE, yellowE, greenE};
	final static String[][] S = {whiteS, redS, yellowS, greenS};
	final static String[][] I = {whiteI, redI, yellowI, greenI};

	// constants 
	final static int SMALLLETTERHEIGHT = 5;	
	final static int LETTERHEIGHT = 8; 
	final static int BANNERLENGTH = 17; 

	// making random accessible throughout the entire project
	static Random random = new Random(); 
	
	// returns the number of times the second argument occurs as a substring in the first argument	
	public static int countOccurrences(String string, String substring){
		int cnt = 0; 
		int idx = string.indexOf(substring); 

		while(idx != -1){
			cnt++; 
			idx = string.indexOf(substring, idx+1); 	
		}
		return cnt; 	
	}

	// returns the length the string would have without colorcodes	
	public static int colorlessLength(String string){
		int length = 0; 
		// System.out.println("RESET.length(): " + RESET.length() + "\ncountOccurrences(\""+string+"\", RESET): " + countOccurrences(string, RESET) + "\nGREEN.length(): " + GREEN.length() + "\ncountOccurrences(\"" + string + "\", GREEN): " + countOccurrences(string, GREEN) + "\nWHITE.length(): " + WHITE.length() + "\ncountOccurrences(\"" + string + "\", WHITE): " + countOccurrences(string,WHITE) + "\nRED.length(): " + RED.length() + "\ncountOccurrences(\"" + string + "\", RED): " + countOccurrences(string,RED));
		//length += BOLD.length()   * countOccurrences(string, BOLD); 
		length += RESET.length()  * countOccurrences(string, RESET); 
		length += WHITE.length()  * countOccurrences(string, WHITE); 
		length += RED.length()    * countOccurrences(string, RED); 
	   	length += BLUE.length()   * countOccurrences(string, BLUE); 	
	   	length += GREEN.length()  * countOccurrences(string, GREEN); 	
	   	length += YELLOW.length() * countOccurrences(string, YELLOW); 	
		return (string.length() - length); 
	}
	// not sure if necessary, check if can be deleted 
	public static String insertIcon(String string, int idx, String replacement) {
		String retString = ""; 
		retString = string.substring(0, idx) + replacement + string.substring(idx+2);
		return retString; 
	}
	// replace character at idx in given string. Returns the modified version of the provided string
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

	// refreshes the terminal by pushing the current page up and flushing
	public static void refresh(){
		System.out.print("\033[H\033[2J"); 
		System.out.flush(); 	
	}

	// pads a provided character with provided string from the left size as often as specified 
	public static String padLeft(String string, int padSize, char padWith){
		for (int i = 0; i<padSize; i++){
			string = padWith + string; 		
		}	
		return string; 
	}
	// pads a provided string with provided string from the left size as often as specified 
	public static String padLeft(String string, int padSize, String padWith){
		for (int i = 0; i<padSize; i++){
			string = padWith + string; 		
		}	
		return string; 
	}
	// same as padLeft from the right hand side	
	public static String padRight(String string, int padSize, char padWith){
		for (int i = 0; i<padSize; i++){
			string = string + padWith; 		
		}	
		return string; 
	}
	// same as padLeft from the right hand side	
	public static String padRight(String string, int padSize, String padWith){
		for (int i = 0; i<padSize; i++){
			string = string + padWith; 		
		}	
		return string; 
	}
}
