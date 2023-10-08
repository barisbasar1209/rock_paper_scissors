package rps; 

import java.util.Random; 

public class Util {
		
	final static String RESET = "\u001B[0m"; 	
	final static String WHITE = "\u001B[97m"; 
	final static String RED = "\u001B[91m"; 
	final static String GREEN = "\u001B[92m"; 
	final static String YELLOW = "\u001B[93m";
	
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
	
	final static String[][] R = {whiteR, redR, yellowR, greenR};
	final static String[][] O = {whiteO, redO, yellowO, greenO};
	final static String[][] C = {whiteC, redC, yellowC, greenC};
	final static String[][] K = {whiteK, redK, yellowK, greenK};
	final static String[][] P = {whiteP, redP, yellowP, greenP};
	final static String[][] A = {whiteA, redA, yellowA, greenA};
	final static String[][] E = {whiteE, redE, yellowE, greenE};
	final static String[][] S = {whiteS, redS, yellowS, greenS};
	final static String[][] I = {whiteI, redI, yellowI, greenI};
	
	final static int LETTERHEIGHT = 8; 
	final static int BANNERLENGTH = 17; 
	static Random random = new Random(); 

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
