public class Test4 {

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
		// CASE 4 - UPGRADE and ATTACK
		//**********************************************************************************************************
		System.out.println("TEST CASE 4 - UPGRADE and ATTACK");
		try {
			g = new Game(2);
			g.getPlayer(0).purchase(new Cavalry());
			g.getPlayer(1).purchase(new Swordman());
			
			int i=0;
			for(i=0; i<10; i++) {
				mymove(g.getPlayer(0).getSoldier(0), 5, 4);
				mymove(g.getPlayer(1).getSoldier(0), -1, -1);
			}
			
			
			mymove(g.getPlayer(0).getSoldier(0), 9, 0);
			mymove(g.getPlayer(1).getWorker(0), -2, -1);
			
			mymove(g.getPlayer(0).getSoldier(0), 9, 0);
			g.getPlayer(1).getWorker(0).build(new University());
			
			System.out.println("P0 Cavalry: " + g.getPlayer(0).getSoldier(0).getLifePoints());
			System.out.println("P1 Swordman: " + g.getPlayer(1).getSoldier(0).getLifePoints());
			System.out.println("------");
			
			mymove(g.getPlayer(0).getSoldier(0), 8, 0);
			g.getPlayer(1).getUniversity().trainInfantry();
			
			System.out.println("P0 Cavalry: " + g.getPlayer(0).getSoldier(0).getLifePoints());
			System.out.println("P1 Swordman: " + g.getPlayer(1).getSoldier(0).getLifePoints());
			System.out.println("------");
			
			mymove(g.getPlayer(0).getSoldier(0), 9, 0);
			mymove(g.getPlayer(1).getSoldier(0), -2, 0);
			
			
			mymove(g.getPlayer(0).getSoldier(0), 1, 0);
			
			
			x1 = g.getPlayer(0).getSoldier(0).getX();
			y1 = g.getPlayer(0).getSoldier(0).getY();
			g.getPlayer(1).getSoldier(0).attack(x1, y1);
			
			System.out.println(g.getPlayer(0).getSoldier(0).getLifePoints());
			System.out.println("P0 Cavalry: " + g.getPlayer(0).getSoldier(0).getLifePoints());
			System.out.println("P1 Swordman is dead");
			System.out.println("------");
			
			g.getMap().print();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	

}


