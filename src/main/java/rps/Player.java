package rps; 

public abstract class Player{
	
		private int id; 
		private int score; 
		private int x; 
		private int y; 
		private int direction; // integer from 1 to 8 clockwise determining the direction, 1 is up 5 is down
		private static created = 0; 		

		public Player(int x, int y){
				this.x = x; 
				this.y = y; 
				this.id = this.created; 	
				this.created++; 
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
