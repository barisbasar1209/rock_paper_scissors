package rps; 

public class Frame {
		
	public static String[][] frame = new String[37][220]; // creating a frame/board with 6845 characters and height 37 x width 185 which fits more my own monitor
	
	// clears the entire frame 
	public void clear(){
		frame = new String[37][220]; 	
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
	public void setSectionH (int x, int y, String string) throws Exception{
		
		checkIndicesInBound(x,y); 
		System.out.println("length: " + string.length() +"\npure length: " + Util.colorlessLength(string));
		String[] lines = string.split("\n"); 

		for (int i = 0; i<lines.length; i++){
			String[] columns = Util.splitWithDelimiter(lines[i], "[# ]");
			int k = 0; 
			for (String str : columns){
				if (str.equals(" ")) System.out.println("empty"); 
				else if (str.equals(Util.RED + " ")) System.out.println("red empty"); 
				else if (str.equals(Util.GREEN + " ")) System.out.println("green empty"); 
				else if (str.equals(Util.YELLOW + " ")) System.out.println("yellow empty"); 
				else if (str.equals(" " + Util.RESET)) System.out.println("empty reset"); 
				else if (str.equals("#")) System.out.println("white #"); 
				else if (str.equals(Util.RED + "#")) System.out.println("red #"); 
				else if (str.equals(Util.GREEN + "#")) System.out.println("green #"); 
				else if (str.equals(Util.YELLOW + "#")) System.out.println("yellow #"); 
				else if (str.equals("#" + Util.RESET)) System.out.println("# reset"); 
				System.out.println(++k);
				Thread.sleep(1000); 
			} 
			for(int j = 0; j<columns.length; j++){
				frame[i][j] = columns[j];	
			}
		}
	} 
	public void setSectionX (int x, int y, String setAs) throws Exception{
		checkIndicesInBound(x,y); 

		// repeting code in the control flow , need to fix that but later not now 
		int pureLen = Util.colorlessLength(setAs); ; 
		int len = setAs.length(); 
		System.out.println("purelen: "+pureLen+" len: "+len);
		if (x + pureLen <= 185){ // fits completely into one y-th line 
			for (int column = 0, crrChar = 0; crrChar<len; crrChar++){

				if (column == 185){
					System.out.println("column == 185 already!!!\ncurrently written: "+ toString());	
					Thread.sleep(2000); 
					crrChar=len; 
					continue;
				}
				// check whether or not I hit a unicode
				if (setAs.charAt(crrChar) == '\u001B'){

					System.out.println("Charracter at crrChar = "+crrChar+ " is a unicodeindicator");
					System.out.println("column: "+column+" crrChar: "+crrChar);
					Thread.sleep(2000);
					// with the last RESET i+5 is out of bounds so I need to catch it
					if (crrChar+5>=len) {
						if (frame[y][column-1] == null) frame[y][column-1] = "" + frame[y][column-1] + Util.RESET; 
						else frame[y][column-1] += Util.RESET; 
						crrChar+=3; 	
					}
					else{
						String unicode = setAs.substring(crrChar, crrChar+4); 
						if (unicode == Util.RESET) { 
							System.out.println("The unicode is a reset"); 
							Thread.sleep(2000);
							frame[y][column-1] = "" + frame[y][column-1] + Util.RESET; 	
							crrChar += 3; 
						}	
						// one of the colors, they are all 5 characters long
						else { 				
							System.out.println("The unicode is a color of length: " + unicode.length());
							Thread.sleep(2000);
							unicode = setAs.substring(crrChar, crrChar+5); 
							crrChar += 4; 
							frame[y][column] = unicode + Character.toString(setAs.charAt(crrChar)); 
							column++; 
						}	
					}
				}
				// if not a unicode just write character as string in the position and move to next column
				else {
					System.out.println("the character is not a unicode but a normal character: " + Character.toString(setAs.charAt(crrChar)));
					System.out.println("column: "+column+" crrChar: "+crrChar);
					frame[y][column] = Character.toString(setAs.charAt(crrChar)); 	
					column++; 
				}
			}
		}
		else{ // has to be continued in next line
			System.out.println("ERROR: ELSE CASE ENTERED"); 	
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
