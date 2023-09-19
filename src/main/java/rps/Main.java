package rps; 

public class Main{
	
	public static void main(String[] args) throws Exception{
			int direction = -1; 
			int x = 0; 
			int n = 1000; 
			while (n != 0){
				Thread.sleep(500);
				if(x==9 || x==0) {
						direction = (-1) * direction; 
						System.out.println("direction changed to "+direction);
				}
				System.out.println(x); 
				Thread.sleep(1000);
				System.out.print("\033[H\033[2J");  
				System.out.flush();
				System.out.printf("%"+x+"s\n","o");
				x += direction*1; 
				System.out.println(x);
				n--; 
			}
	}	
}
