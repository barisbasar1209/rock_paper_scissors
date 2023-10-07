package rps; 
import java.util.Scanner; 

public class Menu {
	
	// writing the characters as arrays of strings were each entry is one line. Then constructing each character. Whenever I want to 
	// append two characters I just append their respective lines
			
	public static void main (String[] args) {
		for (int i = 0; i<8; i++){
			System.out.println("   "+
				Util.yellowR[i]+Util.O[i]+Util.C[i]+Util.K[i]+"      "+ // ROCK
				Util.redP[i]+Util.A[i]+Util.P[i]+Util.E[i]+Util.R[i]+"      "+ // PAPER
				Util.greenS[i]+Util.C[i]+Util.I[i]+Util.S[i]+Util.S[i]+Util.O[i]+Util.R[i]+Util.S[i]); // SCISSORS
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

