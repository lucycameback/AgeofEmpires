public interface PlayerInterface {
	
	
	int getWood();
	
	int getGold();
	
	int getStone();
	
	int getTowerCount();
	
	int getWorkerCount();
	
	
	int getSoldierCount();
	
	

	void pass() throws AgeofEmpiresException;

	Soldier getSoldier(int index);

	Worker getWorker(int index);

	void purchase(Item item) throws AgeofEmpiresException;
	
	University getUniversity() throws AgeofEmpiresException;

	Tower getTower(int index);
	MainBuilding getMainBuilding();

}
