package rps; 
import java.util.ArrayList; 
import java.util.Random; 

public class Board {
	
	final static String RESET = "\u001B[0m"; 	
	final static String WHITE = "\u001B[97m"; 
	final static String RED = "\u001B[91m"; 
	final static String GREEN = "\u001B[92m"; 
	final static String YELLOW = "\u001B[93m";
	private final static char FILLER = '.'; 
	private final static int HEIGHT = 20; 
	private final static int WIDTH = 50; 
	private final static int PLAYERAMOUNT = 30; 	
	static Random random = new Random(); 
	static public ArrayList<Rock> rockList = new ArrayList<>(); 	
	static public ArrayList<Paper> paperList = new ArrayList<>(); 	
	static public ArrayList<Scissors> scissorsList = new ArrayList<>(); 	
	static private Player[][] BOARD;  

	private static void createPlayers() throws Exception{
			int rand; 
			int x; 
			int y;
		    int direction; 	
			for(int i = 0; i<PLAYERAMOUNT; i++){	
					rand = random.nextInt(3);	
					x = random.nextInt(WIDTH); 
					y = random.nextInt(HEIGHT); 	
					if (x==WIDTH || y==HEIGHT) {
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
		BOARD = new Player[HEIGHT][WIDTH]; 	
		int x; 
		// rendering the board row by row while also resolving occuring duells
		for (int y = 0; y<HEIGHT; y++){
			for (Rock rock : rockList){
				if (rock.getY() == y){
					x = rock.getX(); 
					// if there is already a player on that spot they have to duell else just set player on that spot
					if (BOARD[y][x] instanceof Player){
						Player player = BOARD[y][x]; 
						resolveDuell(player, rock); 
					}
					else {
						BOARD[y][x] = rock; 
					}
				}	
			}
			for (Paper paper : paperList){
				if (paper.getY() == y){
					x = paper.getX(); 
					if (BOARD[y][x] instanceof Player){
						Player player = BOARD[y][x]; 
						resolveDuell(player, paper); 
					}
					else {
						BOARD[y][x] = paper; 
					}
				}	
			}
			for (Scissors scissors : scissorsList){
				if (scissors.getY() == y){
					x = scissors.getX(); 
					if (BOARD[y][x] instanceof Player){
						Player player = BOARD[y][x]; 
						resolveDuell(player, scissors); 
					}
					else {
						BOARD[y][x] = scissors; 
					}
				}	
			}
		}
	}
	private static void resolveDuell(Player p1, Player p2){
			char icon1 = p1.getIcon(); 
			char icon2 = p2.getIcon(); 

			if (icon1 == 'r'){
				if (icon2 == 'p') p1.setIcon(icon2); 	
				else if (icon2 == 's') p2.setIcon(icon1); 
			}
			else if (icon1 == 'p'){
				if (icon2 == 'r') p2.setIcon(icon1); 
				else if (icon2 == 's') p1.setIcon(icon2); 	
			}
			else if (icon1 == 's'){
				if (icon2 == 'r') p1.setIcon(icon2); 	
				else if (icon2 == 'p') p2.setIcon(icon1); 
			}
	}
	private static void printBoard(){
			String line = ""; 
			String paddedLine = Util.padLeft(line, WIDTH, FILLER);
			line = paddedLine; 
			char next; 

			System.out.println("\n\n\n\n\n"); 
			for (int y = 0; y < HEIGHT; y++){
				for (int x = 0; x < WIDTH; x++){
						if (BOARD[y][x] instanceof Player) {
								Player player = BOARD[y][x];  
								char icon = player.getIcon(); 
								line = Util.replaceIdx(line, player.getX(), icon); 	
						}		
				}	
				line = colorizeLine(line); 
				line = Util.padLeft(line, 50, ' '); 
				System.out.println(line); 
				line = paddedLine; 
			}
	}
	private static String colorizeLine(String line){
			StringBuilder colorizedLine = new StringBuilder(); 
			
			for (char character : line.toCharArray()) {
				switch(character){
					case FILLER: 
						colorizedLine.append(WHITE); 
						break; 
					case 'r': 
						colorizedLine.append(RED); 
						break; 
					case 'p': 
						colorizedLine.append(GREEN);
						break; 
					case 's': 
						colorizedLine.append(YELLOW); 
						break; 
					default: 
						colorizedLine.append(character); 
				}	
				colorizedLine.append(character).append(RESET); 
			}
			return colorizedLine.toString(); 
	}
	private static void movePlayers(){
		// width and height have to be decremented for the move method to work 
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
				renderBoard(); 
				printBoard();
				Thread.sleep(200); 
				Util.refresh(); 
			}
	}

}
