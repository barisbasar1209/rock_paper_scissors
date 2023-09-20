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
			else if (x!=0 && x!=width && y==0){
				int[] arr = {3,4,5,6,7};
				this.direction = arr[random.nextInt(5)]; 
			}
			else if (x==width && y==0){
				int[] arr = {5,6,7};
				this.direction = arr[random.nextInt(3)]; 
			}
			else if (x==width && y!=height && y!=0){
				int[] arr = {1,5,6,7,8}; 
				this.direction = arr[random.nextInt(5)]; 
			}
			else if (x==width && y==height){
				int[] arr = {1,7,8}; 	
				this.direction= arr[random.nextInt(3)]; 
			}
			else if (x!=width && y==height){
				int[] arr = {1,2,3,7,8}; 	
				this.direction = arr[random.nextInt(5)]; 	
			}
			else if (x==0 && y==height){
				int[] arr = {1,2,3}; 	
				this.direction = arr[random.nextInt(3)]; 
			}
			else if (x==0 && y!=0 && y!=height){
			   	int[] arr = {1,2,3,4,5}; 	
				this.direction = arr[random.nextInt(5)];
			}

			// moving the player icon
			switch (direction){
				case 1 : 
					y--;  
					break; 
				case 2 : 
					x++; 
					y--; 
					break; 
				case 3 : 
					x++; 
					break; 
				case 4 : 
					x++; 
					y++; 
					break; 
				case 5 : 
					y++; 
					break; 
				case 6 : 
					x--; 
					y++; 
					break; 
				case 7 : 
					x--; 
					break; 
				case 8 : 
					x--; 
					y--; 
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
