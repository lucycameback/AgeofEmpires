public class Building extends Item implements BuildingInterface {

    public Building(String symbol, int lifePoints, int cWood, int cGold, int cStone) {
        super(symbol, lifePoints, cWood, cGold, cStone);
    }
    Worker worker;
}
