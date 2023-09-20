package rps; 

import java.util.Random; 

public abstract class Player{
		protected char icon; 	
		private int id; 
		private int score; 
		private int x; 
		private int y; 
		private int direction; // integer from 1 to 8 clockwise determining the direction, 1 is up 5 is down
		private static int created = 0; 		
		private static Random random = new Random(); 

		public Player(int x, int y, int direction){
			this.x = x; // alternatively to random initialization  
			this.y = y; 
			this.direction = direction; 
			this.id = this.created; 	
			this.created++; 
		}	
		public void move(int width, int height){

			// changing direction if necessary
			if (x==0 && y==0){
				int[] arr = {3,4,5}; 
				this.direction = arr[random.nextInt(3)]; 
			}
			else if (x>0 && x<width && y==0){
				int[] arr = {3,4,5,6,7};
				this.direction = arr[random.nextInt(5)]; 
			}
			else if (x==width && y==0){
				int[] arr = {5,6,7};
				this.direction = arr[random.nextInt(3)]; 
			}
			else if (x==width && y<height && y>0){
				int[] arr = {1,5,6,7,8}; 
				this.direction = arr[random.nextInt(5)]; 
			}
			else if (x==width && y==height){
				int[] arr = {1,7,8}; 	
				this.direction= arr[random.nextInt(3)]; 
			}
			else if (x>0 && x<width && y==height){
				int[] arr = {1,2,3,7,8}; 	
				this.direction = arr[random.nextInt(5)]; 	
			}
			else if (x==0 && y==height){
				System.out.println("Else if case x==0 && y==height. Values x,y are " + x + " " + y + "."); 
				int[] arr = {1,2,3}; 	
				this.direction = arr[random.nextInt(3)]; 
			}
			else if (x==0 && y>0 && y<height){
				System.out.println("Else if case x==0 && y==height. Values x,y are " + x + " " + y + "."); 
			   	int[] arr = {1,2,3,4,5}; 	
				this.direction = arr[random.nextInt(5)];
			}

			// moving the player icon
			switch (direction){
				case 1 : 
					y--;  
					if (y<0) {
						System.out.println("Error: y<0! Current direction is " + direction + "."); 	
						System.exit(1); 
					}
					break; 
				case 2 : 
					x++; 
					y--; 
					if (y<0) {
						System.out.println("Error: y<0 ! Current direction is " + direction + "."); 	
						System.exit(1); 
					}
					if (x>49) {
						System.out.println("Error: x>49! Current direction is " + direction + "."); 	
						System.exit(1); 
					}
					break; 
				case 3 : 
					x++; 
					if (x>49) {
						System.out.println("Error: x>49! Current direction is " + direction + "."); 	
						System.exit(1); 
					}
					break; 
				case 4 : 
					x++; 
					y++; 
					if (x>49) {
						System.out.println("Error: x>49! Current direction is " + direction + "."); 	
						System.exit(1); 
					}
					if (y>19) {
						System.out.println("Error: y>19! Current direction is " + direction + "."); 	
						System.exit(1); 
					}
					break; 
				case 5 : 
					y++; 
					if (y>19) {
						System.out.println("Error: y>19! Current direction is " + direction + "."); 	
						System.exit(1); 
					}
					break; 
				case 6 : 
					x--; 
					if (x>49) {
						System.out.println("Error: x>49! Current direction is " + direction + "."); 	
						System.exit(1); 
					}
					y++; 
					if (y>19) {
						System.out.println("Error: y>19! Current direction is " + direction + "."); 	
						System.exit(1); 
					}
					break; 
				case 7 : 
					x--; 
					if (x<0) {
						System.out.println("Error: x<0! x-value is " + x + ". y-value is " + y + ". Current direction is " + direction + "."); 	
						System.out.println("The player is " + icon + id + "."); 
						System.exit(1); 
					}
					break; 
				case 8 : 
					x--; 
					if (x<0) {
						System.out.println("Error: x<0! x-value is " + x + ". y-value is " + y + ". Current direction is " + direction + "."); 	
						System.out.println("The player is " + icon + id + "."); 
						System.exit(1); 
					}
					y--; 
					if (y<0) {
						System.out.println("Error: y<0! Current direction is " + direction + "."); 	
						System.exit(1); 
					}
					break; 
			}
		}	
		public char getIcon(){
			return icon; 
		}
		public int getDirection(){
			return direction; 	
		}
		public int getY(){
			return y; 	
		}	
		public int getX(){
			return x; 	
		}
		public int getScore(){
			return score; 	
		}	
		public int getId(){
			return id; 	
		}
		public static int getCreated(){
			return created; 	
		}
}
