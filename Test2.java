public class Test2 {

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
		// CASE 2 - INVALID MOVES
		//**********************************************************************************************************
		System.out.println("TEST CASE 2 - INVALID MOVES");
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
		
			try {
			mymove(g.getPlayer(0).getSoldier(0), 5, 5);
		
			}
			catch(Exception e) {
				System.out.println("Cavalry invalid move");
			}
			mymove(g.getPlayer(0).getSoldier(0), 0, 9);
			//-------------------
			try {
				mymove(g.getPlayer(1).getSoldier(0), -2, -1);
			
			}
			catch(Exception e) {
				System.out.println("Archer invalid move");
			}
			mymove(g.getPlayer(1).getSoldier(0), -1, -1);
			//-------------------
			try {
				mymove(g.getPlayer(2).getSoldier(0), 1, -1);
			
			}
			catch(Exception e) {
				System.out.println("Catapult invalid move");
			}
			mymove(g.getPlayer(2).getSoldier(0), 0, -1);
			//-------------------
			
			try {
				mymove(g.getPlayer(3).getSoldier(0), 1, -1);
			
			}
			catch(Exception e) {
				System.out.println("Swordman invalid move");
			}
			mymove(g.getPlayer(3).getSoldier(0), 0, 2);
			//-------------------
			try {
				mymove(g.getPlayer(0).getSoldier(1), 1, 2);
			
			}
			catch(Exception e) {
				System.out.println("Spearman invalid move");
			}
			mymove(g.getPlayer(0).getSoldier(0), 0, 9);
			//-------------------
			try {
				mymove(g.getPlayer(1).getWorker(0), -2, -2);
			
			}
			catch(Exception e) {
				System.out.println("Worker invalid move");
			}
			mymove(g.getPlayer(1).getWorker(0), -1, -2);
			//-------------------
			try {
				x1 = g.getPlayer(0).getSoldier(0).getX();
				y1 = g.getPlayer(0).getSoldier(0).getY();
				g.getPlayer(2).getSoldier(0).attack(x1, y1);
			
			}
			catch(Exception e) {
				System.out.println("Catapult invalid attack range");
			}
			g.getPlayer(2).pass();
			g.getPlayer(3).pass();
			
			for(int i=0; i<3; i++) {
				mymove(g.getPlayer(0).getSoldier(0), -1, 7);
				g.getPlayer(1).pass();
				g.getPlayer(2).pass();
				g.getPlayer(3).pass();
			}
			
			g.getPlayer(0).pass();
			g.getPlayer(1).pass();
			
			try {
				x1 = g.getPlayer(0).getSoldier(0).getX();
				y1 = g.getPlayer(0).getSoldier(0).getY();
				g.getPlayer(2).getSoldier(0).attack(x1, y1);
			
			}
			catch(Exception e) {
				System.out.println("Catapult invalid attack range");
			}
			g.getPlayer(2).pass();
			g.getPlayer(3).pass();
			
			mymove(g.getPlayer(0).getSoldier(0), 4, 0);
			g.getPlayer(1).pass();
			x1 = g.getPlayer(0).getSoldier(0).getX();
			y1 = g.getPlayer(0).getSoldier(0).getY();
			g.getPlayer(2).getSoldier(0).attack(x1, y1);
			g.getMap().print();
		
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	

}


