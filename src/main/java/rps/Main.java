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
				//frame.setSectionH(0,11,Util.dividerH); 
				//frame.setSectionH(0,34,Util.dividerH); 
				//frame.setSectionV(45,12,Util.dividerV); 
				//frame.setSectionV(140,12,Util.dividerV); 
				//frame.setSectionV(0,12,Util.dividerV);
				//frame.setSectionV(184,12,Util.dividerV);

				//frame.setBigString(75,14,Menu.whiteShoot);
				//frame.setBigString(70,21,Menu.whiteConfig);
				//frame.setBigString(79,28,Menu.whiteExit);
				String banner = Menu.generateBanner();
				frame.setBigString(0,0,banner); 
				System.out.println(frame.toString()); 
				//frame.setSectionH(0,0,Util.dividerH); // has length 185 + 5 + 4 = 194
				//frame.setSectionH(0,0,Util.RED + Util.dividerH + Util.RESET); 
				//frame.setSectionH(0,0, Util.RED + "#" + Util.RESET); 
		}
}
