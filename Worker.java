public class Worker extends Human implements WorkerInterface{

    public Worker() {
        super("W", 2,0,1,0, 1);
    }
    public boolean canReattack(int x, int y){
        if((x>0) && (y>0)) {
            for (int i = 0; i <= 1; i++) {
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
                        g.getMap().itemStatus[y][x].getPlayerOfItem().soldiers.remove((Soldier) g.getMap().itemStatus[y][x]);
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
                    this.getPlayerOfItem().workers.remove(this);
                    if (g.getMap().itemStatus[getY()-1][getX()-1] == this) {
                        g.getMap().itemStatus[getY()-1][getX()-1] = null;
                    } else if (g.getMap().itemStatus[getY()-1][getX()-1] instanceof MainBuilding) {
                        ((MainBuilding) g.getMap().itemStatus[getY()-1][getX()-1]).humans.remove(this);
                    } else if (g.getMap().itemStatus[getY()-1][getX()-1] instanceof Building) {
                        ((Building) g.getMap().itemStatus[getY()-1][getX()-1]).worker = null;
                    }
                }

            } else {
                g.playerTurn--;
                throw new AgeofEmpiresException();
            }
        }

    }

    @Override
    public void move(int x, int y) throws AgeofEmpiresException{
        if(g.turn()) {
            boolean valid = false;
            if((x>0)&& (y>0)) {
                for (int i = 0; i <= 3; i++) {
                    boolean a = ((getX() + i) >= x) && ((getX() - i) <= x);
                    boolean b = ((getY() + (3 - i)) >= y) && ((getY() - (3 - i)) <= y);
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
                g.playerTurn--;
                throw new AgeofEmpiresException();
            }
        }
    }
    @Override
    public void build(Building b) throws AgeofEmpiresException{
        if(g.turn()){
            if(this.getPlayerOfItem().getMainBuilding().humans.contains(this)){
                g.playerTurn--;
                throw new AgeofEmpiresException();
            }
            if (b instanceof MainBuilding) {
                g.playerTurn--;
                throw new AgeofEmpiresException();
            }
            if ((this.getPlayerOfItem().getWood() < b.getCWood()) || (this.getPlayerOfItem().getGold() < b.getCGold()) || (this.getPlayerOfItem().getStone() < b.getCStone())) {
                g.playerTurn--;
                throw new AgeofEmpiresException();
            } else {
                this.getPlayerOfItem().setWood(this.getPlayerOfItem().getWood() - b.getCWood());
                this.getPlayerOfItem().setGold(this.getPlayerOfItem().getGold() - b.getCGold());
                this.getPlayerOfItem().setStone(this.getPlayerOfItem().getStone() - b.getCStone());
                if (b instanceof Tower) {
                    this.getPlayerOfItem().towers.add((Tower) b);
                }else if ((b instanceof University) && (this.getPlayerOfItem().getUniversity() != null)) {
                    g.playerTurn--;
                    throw new AgeofEmpiresException();
                } else if ((b instanceof University) && (this.getPlayerOfItem().getUniversity() == null)) {
                    this.getPlayerOfItem().setUniversity((University) b);
                }
                g.updateMap(getX(),getY(),b);
                b.worker = this;
                b.gameToItem(g);
                b.playerOfItem(this.getPlayerOfItem());
                b.x = getX();
                b.y = getY();

            }

        }
    }


}
