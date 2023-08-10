public class Test3 {

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
		// CASE 3 - SAVE and LOAD
		//**********************************************************************************************************
		System.out.println("TEST CASE 3 - SAVE and LOAD");
		try {
			Game g1 = new Game("binary_save", true);
			Game g2 = new Game("text_save", false);
			
			//System.out.println(g1.getMap().status().equals(g2.getMap().status()));
			g1.getMap().print();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	

}


