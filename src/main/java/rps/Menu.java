package rps; 
import java.util.Scanner; 

public class Menu {
	
	final static int SHOOT = 0; 
	final static int CONFIG = 1; 
	final static int EXIT = 2; 

	// writing the characters as arrays of strings were each entry is one line. Then constructing each character. Whenever I want to 
	// append two characters I just append their respective lines
	/*final static String whiteShoot  = generateWhiteShoot(); 	
	final static String whiteConfig = generateWhiteConfig(); 
	final static String whiteExit   = generateWhiteExit(); 
	final static String blueShoot   = generateBlueShoot(); 
	final static String blueConfig  = generateBlueConfig(); 
	final static String blueExit    = generateBlueExit(); */
	//final static String banner 		= generateBanner(); 
		

	public static void main (String[] args) throws Exception{
	}	
	/*
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
 	*/
	public static String generateBanner()throws Exception{
		StringBuilder banner = new StringBuilder(); 
		System.out.println(Util.C[1][7].length); 
		Thread.sleep(2500); 
		for (int line = 0; line < 8; line++){
			System.out.println("line: "+line); 
			banner.append(
				generatePart(Util.R[1][line])+generatePart(Util.O[1][line])+generatePart(Util.C[1][line])+generatePart(Util.K[1][line])+ "xxxxx" );
			banner.append(generatePart(Util.P[1][line])); 
			System.out.println(Util.P[1].length); 
			banner.append(generatePart(Util.P[1][line])); 
			System.out.println(Util.A[1].length); 
			Thread.sleep(1000); 
			banner.append(generatePart(Util.A[1][line])); 
			banner.append(generatePart(Util.P[1][line])+generatePart(Util.E[1][line])+generatePart(Util.R[1][line])+ "xxxxx" ); 
			banner.append(generatePart(Util.S[1][line])+generatePart(Util.C[1][line])); 
		    banner.append(generatePart(Util.I[1][line])+generatePart(Util.S[1][line])+generatePart(Util.S[1][line])); 
			banner.append(generatePart(Util.O[1][line])+generatePart(Util.R[1][line])+generatePart(Util.S[1][line])+ "\n"); 
		}
		return banner.toString(); 
	}	
	public static String generatePart(String[] letter){
		StringBuilder sb = new StringBuilder(); 
		for (int i = 0; i<letter.length; i++)
			sb.append(letter[i]); 

		return sb.toString(); 
	}
	/*
	public static String depgenerateBanner(){
		int[] color = new int[Util.BANNERLENGTH]; 
		StringBuilder banner = new StringBuilder();

		// randomly generating coloring for the entire banner with 17 letters
		for (int i = 0; i<Util.BANNERLENGTH; i++){
			//color[i] = Util.random.nextInt(4);	
			color[i] = i%3+1; 
		}
		for (int line = 0; line < 1 ; line++){
			// applying the generated colring to the letters and concatenating letters to form the final, colorized, banner
			banner.append( 
					Util.R[color[0]][line] + Util.O[color[1]][line] + Util.C[color[2]][line] + Util.K[color[3]][line] + "ooooo" + // ROCK 
				 	Util.P[color[4]][line] + Util.A[color[5]][line] + Util.P[color[6]][line] + Util.E[color[7]][line] + Util.R[color[8]][line] + "ooooo" + // PAPER
					Util.S[color[9]][line] + Util.C[color[10]][line] + Util.I[color[11]][line] + Util.S[color[12]][line] + Util.S[color[13]][line] + 
					Util.O[color[14]][line] + Util.R[color[15]][line] + Util.S[color[16]][line] ); // SCISSORS
		}
		return banner.toString(); 
	}*/
}

