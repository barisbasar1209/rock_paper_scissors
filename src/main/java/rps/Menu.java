package rps; 
import java.util.Scanner; 

public class Menu {
	
	final static int SHOOT = 0; 
	final static int CONFIG = 1; 
	final static int EXIT = 2; 

	// writing the characters as arrays of strings were each entry is one line. Then constructing each character. Whenever I want to 
	// append two characters I just append their respective lines
	final static String whiteShoot  = generateWhiteShoot(); 	
	final static String whiteConfig = generateWhiteConfig(); 
	final static String whiteExit   = generateWhiteExit(); 
	final static String blueShoot   = generateBlueShoot(); 
	final static String blueConfig  = generateBlueConfig(); 
	final static String blueExit    = generateBlueExit(); 
	
	static char[][] frame = new char[37][185]; // making it 6845 characters 37 high x 185 wide

	public static void main (String[] args) throws Exception{
			String frame = Util.padLeft("", 6845, "#"); 
			System.out.println(frame); 
	}	
	public static void printMenu(){	
		int selection = SHOOT; 	
		String banner = ""; 
		String input = ""; 
		Scanner scanner = new Scanner(System.in); 

		while(true){
			Util.refresh(); 
			banner = generateBanner(); 
			System.out.println(banner); 

			if (selection == SHOOT){
				System.out.println(blueShoot); 
				System.out.println(whiteConfig); 
				System.out.println(whiteExit); 	
			}	
			else if (selection == CONFIG){
				System.out.println(whiteShoot); 
				System.out.println(blueConfig); 
				System.out.println(whiteExit); 	
			}
			else {
				System.out.println(whiteShoot); 
				System.out.println(whiteConfig); 
				System.out.println(blueExit); 	
			}
			System.out.println("Hit enter to toggle around"); 
			input = scanner.nextLine(); 

			selection = (selection+1)%3; 

			//Thread.sleep(2000); 
		}	
	}

	private static void animateBanner() throws InterruptedException{
		String banner = ""; 
		while(true){
			Util.refresh(); 
			banner = generateBanner();
			System.out.println(banner); 
			Thread.sleep(2000); 	
		}
	}
	private static String generateWhiteShoot(){
		String shoot = ""; 
		for (int line = 0; line < Util.SMALLLETTERHEIGHT; line++){
			shoot += Util.smallWhiteS[line] + Util.smallWhiteH[line] + Util.smallWhiteO[line] + Util.smallWhiteO[line] + Util.smallWhiteT[line] + "\n"; 
		}
		return shoot; 	
	}
	private static String generateBlueShoot(){
		String shoot = ""; 
		for (int line = 0; line < Util.SMALLLETTERHEIGHT; line++){
			shoot += Util.smallBlueS[line] + Util.smallBlueH[line] + Util.smallBlueO[line] + Util.smallBlueO[line] + Util.smallBlueT[line] + "\n"; 
		}
		return shoot; 	
	}
	private static String generateWhiteConfig(){
		String config = ""; 
		for (int line = 0; line < Util.SMALLLETTERHEIGHT; line++){
			config += Util.smallWhiteC[line] + Util.smallWhiteO[line] + Util.smallWhiteN[line] + Util.smallWhiteF[line] + Util.smallWhiteI[line] + Util.smallWhiteG[line] + "\n"; 
		}
		return config; 	
	}
	private static String generateBlueConfig(){
		String config = ""; 
		for (int line = 0; line < Util.SMALLLETTERHEIGHT; line++){
			config += Util.smallBlueC[line] + Util.smallBlueO[line] + Util.smallBlueN[line] + Util.smallBlueF[line] + Util.smallBlueI[line] + Util.smallBlueG[line] + "\n"; 
		}
		return config; 	
	}
	private static String generateWhiteExit(){
		String exit = ""; 
		for (int line = 0; line < Util.SMALLLETTERHEIGHT; line++){
			exit += Util.smallWhiteE[line] + Util.smallWhiteX[line] + Util.smallWhiteI[line] + Util.smallWhiteT[line] + "\n"; 
		}
		return exit; 	
	}
	private static String generateBlueExit(){
		String exit = ""; 
		for (int line = 0; line < Util.SMALLLETTERHEIGHT; line++){
			exit += Util.smallBlueE[line] + Util.smallBlueX[line] + Util.smallBlueI[line] + Util.smallBlueT[line] + "\n"; 
		}
		return exit; 	
	}


	private static String generateBanner(){
		int[] color = new int[Util.BANNERLENGTH]; 
		String banner = "" ; 

		// randomly generating coloring for the entire banner with 17 letters
		for (int i = 0; i<Util.BANNERLENGTH; i++){
			color[i] = Util.random.nextInt(4);	
		}
		for (int line = 0; line < Util.LETTERHEIGHT; line++){
			// applying the generated colring to the letters and concatenating letters to form the final, colorized, banner
			banner = banner + "   " + 
					Util.R[color[0]][line] + Util.O[color[1]][line] + Util.C[color[2]][line] + Util.K[color[3]][line] + "     " + // ROCK 
				 	Util.P[color[4]][line] + Util.A[color[5]][line] + Util.P[color[6]][line] + Util.E[color[7]][line] + Util.R[color[8]][line] + "     " + // PAPER
					Util.S[color[9]][line] + Util.C[color[10]][line] + Util.I[color[11]][line] + Util.S[color[12]][line] + Util.S[color[13]][line] + 
					Util.O[color[14]][line] + Util.R[color[15]][line] + Util.S[color[16]][line] + "\n"; // SCISSORS
		}
		return banner; 
	}
	private static void printBannerWhite(){
		for (int i = 0; i<8; i++){
			System.out.println("   "+
				Util.R[i]+Util.O[i]+Util.C[i]+Util.K[i]+"      "+ // ROCK
				Util.P[i]+Util.A[i]+Util.P[i]+Util.E[i]+Util.R[i]+"      "+ // PAPER
				Util.S[i]+Util.C[i]+Util.I[i]+Util.S[i]+Util.S[i]+Util.O[i]+Util.R[i]+Util.S[i]); // SCISSORS
		}
	}
	public static void toggleLeftRigth(){	
		Scanner scanner = new Scanner(System.in); 
		boolean isRed = true; 	
		while(true){
			Util.refresh(); 
			if (isRed){
				System.out.println(Util.WHITE+"left"+Util.RESET);
				System.out.println(Util.RED+"right"+Util.RESET);
			}	
			else {
				System.out.println(Util.RED+"left"+Util.RESET);
				System.out.println(Util.WHITE+"right"+Util.RESET);
			}
			System.out.println("Press Enter to toggle colors or 'q' to quit."); 
			String input = scanner.nextLine();
			if("q".equalsIgnoreCase(input)) break; 
			isRed = !isRed; 
		}
		scanner.close();
	}
}

