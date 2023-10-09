package rps; 

public class Main {
	
		public static void main (String[] args) throws Exception{
				/*
				Board b = new Board(); 
				b.createPlayers(); 
				System.out.println(b.players.size()); 
				for (int i = 0; i < 10; i++){
						System.out.println(b.players.get(i).getId());
				}*/
				/*Board b = new Board(); 
				System.out.println("starting a new game"); 
				b.runGame(); */

				Frame frame = new Frame(); 
				String string = "testing out the new frame class !"; 
				//frame.setSection(0,0,string); 
				//System.out.println(frame.toString()); 
				//frame.clear(); 
				//System.out.println(frame.toString()); 
				//String string = "testing out the new frame class !"; 
				frame.setSection(180,10,string); 
				System.out.println(frame.toString()); 
		}
}
