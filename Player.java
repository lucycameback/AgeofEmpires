import java.io.Serializable;
import java.util.ArrayList;

public class Player implements PlayerInterface, Serializable {
    private int wood = 100;
    private int gold = 100;
    private int stone = 100;
    private final MainBuilding mainBuilding = new MainBuilding();
    private University[] university = new University[1];
    ArrayList<Tower> towers = new ArrayList<>();
    ArrayList<Worker> workers = new ArrayList<>();
    ArrayList<Soldier> soldiers = new ArrayList<>();
    Game g;
    public Player(Game g){
        this.g = g;
        mainBuilding.gameToItem(g);
        mainBuilding.playerOfItem(this);
    }

    @Override
    public int getWood() {
        return wood;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

    @Override
    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public int getStone() {
        return stone;
    }

    public void setStone(int stone) {
        this.stone = stone;
    }

    @Override
    public int getTowerCount() {
        return towers.size();
    }

    @Override
    public int getWorkerCount() {
        return workers.size();
    }

    @Override
    public int getSoldierCount() {
        return soldiers.size();
    }

    @Override
    public void pass() throws AgeofEmpiresException{
        g.turn();
    }

    @Override
    public Soldier getSoldier(int index) {
        return soldiers.get(index);
    }

    @Override
    public Worker getWorker(int index) {
        return workers.get(index);
    }

    @Override
    public void purchase(Item item) throws AgeofEmpiresException{
        if(g.turn()){
            if (item instanceof Building) {
                g.playerTurn--;
                throw new AgeofEmpiresException();
            }
            if ((wood < item.getCWood()) || (gold < item.getCGold()) || (stone < item.getCStone())) {
                g.playerTurn--;
                throw new AgeofEmpiresException();
            }
            if ((soldiers.size() + workers.size()) >= 20) {

                g.playerTurn--;
                throw new AgeofEmpiresException();
            } else {
                wood -= item.getCWood();
                gold -= item.getCGold();
                stone -= item.getCStone();
                if (item instanceof Soldier) {
                    soldiers.add((Soldier) item);
                }
                if (item instanceof Worker) {
                    workers.add((Worker) item);
                }
                item.gameToItem(g);
                item.playerOfItem(this);
                mainBuilding.humans.add((Human) item);
                item.x = mainBuilding.getX();
                item.y = mainBuilding.getY();
                if ((getUniversity() != null)){
                    if ( (getUniversity().trainingLevelCavalry > 0) && (item instanceof Cavalry)) {
                        for (int i = 0; i < getUniversity().trainingLevelCavalry; i++) {
                            item.setLifePoints(item.getLifePoints() + 1);
                            ((Human) item).setPower(((Soldier) item).getPower() + 1);
                        }
                    }else if((getUniversity().trainingLevelCatapult > 0)&&(item instanceof Catapult)) {
                        for (int i = 0; i < getUniversity().trainingLevelCatapult; i++) {
                            item.setLifePoints(item.getLifePoints() + 1);
                            ((Human) item).setPower(((Soldier) item).getPower() + 1);
                        }
                    }else if((getUniversity().trainingLevelInfantry > 0)&&((item instanceof Archer)||(item instanceof Spearaman)||(item instanceof Swordman))) {
                        for (int i = 0; i < getUniversity().trainingLevelInfantry; i++) {
                            item.setLifePoints(item.getLifePoints() + 1);
                            ((Human) item).setPower(((Soldier) item).getPower() + 1);
                        }
                    }
                }
            }
        }
    }



    @Override
    public University getUniversity(){
        return university[0];
    }
    public void setUniversity(University u){
        this.university[0] = u;
    }

    @Override
    public Tower getTower(int index) {
        return towers.get(index);
    }

    @Override
    public MainBuilding getMainBuilding() {
        if(mainBuilding.getLifePoints()<1){
            return null;
        }
        return mainBuilding;
    }
}
