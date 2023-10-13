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
				String string = Util.RED+"#########################"+Util.RESET; 
				Frame frame = new Frame(); 
				frame.setSectionH(0,0,string); 
				System.out.println(frame.toString()); 
		}
}
