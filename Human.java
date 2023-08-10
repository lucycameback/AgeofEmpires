public class Human extends Item implements HumanInterface {

    public Human(String symbol, int lifePoints, int cWood, int cGold, int cStone, int power) {
        super(symbol, lifePoints, cWood, cGold, cStone);
        this.power = power;
    }
    private int power;
    public void setPower(int power){
        this.power =power;
    }

    public int getPower() {
        return power;
    }

    @Override
    public void attack(int x, int y) throws AgeofEmpiresException {

    }

    @Override
    public void move(int x, int y) throws AgeofEmpiresException {

    }
}


