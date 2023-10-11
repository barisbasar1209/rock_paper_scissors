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
				System.out.println(banner.charAt(0)); 
				frame.setBigString(0,0,banner); 
				//frame.setSectionH(0,0,Util.dividerH); // has length 185 + 5 + 4 = 194
				//frame.setSectionH(0,0,Util.RED + Util.dividerH + Util.RESET); 
				//frame.setSectionH(0,0, Util.RED + "#" + Util.RESET); 
				System.out.println(frame.toString()); 
				System.out.println(frame.frame[0][0].length());
				System.out.println(frame.frame[0][1].length());
				System.out.println(frame.frame[0][2].length());
				System.out.println(frame.frame[0][3].length());
				System.out.println(frame.frame[0][4].length());
				System.out.println(frame.frame[0][5].length());
				System.out.println(frame.frame[0][6].length());
				System.out.println(frame.frame[0][7].length());
				System.out.println(frame.frame[0][8].length());
				System.out.println(frame.frame[0][9].length());
				System.out.println(frame.frame[0][10].length());
		}
}
