import java.io.Serializable;

public class Item implements ItemInterface, Serializable {
    private final String symbol;
    private int lifePoints;
    private final int cWood;
    private final int cGold;
    private final int cStone;
    protected int x;
    protected int y;
    private Player player;
    Game g;
    public void gameToItem (Game g){
        this.g = g;
    }
    public void playerOfItem(Player player){
        this.player = player;
    }
    public Player getPlayerOfItem(){
        return player;
    }
    public Item (String symbol, int lifePoints,int cWood, int cGold, int cStone){
        this.symbol = symbol;
        this.lifePoints = lifePoints;
        this.cWood = cWood;
        this.cGold = cGold;
        this.cStone = cStone;
    }

    @Override
    public int getX() {
        return x;
    }


    @Override
    public int getY() {
        return y;
    }


    @Override
    public int getLifePoints() {
        return lifePoints;
    }
    public void setLifePoints(int lifePoints){
        this.lifePoints = lifePoints;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public int getCWood() {
        return cWood;
    }

    @Override
    public int getCGold() {
        return cGold;
    }

    @Override
    public int getCStone() {
        return cStone;
    }
}
