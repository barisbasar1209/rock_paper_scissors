package rps; 

public class Frame {
		
	private static char[][] frame = new char[37][185]; // creating a frame/board with 6845 characters and height 37 x width 185 which fits more my own monitor
	
	// clears the entire frame 
	public void clear(){
		frame = new char[37][185]; 	
	}
	// converts the two-dimensional char array frame to a string
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		for(char[] row : frame){
			for(char c : row){
				if (c == Util.NULLCHAR) stringBuilder.append(' '); 
				else stringBuilder.append(c); 	
			}	
			stringBuilder.append('\n'); 
		}	
		return stringBuilder.toString(); 
	}
	// sets the specified position in the frame as the provided character making it possible to manipulate positions on the frame sperately
	public void setPosition(int x, int y, char setAs) throws Exception{
		if (y>=37 || y<0) {
			throw new Exception("Error: y is out of bounds in \"setPosition\". y = " + y);  
		}
		if (x>=185 || x<0) {
			throw new Exception("Error: x is out of bounds in \"setPosition\". x = " + x); 
		}
		frame[y][x] = setAs; 	
	}
	// sets section vertically in the x-th column, beginning from y, to the provided string
	// throws exception if x,y are out of bounds. Does not continue to write in next column if too long for current, throws exception as well
	public void setSectionV (int x, int y, String setAs) throws Exception{
		if (y>=37 || y<0) {
			throw new Exception("Error: y is out of bounds in \"setSection\". y = " + y);  
		}
		if (x>=185 || x<0) {
			throw new Exception("Error: x is out of bounds in \"setSection\". x = " + x); 
		}

		int len = setAs.length(); 
		if (y + len > 37){
			throw new Exception("Error: provided String is to long to be printed in the " + x + "-th column, beginning in the " + y + "-th row. Length is " + len); 
		}
		// fits completely in the x-th column 
		for (int i = 0; i<len; i++){
			setPosition(x, y+i, setAs.charAt(i)); 	
		}
	}
	// sets section horizontally in the y-th row, beginning from x, to the provided string. 
	// Throws exception if x, y are out of bounds. Continous to write in next line if too long for current  
	public void setSectionH (int x, int y, String setAs) throws Exception{
		if (y>=37 || y<0) {
			throw new Exception("Error: y is out of bounds in \"setSection\". y = " + y);  
		}
		if (x>=185 || x<0) {
			throw new Exception("Error: x is out of bounds in \"setSection\". x = " + x); 
		}

		int len = setAs.length(); 
		if (x + len <= 185){ // fits completely into one y-th line 
			for (int i = 0; i<len; i++){
				setPosition(x+i, y, setAs.charAt(i));	
			}
		}
		else{ // has to be continued in next line

			// for looping through the frames positions
			int column = x; 
			int row = y; 	 
			// the current character of setAs that is being written 
			int crrChar = 0; 
			// as long as the string hasnt been fully written continue to write
			while(crrChar < len) { 
				// write the next character and move to the next
				setPosition(column, row, setAs.charAt(crrChar)); 
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
		for(int i = 0; i<lines.length; i++){
			setSectionH(x,y+i,lines[i]); 
		}	
	}
}
