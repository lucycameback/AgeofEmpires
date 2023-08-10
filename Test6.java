public class Test6 {

	public static void mymove(Human human, int x_move, int y_move) throws AgeofEmpiresException{
			//int player_x = game.getPlayer(player_no).getX();
			//int player_y = game.getPlayer(player_no).getY();
			
			int human_x = human.getX();
			int human_y = human.getY();
			
			human.move(human_x + x_move, human_y + y_move);
			
			//System.out.println(item_x + ", " + item_y);
		
	}

	public static void main(String[] args) throws AgeofEmpiresException
	{
		int x1, x2;
		int y1, y2;
		Game g;

		
		//**********************************************************************************************************
		// CASE 6 - TURN VIOLATION
		//**********************************************************************************************************
		System.out.println("TEST CASE 6 - TURN VIOLATION");
		try {
			g = new Game(4);
			g.getPlayer(0).purchase(new Cavalry());
			try {
				g.getPlayer(2).purchase(new Catapult());
			
			}
			catch(Exception e) {
				System.out.println("turn is violated");
			}
			
			g.getPlayer(1).purchase(new Archer());
			try {
				g.getPlayer(1).purchase(new Archer());
			
			}
			catch(Exception e) {
				System.out.println("turn is violated");
			}
			g.getPlayer(2).purchase(new Catapult());
			g.getPlayer(3).purchase(new Swordman());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	

}


