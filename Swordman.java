public class Swordman extends Soldier{
    public Swordman() {
        super("K", 5,2,2,0,3);
    }
    public boolean canReattack(int x, int y){
        for(int i = 0; i<=1; i++){
            if((x>0) && (y>0)) {
                boolean a = ((getX() + i) >= x) && ((getX() - i) <= x);
                boolean b = ((getY() + 1) >= y) && ((getY() - 1) <= y);
                boolean c = !((getX() == x) && (getY() == y));
                if (a && b && c) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void move(int x, int y) throws AgeofEmpiresException{
        if(g.turn()) {
            boolean valid = false;
            if((x>0) && (y>0)) {
                for (int i = 0; i <= 2; i++) {
                    boolean a = ((getX() + i) >= x) && ((getX() - i) <= x);
                    boolean b = ((getY() + (2 - i)) >= y) && ((getY() - (2 - i)) <= y);
                    boolean c = !((getX() == x) && (getY() == y));
                    if (a && b && c) {
                        valid = true;
                        break;
                    }
                }
            }
            if (valid && g.getMap().itemStatus[y-1][x-1]==null) {
                g.updateMap(x, y, this);
                this.x = x;
                this.y = y;
            } else {
                throw new AgeofEmpiresException();
            }
        }
    }

    @Override
    public void attack(int x, int y) throws AgeofEmpiresException {
        if(g.turn()) {
            boolean valid = canReattack(x,y);
            x--;
            y--;
            if (valid && (g.getMap().itemStatus[y][x] != null) && (!g.getMap().itemStatus[y][x].getPlayerOfItem().equals(this.getPlayerOfItem()))) {

                if(g.getMap().itemStatus[y][x] instanceof University){
                    g.getMap().itemStatus[y][x].setLifePoints(g.getMap().itemStatus[y][x].getLifePoints()-getPower());
                    if(g.getMap().itemStatus[y][x].getLifePoints() < 1){
                        if(g.getMap().itemStatus[y][x].getPlayerOfItem().getUniversity().totalTraining>0) {
                            for (int j = 0; j < g.getMap().itemStatus[y][x].getPlayerOfItem().soldiers.size(); j++) {

                                Human item = g.getMap().itemStatus[y][x].getPlayerOfItem().soldiers.get(j);

                                if (item instanceof Cavalry) {
                                    for (int i = 0; i < g.getMap().itemStatus[y][x].getPlayerOfItem().getUniversity().trainingLevelCavalry; i++) {
                                        item.setLifePoints(item.getLifePoints() - 1);
                                        item.setPower(item.getPower() - 1);
                                    }
                                } else if (item instanceof Catapult) {
                                    for (int i = 0; i < g.getMap().itemStatus[y][x].getPlayerOfItem().getUniversity().trainingLevelCatapult; i++) {
                                        item.setLifePoints(item.getLifePoints() - 1);
                                        item.setPower(item.getPower() - 1);
                                    }
                                } else if ((item instanceof Archer) || (item instanceof Spearaman) || (item instanceof Swordman)) {
                                    for (int i = 0; i < g.getMap().itemStatus[y][x].getPlayerOfItem().getUniversity().trainingLevelInfantry; i++) {
                                        item.setLifePoints(item.getLifePoints() - 1);
                                        item.setPower(item.getPower() - 1);
                                    }
                                }
                                if (item.getLifePoints() < 1) {
                                    item.getPlayerOfItem().soldiers.remove(item);
                                    if (item.getPlayerOfItem().getMainBuilding().humans.contains(item)) {
                                        item.getPlayerOfItem().getMainBuilding().humans.remove(item);
                                    } else {
                                        g.getMap().itemStatus[item.getY() - 1][item.getX() - 1] = null;
                                    }
                                }
                            }
                        }

                        if(((University) g.getMap().itemStatus[y][x]).worker == null) {
                            g.getMap().itemStatus[y][x] = null;
                        }else {
                            g.getMap().itemStatus[y][x] = ((University) g.getMap().itemStatus[y][x]).worker;
                        }
                        g.getMap().itemStatus[y][x].getPlayerOfItem().setUniversity(null);
                    }
                }else if(g.getMap().itemStatus[y][x] instanceof Tower){
                    g.getMap().itemStatus[y][x].setLifePoints(g.getMap().itemStatus[y][x].getLifePoints()-getPower());
                    this.setLifePoints(getLifePoints()-((Tower)g.getMap().itemStatus[y][x]).getPower());
                    if(g.getMap().itemStatus[y][x].getLifePoints() < 1){
                        if(((Tower) g.getMap().itemStatus[y][x]).worker == null){
                            g.getMap().itemStatus[y][x]=null;
                        }else{
                            g.getMap().itemStatus[y][x] = ((Tower) g.getMap().itemStatus[y][x]).worker;
                        }
                        g.getMap().itemStatus[y][x].getPlayerOfItem().towers.remove((Tower) g.getMap().itemStatus[y][x]);
                    }
                } else if (g.getMap().itemStatus[y][x] instanceof MainBuilding) {
                    ((MainBuilding) g.getMap().itemStatus[y][x]).destroy(getPower());
                }else if(g.getMap().itemStatus[y][x] instanceof Worker){
                    g.getMap().itemStatus[y][x].setLifePoints(g.getMap().itemStatus[y][x].getLifePoints()-getPower());
                    this.setLifePoints(this.getLifePoints()-(((Worker) g.getMap().itemStatus[y][x]).getPower()));
                    if(g.getMap().itemStatus[y][x].getLifePoints()<1){
                        g.getMap().itemStatus[y][x].getPlayerOfItem().workers.remove((Worker) g.getMap().itemStatus[y][x]);
                        g.getMap().itemStatus[y][x] = null;
                    }
                }else if(g.getMap().itemStatus[y][x] instanceof Archer){
                    g.getMap().itemStatus[y][x].setLifePoints(g.getMap().itemStatus[y][x].getLifePoints()-getPower());
                    this.setLifePoints(this.getLifePoints()-((Archer) g.getMap().itemStatus[y][x]).getPower());
                    if(g.getMap().itemStatus[y][x].getLifePoints()<1){
                        g.getMap().itemStatus[y][x].getPlayerOfItem().soldiers.remove((Soldier) g.getMap().itemStatus[y][x]);
                        g.getMap().itemStatus[y][x] = null;
                    }
                }else if(g.getMap().itemStatus[y][x] instanceof Catapult){
                    g.getMap().itemStatus[y][x].setLifePoints(g.getMap().itemStatus[y][x].getLifePoints()-getPower());
                    if(g.getMap().itemStatus[y][x].getLifePoints()<1){
                        g.getMap().itemStatus[y][x].getPlayerOfItem().soldiers.remove((Soldier)g.getMap().itemStatus[y][x]);
                        g.getMap().itemStatus[y][x] = null;
                    }
                }else if(g.getMap().itemStatus[y][x] instanceof Cavalry){
                    g.getMap().itemStatus[y][x].setLifePoints(g.getMap().itemStatus[y][x].getLifePoints()-getPower());
                    this.setLifePoints(this.getLifePoints()-((Cavalry) g.getMap().itemStatus[y][x]).getPower());
                    if(g.getMap().itemStatus[y][x].getLifePoints()<1){
                        g.getMap().itemStatus[y][x].getPlayerOfItem().soldiers.remove((Soldier)g.getMap().itemStatus[y][x]);
                        g.getMap().itemStatus[y][x] = null;
                    }
                } else if (g.getMap().itemStatus[y][x] instanceof Spearaman) {
                    this.setLifePoints(this.getLifePoints()-((Spearaman) g.getMap().itemStatus[y][x]).getPower());
                    if(this.getLifePoints()>0){
                        g.getMap().itemStatus[y][x].setLifePoints(g.getMap().itemStatus[y][x].getLifePoints()-getPower());
                        if(g.getMap().itemStatus[y][x].getLifePoints()<1){
                            g.getMap().itemStatus[y][x].getPlayerOfItem().soldiers.remove((Soldier)g.getMap().itemStatus[y][x]);
                            g.getMap().itemStatus[y][x] = null;
                        }
                    }
                }else if(g.getMap().itemStatus[y][x] instanceof Swordman){
                    g.getMap().itemStatus[y][x].setLifePoints(g.getMap().itemStatus[y][x].getLifePoints()-getPower());
                    this.setLifePoints(this.getLifePoints()-((Swordman) g.getMap().itemStatus[y][x]).getPower());
                    if(g.getMap().itemStatus[y][x].getLifePoints()<1){
                        g.getMap().itemStatus[y][x].getPlayerOfItem().soldiers.remove((Soldier)g.getMap().itemStatus[y][x]);
                        g.getMap().itemStatus[y][x] = null;
                    }
                }
                if(this.getLifePoints()<1) {
                    this.getPlayerOfItem().soldiers.remove(this);
                    if (g.getMap().itemStatus[getY()-1][getX()-1] == this) {
                        g.getMap().itemStatus[getY()-1][getX()-1] = null;
                    } else if (g.getMap().itemStatus[getY()-1][getX()-1] instanceof MainBuilding) {
                        ((MainBuilding) g.getMap().itemStatus[getY()-1][getX()-1]).humans.remove( this);
                    }
                }

            } else {
                g.playerTurn--;
                throw new AgeofEmpiresException();
            }
        }

    }
}
