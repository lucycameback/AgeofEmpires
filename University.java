public class University extends Building implements UniversityInterface{
    public University() {
        super("U", 30, 30,50,5);
    }
    int trainingLevelCavalry=0;
    int trainingLevelCatapult=0;
    int trainingLevelInfantry=0;
    int totalTraining=0;

    @Override
    public void trainInfantry() throws AgeofEmpiresException{
        if(g.turn()) {
            trainingLevelInfantry++;
            totalTraining++;
            if (this.getPlayerOfItem().getGold() >= 50) {
                this.getPlayerOfItem().setGold(this.getPlayerOfItem().getGold() - 50);
                for (int i = 0; i < this.getPlayerOfItem().soldiers.size(); i++) {
                    Soldier x = this.getPlayerOfItem().soldiers.get(i);
                    if ((x instanceof Archer) || (x instanceof Spearaman) || (x instanceof Swordman)) {
                        this.getPlayerOfItem().soldiers.get(i).setLifePoints(this.getPlayerOfItem().soldiers.get(i).getLifePoints() + 1);
                        this.getPlayerOfItem().soldiers.get(i).setPower(this.getPlayerOfItem().soldiers.get(i).getPower() + 1);
                    }
                }
            } else {
                g.playerTurn--;
                throw new AgeofEmpiresException();
            }
        }

    }

    @Override
    public void trainCavalry() throws AgeofEmpiresException{
        if(g.turn()) {
            trainingLevelCavalry++;
            totalTraining++;
            if (this.getPlayerOfItem().getGold() >= 50) {
                this.getPlayerOfItem().setGold(this.getPlayerOfItem().getGold() - 50);
                for (int i = 0; i < this.getPlayerOfItem().soldiers.size(); i++) {
                    if (this.getPlayerOfItem().soldiers.get(i) instanceof Cavalry) {
                        this.getPlayerOfItem().soldiers.get(i).setLifePoints(this.getPlayerOfItem().soldiers.get(i).getLifePoints() + 1);
                        this.getPlayerOfItem().soldiers.get(i).setPower(this.getPlayerOfItem().soldiers.get(i).getPower() + 1);
                    }
                }
            } else {
                g.playerTurn--;
                throw new AgeofEmpiresException();
            }
        }
    }

    @Override
    public void trainCatapult() throws AgeofEmpiresException{
        if(g.turn()) {
            trainingLevelCatapult++;
            totalTraining++;
            if (this.getPlayerOfItem().getGold() >= 50) {
                this.getPlayerOfItem().setGold(this.getPlayerOfItem().getGold() - 50);
                for (int i = 0; i < this.getPlayerOfItem().soldiers.size(); i++) {
                    if (this.getPlayerOfItem().soldiers.get(i) instanceof Catapult) {
                        this.getPlayerOfItem().soldiers.get(i).setLifePoints(this.getPlayerOfItem().soldiers.get(i).getLifePoints() + 1);
                        this.getPlayerOfItem().soldiers.get(i).setPower(this.getPlayerOfItem().soldiers.get(i).getPower() + 1);
                    }
                }
            } else {
                g.playerTurn--;
                throw new AgeofEmpiresException();
            }
        }
    }

}
