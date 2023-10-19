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
				//Util.printRaw(string); 
				String sstring = "##  #  ##" + Util.RED + "  #####  " + Util.RESET + Util.GREEN + "#####" + Util.RESET + "#####"; 
				// 10 times string makes 250 raw characters plus 90 unicode characters equals pureLength = 340
				String ssstring = string+string+string+string+string+string+string+string+string+string; 
				Frame frame = new Frame(); 
				frame.setSectionH(0,0,ssstring); 
				frame.setSectionH(0,5,Util.dividerH); 
				System.out.println("Section was set"); 
				System.out.println(frame.toString()); 
		}
}
