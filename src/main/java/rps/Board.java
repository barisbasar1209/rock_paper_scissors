package rps; 

public class Board {
	

	final static int HEIGHT = 20; 
	final static int WIDTH = 50; 
	
	int cntPlayers; 

	static char[][] board = new char[HEIGHT][WIDTH]; 
	
	public static void print_board(){
			for(int i=0; i<HEIGHT; i++){
				for (int j=0; j<WIDTH; j++){
						System.out.print(board[i][j]);
				}	
				System.out.printf("\n"); 
			}
			
	}	

}
