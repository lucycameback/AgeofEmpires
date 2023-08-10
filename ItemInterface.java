public interface ItemInterface {
	

	int getX();
	
	int getY();
	
	int getLifePoints();
	String getSymbol();
	int getCWood();
	int getCGold();
	int getCStone();
	
	default String print_message() {
		return getSymbol() + "\t"  + "x: "+getX() + "\t" +"y:"+ getY() + "\t" +  "lifePoints: "+getLifePoints();
	}

}
