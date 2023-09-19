package rps; 

public class BouncingBall{
	
	public static void main(String[] args) throws Exception{
			int direction = -1; 
		    int x = 1; 
			int n = 1000; 
			String s = ""; 
			String o = "o"; 
			while (n != 0){
				Thread.sleep(500);
				if(x==9 || x==0) {
						direction = (-1) * direction; 
						System.out.println("direction changed to "+direction);
				}
				System.out.print("\033[H\033[2J");  
				System.out.flush(); 
				s = padString(o, x, 1); 
				System.out.println(s); 
				x += direction*1; 
				n--; 
			}
	}

	private static String padString(String s, int pad, int direction){
			if (direction==1) { // left
				for (int i = 0; i<pad; i++){
					s = " " + s; 	
				}
			}
			else { // right
				for (int i = 0; i<pad; i++){
					s = s + " "; 	
				}		
			}
			return s; 
	}
}
