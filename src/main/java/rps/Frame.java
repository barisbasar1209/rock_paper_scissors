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
	public void setSectionY (int x, int y, String string) throws Exception{
		
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
	public void setSectionH(int xStart, int yStart, String string) throws Exception{
		checkIndicesInBound(xStart,yStart); 

		int x = xStart, y = yStart, i = 0; 
		int len = string.length();
		int pureLength = Util.colorlessLength(string); 
		System.out.println(pureLength); 
		System.out.println(len); 
		if (pureLength+x <= 185){
			System.out.println("fits in one line"); 
			while(i < len){
				if (x>184) {
					x = 0; 
					y++; 	
				}
				System.out.println("i: " + i); 
				Thread.sleep(1000); 
				char c = string.charAt(i); 
				if (c == '\u001B'){
					System.out.println("found esc"); 
					Thread.sleep(1000); 
					if(i+5<len){
						System.out.println("not at the end of the string"); 
						Thread.sleep(1000); 
						String sub = string.substring(i,i+5); 
						if (sub.equals(Util.RED) || sub.equals(Util.GREEN) || sub.equals(Util.YELLOW) || sub.equals(Util.BLUE)){
							System.out.println("it is a color"); 
							Thread.sleep(1000); 
							StringBuilder sb = new StringBuilder(); 
							sb.append(sub); 
							sb.append(Character.toString(string.charAt(i+1))); 
							frame[y][x] = sb.toString(); 
							x++; 
							i += 6;  
						}  
						else{
							System.out.println("it is a reset"); 
							Thread.sleep(1000); 
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
