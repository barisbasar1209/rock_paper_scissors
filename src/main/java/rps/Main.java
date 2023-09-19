package rps; 

public class Main {
	
		public static void main (String[] args){
				Rock rock1 = new Rock(4,5); 
				Rock rock2 = new Rock(5,2); 
				System.out.println(rock1.getId()); 
				System.out.println(rock1.getX()); 
				System.out.println(rock1.getY()); 
				System.out.println(rock2.getId()); 
				System.out.println(rock2.getX()); 
				System.out.println(rock2.getY()); 
		}
}
