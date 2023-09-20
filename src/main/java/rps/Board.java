package rps; 
import java.util.ArrayList; 
import java.util.Random; 

public class Board {
	
	/*final static String reset = "\u001B[0m"; 	
	final static String red = "\u001B[31m"; 
	final static String green = "\u001B[32m"; 
	final static String yellow = "\u001B[33m"; */
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
	// TODO: remove player that has been defeated from board 
	private static char resolveDuell(char next, char current){
		if(next == current || current == FILLER) return next; 
		if(next == 'r' && current == 'p') return 'p'; 
		if(next == 'r' && current == 's') return 'r'; 
		if(next == 'p' && current == 'r') return 'p'; 
		if(next == 'p' && current == 's') return 's'; 
		if(next == 's' && current == 'p') return 's'; 
		if(next == 's' && current == 'r') return 'r'; 
		System.out.println("Error: Duell could not be resolved properly! next is " + next + " current is " + current + "."); 
		System.exit(1); 
		return 'x'; 
	}
	private static void printBoard(){
			String line = ""; 
			String paddedLine = Util.padLeft(line, WIDTH, FILLER); 
			line = paddedLine; 
			char next; 
			for(int i=0; i<HEIGHT; i++){
				for(Rock rock : rockList){
					if (rock.getY() == i){
						next = resolveDuell(rock.getIcon(), line.charAt(rock.getX())); 
						//line = Util.insertIcon(line, rock.getX(), green + next + reset); 		
						line = Util.replaceIdx(line, rock.getX(), next); 		
					}	
				}	
				for(Paper paper : paperList){
					if (paper.getY() == i){
						next = resolveDuell(paper.getIcon(), line.charAt(paper.getX())); 
						//line = Util.insertIcon(line, paper.getX(), yellow + next + reset); 	
						line = Util.replaceIdx(line, paper.getX(), next); 	
					}	
				}
				for(Scissors scissors : scissorsList){
					if (scissors.getY() == i){
						next = resolveDuell(scissors.getIcon(), line.charAt(scissors.getX())); 
						//line = Util.insertIcon(line, scissors.getX(), red + next + reset); 	
						line = Util.replaceIdx(line, scissors.getX(), next); 	
					}	
				}
				System.out.println(line); 
				line = paddedLine; 
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
				Thread.sleep(1000); 
				Util.refresh(); 
			}
	}

}
