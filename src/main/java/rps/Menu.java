package rps; 
import java.util.Scanner; 

public class Menu {
	
	// writing the characters as arrays of strings were each entry is one line. Then constructing each character. Whenever I want to 
	// append two characters I just append their respective lines
	
	public static void main (String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in); 
		String banner = ""; 
		while(true){
			Util.refresh(); 
			banner = generateBanner();
			System.out.println(banner); 
			Thread.sleep(2000); 	
		}
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

