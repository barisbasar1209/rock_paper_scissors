package rps; 

public class Main{
	
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
				s = String.format("%"+ x + "s", o);
				System.out.println(s); 
				x += direction*1; 
				n--; 
			}
	}
}
