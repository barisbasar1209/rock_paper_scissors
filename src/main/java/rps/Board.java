package rps; 
import java.util.ArrayList; 
import java.util.Random; 

public class Board {
	

	private final static int HEIGHT = 20; 
	private final static int WIDTH = 50; 
	private final static int PLAYERAMOUNT = 10; 	
	public int cntPlayers; 
	static Random random = new Random(); 
	static char[][] board = new char[HEIGHT][WIDTH]; 
	static public ArrayList<Rock> rockList = new ArrayList<>(); 	
	static public ArrayList<Paper> paperList = new ArrayList<>(); 	
	static public ArrayList<Scissors> scissorsList = new ArrayList<>(); 	


	private static void createPlayers(){
			int rand; 
			int x; 
			int y;
		    int direction; 	
			for(int i = 0; i<PLAYERAMOUNT; i++){	
					rand = random.nextInt(3);	
					x = random.nextInt(50); 
					y = random.nextInt(20); 	
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
	private static void printBoard(){
			String line = ""; 
			line = Util.padLeft(line, 50); 
			for(int i=0; i<HEIGHT; i++){
				for(Rock rock : rockList){
					if (rock.getY() == i){
						line = Util.replaceIdx(line, rock.getX(), rock.getIcon()); 		
					}	
				}	
				for(Paper paper : paperList){
					if (paper.getY() == i){
						line = Util.replaceIdx(line, paper.getX(), paper.getIcon()); 	
					}	
				}
				for(Scissors scissors : scissorsList){
					if (scissors.getY() == i){
						line = Util.replaceIdx(line, scissors.getX(), scissors.getIcon()); 	
					}	
				}
				System.out.println(line); 
			}
			
	}
	private static void movePlayers(){
		for (Rock rock : rockList){
			rock.move(WIDTH, HEIGHT); 
		}	
		for (Paper paper : paperList){
			paper.move(WIDTH, HEIGHT); 	
		}
		for (Scissors scissors : scissorsList){
			scissors.move(WIDTH, HEIGHT); 	
		}
	}	
	public void runGame() throws Exception{
			createPlayers(); 
			Util.refresh(); 
			while(!((rockList.size()+paperList.size() == 0) || (rockList.size()+scissorsList.size() == 0) || (paperList.size()+scissorsList.size() == 0))){
				movePlayers(); 
				printBoard();
				Thread.sleep(750); 
				Util.refresh(); 
			}
	}

}
