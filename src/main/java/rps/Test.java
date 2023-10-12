package rps; 
import java.util.Scanner; 

public class Test {
	private static volatile boolean shouldQuit = false; 

	public static void main(String[] args) {
		/*String banner = Menu.generateBanner(); 
		String[] decomp = banner.split("(?=\u001B\\[0m) | (?=[# ])");
		StringBuilder sb = new StringBuilder(); 
		//for(String part : decomp) sb.append(part); 
		//System.out.println(sb.toString()); 
		if (decomp[7] == " ") System.out.println("empty"); 
		else System.out.println("not empty: " + decomp[7]); */
		String string = "# # #"; 
		String[] parts = string.split("(?<= )|(?= )"); 
		System.out.println(parts.length); 
		for (String part : parts){
			if (part.equals(" ")) System.out.print("empty"); 
			else System.out.print(part); 	
		}
		System.out.print("\n"); 
	}
	public static void threadTests(){
			Thread printThread = new Thread(() -> {
				while(!shouldQuit){
					System.out.println("A"); 
					try{
						Thread.sleep(2000); 	
					}	
					catch(InterruptedException e){
						Thread.currentThread().interrupt(); 
						break; 	
					}
					if(!shouldQuit){
						System.out.println("B");	
						try{
							Thread.sleep(2000); 	
						}
						catch(InterruptedException e){
							Thread.currentThread().interrupt(); 
							break; 	
						}
					}	
				}
			}); 
			printThread.start();

			Scanner scanner = new Scanner(System.in); 

			Thread inputThread = new Thread(() -> {
				while(!shouldQuit){
					System.out.println("Enter 'C' for C, 'D' for D, or any other key to quit"); 
					char input = scanner.next().charAt(0); 
					char userInput = Character.toUpperCase(input); 
					
					if(userInput == 'C'){
						System.out.println("C"); 	
					}
					else if (userInput == 'D'){
						System.out.println("D"); 
					}
					else {
						shouldQuit = true; 	
					}
				}	
			}); 
			inputThread.start(); 
			try{
				inputThread.join(); 
				printThread.interrupt();	
			}
			catch (InterruptedException e) {
				Thread.currentThread().interrupt();	
			}
			scanner.close(); 
	}

}
