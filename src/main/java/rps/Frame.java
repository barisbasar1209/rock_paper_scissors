package rps; 

import java.util.StringBuilder; 

public class Frame {
	
	private static char[][] frame = new char[37][185]; // creating a frame/board with 6845 characters and height 37 x width 185 which fits more my own monitor
	
	// clears the entire frame 
	public void clearFrame(){
		frame = new char[37][185]; 	
	}
	// converts the two-dimensional char array frame to a string
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		
		for(char[] row : frame){
			for(char c : row){
				stringBuilder.append(c); 	
			}	
			stringBuilder.append('\n'); 
		}	
		return stringBuilder.toString(); 
	}
	// sets the specified position in the frame as the provided character making it possible to manipulate positions on the frame sperately
	public void setPosition(int x, int y, char setAs) throws Exception{
		if (x>36 || x<0) {
			throw new Exception("Error: x is out of bounds in \"setPosition\". x = " + x);  
			System.exit(1); 
		}
		if (y>184 || y<0) {
			throw new Excpetion("Error: y is out of bounds in \"setPosition\". y = " + y); 
			System.exit(1); 
		}
		frame[y][x] = setAs; 	
	}
	// sets section in the y-th row beginning from x to the provided string. Throws exception if x, y are out of bounds. Continous to write in next line if to long for current  
	public void setSection(int x, int y, String setAs) throws Exception{
		if (x>36 || x<0) {
			throw new Exception("Error: x is out of bounds in \"setSection\". x = " + x);  
			System.exit(1); 
		}
		if (y>184 || y<0) {
			throw new Exception("Error: y is out of bounds in \"setSection\". y = " + y); 
			System.exit(1); 
		}
		int len = setAs.length(); 
		if (x + len < 185){ // fits completely into one y-th line 
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
				setPosition(column, row, setAs.charAt(crrChar); 
				crrChar++; 
				if (column == 185){ // if the end of the line has been reached proceed with the next line top down and start again from the left
					column = 0; 
					row++; 
				}
			}
		}
	}
}
