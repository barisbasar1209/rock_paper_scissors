package rps; 
import java.util.Scanner; 
import java.lang.Thread; 

public class Test {
	private static volatile boolean shouldQuit = false; 

	public static void main(String[] args) {
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
