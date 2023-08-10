public class Test1 {

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
		// CASE 1 - HUMAN MOVES
		//**********************************************************************************************************
		System.out.println("TEST CASE 1 - HUMAN MOVES");
		try {
			g = new Game(4);
			g.getPlayer(0).purchase(new Cavalry());
			g.getPlayer(1).purchase(new Archer());
			g.getPlayer(2).purchase(new Catapult());
			g.getPlayer(3).purchase(new Swordman());
			
			g.getPlayer(0).purchase(new Spearaman());
			g.getPlayer(1).getWorker(0).move(98,49);
			g.getPlayer(2).getSoldier(0).move(1,49);
			g.getPlayer(3).getSoldier(0).move(99,2);
			
			
			g.getPlayer(0).getSoldier(0).move(3,3);
			g.getPlayer(1).getSoldier(0).move(99,49);
			g.getPlayer(2).pass();
			g.getPlayer(3).pass();		
			
			
			g.getPlayer(0).getSoldier(0).move(7,8);
			g.getPlayer(1).pass();
			g.getPlayer(2).pass();
			g.getPlayer(3).pass();
			
			
			g.getPlayer(0).getSoldier(1).move(3,1);
			g.getPlayer(1).pass();
			g.getPlayer(2).pass();
			g.getPlayer(3).pass();
			
			g.getMap().print();
			
			g.save_binary("binary_save");
			g.save_text("text_save");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	

}


