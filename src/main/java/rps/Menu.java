package rps; 
import java.util.Scanner; 

public class Menu {
	public static void main (String[] args) {
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

