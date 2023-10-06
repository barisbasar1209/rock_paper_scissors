package rps; 
import java.util.ArrayList; 
import java.util.Random; 

public class Board {
	
	final static String reset = "\u001B[0m"; 	
	final static String red = "\u001B[31m"; 
	final static String green = "\u001B[32m"; 
	final static String yellow = "\u001B[33m";
	private final static char FILLER = '.'; 
	private final static int HEIGHT = 20; 
	private final static int WIDTH = 50; 
	private final static int PLAYERAMOUNT = 10; 	
	static Random random = new Random(); 
	static public ArrayList<Rock> rockList = new ArrayList<>(); 	
	static public ArrayList<Paper> paperList = new ArrayList<>(); 	
	static public ArrayList<Scissors> scissorsList = new ArrayList<>(); 	
	private static void createPlayers() throws Exception{
			int rand; 
			int x; 
			int y;
		    int direction; 	
			for(int i = 0; i<PLAYERAMOUNT; i++){	
					rand = random.nextInt(3);	
					x = random.nextInt(WIDTH); 
					y = random.nextInt(HEIGHT); 	
					if (x==WIDTH|| y==HEIGHT) {
						System.out.println("Random generated x==50 or y==20!!!"); 
						Thread.sleep(2000); 
						System.exit(1); 
					}

					direction = random.nextInt(8) + 1; 
					if (rand==0){ // rock
						rockList.add(new Rock(x,y,direction)); 
					} 
					else if (rand==1){ // paper 
						paperList.add(new Paper(x,y,direction));
					} 
					else if (rand==2){ // scissors
						scissorsList.add(new Scissors(x,y,direction)); 
					}
			}
	} 
	private static void renderBoard(){
		Player[][] board = new Player[HEIGHT][WIDTH]; 	
		int x; 
		// rendering the board row by row while also resolving occuring duells
		for (int y = 0; y<HEIGHT; y++){
			for (Rock rock : rockList){
				if (rock.getY() == y){
					x = rock.getX(); 
					board[y][x] = rock; 
				}	
			}
			for (Paper paper : paperList){
				if (paper.getY() == y){
					x = paper.getX(); 
					board[y][x] = paper; 	
				}	
			}
			for (Scissors scissors : scissorsList){
				if (scissors.getY() == y){
					x = scissors.getX(); 
					board[y][x] = scissors; 	
				}	
			}
		}
	}
	private static void movePlayers(){
		// width and height have do be decremented for the move method to work 
		for (Rock rock : rockList){
			rock.move(WIDTH-1, HEIGHT-1); 
		}	
		for (Paper paper : paperList){
			paper.move(WIDTH-1, HEIGHT-1); 	
		}
		for (Scissors scissors : scissorsList){
			scissors.move(WIDTH-1, HEIGHT-1); 	
		}
	}	
	public void runGame() throws Exception{
			createPlayers(); 
			Util.refresh(); 
			
			while(!((rockList.size()+paperList.size() == 0) || (rockList.size()+scissorsList.size() == 0) || (paperList.size()+scissorsList.size() == 0))){
				movePlayers(); 
				printBoard();
				Thread.sleep(150); 
				Util.refresh(); 
			}
	}

}
