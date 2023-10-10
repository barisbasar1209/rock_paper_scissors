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
				//if (	
			}
			//setPosition(x, y+i, setAs.charAt(i)); 	
		}
	}
	// sets section horizontally in the y-th row, beginning from x, to the provided string. 
	// Throws exception if x, y are out of bounds. Continous to write in next line if too long for current  
	public void setSectionH (int x, int y, String setAs) throws Exception{
		checkIndicesInBound(x,y); 

		// repeting code in the control flow , need to fix that but later not now 
		int pureLen = Util.colorlessLength(setAs); ; 
		int len = setAs.length(); 
		System.out.println("pureLen: " + pureLen + "\nlen: " + len); 
		if (x + pureLen <= 185){ // fits completely into one y-th line 
			System.out.println("Entering if case"); 
			for (int column = 0, crrChar = 0; crrChar<len; crrChar++){
				// check whether or not I hit a unicode
				if (setAs.charAt(crrChar) == '\u001B'){
					// with the last RESET i+5 is out of bounds so I need to catch it
					if (crrChar+5>=len) {
						frame[y][column-1] = "" + frame[y][column-1] + "" + Util.RESET; 
						crrChar+=4; 	
					}
					else{
						String unicode = setAs.substring(crrChar, crrChar+4); 
						if (unicode == Util.RESET) { 
							// if I hit a RESET then I know that there has to be a character before that already being written in the frame at index i-1 so I append RESET in that
							frame[y][column-1] = "" + frame[y][column-1] + Util.RESET; 	
							// unsure whether I would also cover the very last reset in a string
							crrChar += 4; 
						}	
						// one of the colors, they are all 5 characters long
						else { 				
							unicode += setAs.charAt(crrChar+5); 
							crrChar += 5; 
							frame[y][column] = unicode + setAs.charAt(++crrChar); 
							System.out.println("found color code. Writing: " + setAs.charAt(crrChar));
							column++; 
						}	
					}
				}
				// if not a unicode just write character as string in the position and move to next column
				else {
					frame[y][column] = Character.toString(setAs.charAt(crrChar)); 	
					column++; 
				}
			}
			System.out.println("Loop exited successfully in if case"); 
		}
		else{ // has to be continued in next line
			
			// same true here, repeting code, bad style, need to fix it later on
			// for looping through the frames positions
			int column = x; 
			int row = y; 	 
			// the current character of setAs that is being written 
			int crrChar = 0; 
			// as long as the string hasnt been fully written continue to write
			while(crrChar < len) { 
				// write the next character and move to the next
				char c = setAs.charAt(crrChar);
				if (c == '\u001B'){
					if (crrChar+5 >= len){
						if (column == 0){
							frame[row-1][184] += Util.RESET; 	
						}	
						else {
							frame[row][column-1] += Util.RESET; 	
						}
						crrChar += 4; 
					}
					else{
						String unicode = setAs.substring(crrChar, crrChar+5); 
						if (unicode == Util.RESET){
							if (column == 0){
								frame[row-1][184] += Util.RESET; 	
							}	
							else {
								frame[row][column-1] += Util.RESET; 	
							}
							crrChar += 4; 
						}
						else {
							frame[row][column] = unicode + setAs.charAt(crrChar+5); 
							crrChar += 5; 
						}
					}
				}
				else {
					frame[row][column] = Character.toString(c); 	
				}
				crrChar++; 
				column++; 
				if (column == 185){ // if the end of the line has been reached proceed with the next line top down and start again from the left
					column = 0; 
					row++; 
				}
			}
		}
	}
	// sets a big string I constructed with the hashtag symbol in the frame line by line
	public void setBigString(int x, int y, String setAs) throws Exception{
		String[] lines = setAs.split("\n"); 
		System.out.println("lines.length: " + lines.length); 
		System.out.println("setBigString(" + x + ", " + y + ", banner)"); 
		Thread.sleep(2500); 
		for(int i = 0; i<lines.length; i++){
			System.out.println("i: " + i); 
			setSectionH(x,y+i,lines[i]); 
		}	
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
