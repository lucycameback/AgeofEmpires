public class Test8 {

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
		// CASE 8 - GAME OVER
		//**********************************************************************************************************
		System.out.println("TEST CASE 8 - GAME OVER");
		try {
			g = new Game(3);
			g.getPlayer(0).purchase(new Catapult());
			g.getPlayer(1).pass();
			g.getPlayer(2).pass();
			
			for(int i=0; i<43; i++) {
				mymove(g.getPlayer(0).getSoldier(0), 0, 1);
				g.getPlayer(1).pass();
				g.getPlayer(2).pass();
			}
			
			for(int i=0; i<3; i++) {
			
				g.getPlayer(0).getSoldier(0).attack(1, 50);
				g.getPlayer(1).pass();
				g.getPlayer(2).pass();
				
			}
			g.getPlayer(0).getSoldier(0).attack(1, 50);
			g.getPlayer(1).pass();

			for(int i=0; i<99; i++) {
				mymove(g.getPlayer(0).getSoldier(0), 1, 0);
				g.getPlayer(1).pass();
			}
			
			
			for(int i=0; i<3; i++) {
				g.getPlayer(0).getSoldier(0).attack(100, 50);
				g.getPlayer(1).pass();
			}
			g.getPlayer(0).getSoldier(0).attack(100, 50);
			
			g.getMap().print();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	

}


