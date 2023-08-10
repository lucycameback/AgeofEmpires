public class Test7 {

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
		// CASE 7 - SPEARMAN WINS
		//**********************************************************************************************************
		System.out.println("TEST CASE 7 - SPEARMAN WINS");
		try {
			g = new Game(2);
			g.getPlayer(0).purchase(new Cavalry());
			g.getPlayer(1).purchase(new Spearaman());
			
			for(int i=0; i<10; i++) {
				mymove(g.getPlayer(0).getSoldier(0), 5, 4);
				mymove(g.getPlayer(1).getWorker(0), -1, -1);
			}
			
			
			mymove(g.getPlayer(0).getSoldier(0), 9, 0);
			mymove(g.getPlayer(1).getSoldier(0), -1, -1);
			
			mymove(g.getPlayer(0).getSoldier(0), 9, 0);
			g.getPlayer(1).getWorker(0).build(new Tower());
			
			
			
			mymove(g.getPlayer(0).getSoldier(0), 9, 0);
			mymove(g.getPlayer(1).getSoldier(0), -2, 0);
			
			System.out.println("P0 Cavalry: " + g.getPlayer(0).getSoldier(0).getLifePoints());
			System.out.println("P1 Spearman: " + g.getPlayer(1).getSoldier(0).getLifePoints());
			System.out.println("P1 Worker: " + g.getPlayer(1).getWorker(0).getLifePoints());
			System.out.println("P1 Tower: " + g.getPlayer(1).getTower(0).getLifePoints());
			System.out.println("------");
			
			mymove(g.getPlayer(0).getSoldier(0), 7, 0);
			mymove(g.getPlayer(1).getSoldier(0), -1, -1);
			
			
			mymove(g.getPlayer(0).getSoldier(0), 6, 0);
			
			x1 = g.getPlayer(0).getSoldier(0).getX();
			y1 = g.getPlayer(0).getSoldier(0).getY();
			
			x2 = g.getPlayer(1).getTower(0).getX();
			y2 = g.getPlayer(1).getTower(0).getY();
			
			for(int i=0; i<2; i++) {
				g.getPlayer(1).getTower(0).attack(x1, y1);
				g.getPlayer(0).getSoldier(0).attack(x2, y2);
			}
			
			System.out.println("P0 Cavalry: " + g.getPlayer(0).getSoldier(0).getLifePoints());
			System.out.println("P1 Spearman: " + g.getPlayer(1).getSoldier(0).getLifePoints());
			System.out.println("P1 Worker: " + g.getPlayer(1).getWorker(0).getLifePoints());
			System.out.println("P1 Tower: " + g.getPlayer(1).getTower(0).getLifePoints());
			System.out.println("------");
			
			
			g.getPlayer(1).pass();
			mymove(g.getPlayer(0).getSoldier(0), 2, 3);
			
			x1 = g.getPlayer(0).getSoldier(0).getX();
			y1 = g.getPlayer(0).getSoldier(0).getY();
			g.getPlayer(1).getTower(0).attack(x1, y1);
			
			
			System.out.println("P0 Cavalry: " + g.getPlayer(0).getSoldier(0).getLifePoints());
			System.out.println("P1 Spearman: " + g.getPlayer(1).getSoldier(0).getLifePoints());
			System.out.println("P1 Worker: " + g.getPlayer(1).getWorker(0).getLifePoints());
			System.out.println("P1 Tower: " + g.getPlayer(1).getTower(0).getLifePoints());
			System.out.println("------");
			
			mymove(g.getPlayer(0).getSoldier(0), 3, 3);
			
			x1 = g.getPlayer(0).getSoldier(0).getX();
			y1 = g.getPlayer(0).getSoldier(0).getY();
			
			g.getPlayer(1).getSoldier(0).attack(x1, y1);
			System.out.println("P0 Cavalry is dead");
			System.out.println("P1 Spearman: " + g.getPlayer(1).getSoldier(0).getLifePoints());
			System.out.println("P1 Worker: " + g.getPlayer(1).getWorker(0).getLifePoints());
			System.out.println("P1 Tower: " + g.getPlayer(1).getTower(0).getLifePoints());
			System.out.println("------");
			
			g.getMap().print();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	

}


