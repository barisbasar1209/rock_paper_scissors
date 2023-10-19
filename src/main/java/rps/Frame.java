package rps; 

public class Frame {
		
	public static String[][] frame = new String[37][185]; // creating a frame/board with 6845 characters and height 37 x width 185 which fits more my own monitor
	
	// clears the entire frame 
	public void clear(){
		frame = new String[37][185]; 	
	}
	// converts the two-dimensional char array frame to a string
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		for(String[] row : frame){
			for(String str : row){
				if (str == null) stringBuilder.append(" "); 
				else stringBuilder.append(str); 	
			}	
			stringBuilder.append('\n'); 
		}	
		return stringBuilder.toString(); 
	}
	// sets section vertically in the x-th column, beginning from y, to the provided string
	// throws exception if x,y are out of bounds. Does not continue to write in next column if too long for current, throws exception as well
	public void setSectionV (int x, int y, String setAs) throws Exception{
		checkIndicesInBound(x,y); 

		int len = setAs.length(); 
		if (y + len > 37){
			throw new Exception("Error: provided String is to long to be printed in the " + x + "-th column, beginning in the " + y + "-th row. Length is " + len); 
		}
		// fits completely in the x-th column 
		for (int i = 0; i<len; i++){
			if (setAs.charAt(i) == '\u001B'){
				String unicode = setAs.substring(i,i+5); 
			}
		}
	}
	/*
		 schreibe bis der string fertig geschrieben ist	
		 	Sei j der index des nächsten esc in string und k = 0
			solange k<j 
		   		hänge string[k] and frame[y][x] an und gehe zu x+1 und i+1 , setze isColor zu false
			angekommen bei j sei nun j der index des nächsten m
			falls m-i == 4 dann ist es ein reset sonst eine farbe, setze isColor entsprechend
			falls isColor dann schreibe substring von i bis m in frame[y][x] und gehe zu i+1
			sonst schreibe substring von i bis m in frame[y][x-1] und setze isColor auf false
	 */
	public void setSectionH(int xStart, int yStart, String string) throws Exception{
		checkIndicesInBound(xStart, yStart); 
		int x = xStart, y = yStart, i=0, j=0; 
		int len = string.length(); 
		int pureLen = Util.colorlessLength(string); 	
		while(i<len){
			// breaking line if string is too long
			if (x==185){
				x=0; y++; 
			}
			j = string.indexOf('\u001B',i); 
		   	if (j == -1){ // only colorless characters from here on
				while(i<len){
					frame[y][x] = "" + Character.toString(string.charAt(i)); 	
					x++; i++; 
				}	
				break; 
			}	
			else if (j-i>=5) { // erst kommen noch normale character 
				while(i<j){
					if (x==185) {
						x=0; y++; 	
					}
					if (frame[y][x] == null) frame[y][x] = Character.toString(string.charAt(i)); 
					else 					 frame[y][x] = frame[y][x] + Character.toString(string.charAt(i));
					x++; i++;  	
				}	
			}	
			else { // aktuelle position ist esc
				j = string.indexOf('m', i); 		
				if (j-i == 4){ // color
					String sub = string.substring(i,j+1); 
					frame[y][x] = sub; 
					i += 5; 
				}
				else if (j-i == 3){
					if (x==0) frame[y-1][184] = frame[y-1][184] +  Util.RESET; 	
					else 	  frame[y][x-1]   = frame[y][x-1]   + Util.RESET; 
					i += 4; 
				}
				else {
					System.out.println("Massive error , should not happen!!!"); 
					break; 
				}
			}
		}
	}
	// keeping this alternative version of the actual method setSectionH for debuggingpurposes 
	public void setSectionHDebugging(int xStart, int yStart, String string) throws Exception{
		int x = xStart, y = yStart, i=0, j=0; 
		int len = string.length(); 
		int pureLen = Util.colorlessLength(string); 	
		if (pureLen+x <= 185){
			while(i<len){
				j = string.indexOf('\u001B',i); 
				/*if (j == -1) {
					System.out.println("j == -1 while searching for ESC"); 
					Thread.sleep(2500); 	
				}*/
				/*System.out.println("j: " + j); 
				System.out.println("i: " + i); 
				System.out.println("x: " + x); 
				Thread.sleep(1000);*/
			   	if (j == -1){ // only colorless characters from here on
					while(i<len){
						frame[y][x] = "" + Character.toString(string.charAt(i)); 	
						x++; i++; 
					}	
					break; 
				}	
				else if (j-i>=5) { // erst kommen noch normale character 
					while(i<j){
						//System.out.println("writing series of characters");
						//System.out.println("x: " + x); 
						//Thread.sleep(1000); 
						if (frame[y][x] == null) {
							//System.out.println("assigning"); 
							frame[y][x] = Character.toString(string.charAt(i)); 
						}
						else {
							//System.out.println("appending");
							frame[y][x] = frame[y][x] + Character.toString(string.charAt(i));
						}
						x++; i++;  	
					}	
					//System.out.println("Wrote all characters. i: " + i + " x: " + x); 
				}	
				else { // aktuelle position ist esc
					//System.out.println("found esc"); 
					j = string.indexOf('m', i); 		
					/*if (j == -1) {
						System.out.println("j == -1 while searching for m"); 
						Thread.sleep(2500); 	
					}*/
					//System.out.println("j: " + j); 
					//System.out.println("i: " + i); 
					//Thread.sleep(5000); 
					if (j-i == 4){ // color
						//System.out.println("found color"); 
						String sub = string.substring(i,j+1); 
						//Util.printRaw(sub); 
						//Thread.sleep(5000); 
						/*switch(sub){ 
							case Util.RED: 
								System.out.println("color is RED"); 
								frame[y][x] = "R"; 
								break;
							case Util.GREEN: 
								System.out.println("color is GREEN"); 
								frame[y][x] = "G"; 
								break;
							case Util.YELLOW: 
								System.out.println("color is YELLOW"); 
								frame[y][x] = "Y"; 
								break;
							case Util.BLUE: 
								System.out.println("color is BLUE"); 
								frame[y][x] = "B"; 
								break;
							default: 
								System.out.println("none of the specified colors. Should not happen!"); 
								break; 
						}*/
						frame[y][x] = sub; 
						i += 5; 
					}
					else if (j-i == 3){
						//System.out.println("found reset"); 
						if (x==0) frame[y-1][184] = frame[y-1][184] +  Util.RESET; 	
						else frame[y][x-1] = frame[y][x-1] + Util.RESET; 
						i += 4; 
					}
					else {
						System.out.println("Massive error , should not happen!!!"); 
						break; 
					}
				}
			}
		}
	}
	/*	solange noch nicht der ganze string gelesen wurde
	   	falls x > 184 dann setze x = 0 und y++
		falls anzahl an character + x <= 185 (dann passt der string noch in diese eine zeile ohne umbruch)
			falls string.charAt(i) == esc
				falls i+5<len dann sei sub = string.substring(i,i+5)
					falls sub == farbe dann schreibe sub in frame[y][x] und string.charAt(i+5), gehe zu x+1 und i+5
					andernfalls schreibe sub in frame[y][x-1] falls x>0 , sonst in frame[y-1][184], gehe zu x und i+4
				falls len-i == 4 und sub == reset dann schreibe reset in frame[y][x-1] / frame[y-1][184] und gehe zu x und i+4 
				andernfalls len-i < 4 dann solange string ende schreibe string.charAt(i) in frame[y][x] und gehe zu x+1, i+1
			andernfalls schreibe string.charAt(i) in frame[y][x] und gehe zu x+1, i+1
	 */
	public void setSectionHH(int xStart, int yStart, String string) throws Exception{
		checkIndicesInBound(xStart,yStart); 

		int x = xStart, y = yStart, i = 0; 
		int len = string.length();
		int pureLength = Util.colorlessLength(string); 
		//System.out.println(pureLength); 
		//System.out.println(len); 
		if (pureLength+x <= 185){
			System.out.println("fits in one line"); 
			while(i < len){
				if (x>184) {
					x = 0; 
					y++; 	
				}
				//System.out.println("i: " + i); 
				//Thread.sleep(1000); 
				char c = string.charAt(i); 
				if (c == '\u001B'){
					//System.out.println("found esc"); 
					//Thread.sleep(1000); 
					if(i+5<len){
						//System.out.println("not at the end of the string"); 
						//Thread.sleep(1000); 
						String sub = string.substring(i,i+5); 
						if (sub.equals(Util.RED) || sub.equals(Util.GREEN) || sub.equals(Util.YELLOW) || sub.equals(Util.BLUE)){
							//System.out.println("it is a color"); 
							//Thread.sleep(1000); 
							StringBuilder sb = new StringBuilder(); 
							sb.append(sub); 
							sb.append(Character.toString(string.charAt(i+1))); 
							frame[y][x] = sb.toString(); 
							x++; 
							i += 6;  
						}  
						else{
							//System.out.println("it is a reset"); 
							//Thread.sleep(1000); 
							if (x>0) frame[y][x-1]   += ""+sub; 
							else 	 frame[y-1][184] += ""+sub;
						   	i += 4; 	
						}
					}	
					else if (i+4 == len && string.substring(i,i+4).equals(Util.RESET)){
						System.out.println("it is a reset at the end of the string"); 
						String sub = string.substring(i,i+4); 
						if(x>0) frame[y][x-1]   += ""+sub; 
						else 	frame[y-1][184] += ""+sub; 	
						i += 4; 
					}		
					else{
						System.out.println("it is a regular character. should never occur"); 
						while(i<len){
							frame[y][x] = Character.toString(string.charAt(i)); 
							i++; 
							x++; 	
						}	
					} 
				}
				else{
					System.out.println("it is a regular character"); 
					frame[y][x] = Character.toString(string.charAt(i)); 	
					i++; 
					x++; 
				}
			}	
		} 
		else System.out.println("has to be created"); 

	}
	public void setArray(int x, int y, String[][] array) throws Exception{
		checkIndicesInBound(x,y); 
			
		for (int i = y; i<array.length; i++){
			for (int j = x; j<array[i].length; j++){
				frame[i][j] = array[i][j]; 
			}	
		}	
	}
	// sets a big string I constructed with the hashtag symbol in the frame line by line
	public void setBigString(int x, int y, String setAs) throws Exception{
		String[] lines = setAs.split("\n"); 
		/*for(int i = 0; i<lines.length; i++){
			setSectionH(x,y+i,lines[i]); 
		}	*/
		setSectionH(x,y,lines[0]);
	}
	private static void checkIndicesInBound(int x, int y) throws Exception{
		if (y>=37 || y<0) {
			throw new Exception("Error: y is out of bounds in \"setSection\". y = " + y);  
		}
		if (x>=185 || x<0) {
			throw new Exception("Error: x is out of bounds in \"setSection\". x = " + x); 
		}
	}
}
