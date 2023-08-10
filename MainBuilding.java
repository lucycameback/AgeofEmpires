import java.util.ArrayList;

public class MainBuilding extends Building{

    public MainBuilding() {
        super("M",100,0,0,0);
    }
    ArrayList<Human> humans = new ArrayList<>();
    public void destroy( int power){
        this.setLifePoints(this.getLifePoints()-power);
        if(this.getLifePoints() < 1){
            Player temp = this.getPlayerOfItem();
            for (int i = 0; i < 50; i++) {
                for (int j = 0; j < 100; j++) {
                    if(g.getMap().itemStatus[i][j]!=null) {
                        if (g.getMap().itemStatus[i][j].getPlayerOfItem().equals(temp)) {
                            g.getMap().itemStatus[i][j] = null;
                        }
                    }
                }
            }

            g.isGameEnded();
        }
    }


}
