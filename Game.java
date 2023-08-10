import java.io.*;


public class Game implements GameInterface, Serializable {

    protected Player[] players;
    protected int numberOfPlayers;
    private Map map;
    protected int playerTurn =0;

    public Game(int numberOfPlayers) throws AgeofEmpiresException {
        if( numberOfPlayers >= 2 && numberOfPlayers <= 4 ) {
            this.numberOfPlayers = numberOfPlayers;
            players = new Player[numberOfPlayers];
            map = new Map();

            for (int i = 0; i < numberOfPlayers; i++) {
                players[i] = new Player(this);
                players[i].workers.add(new Worker());
                players[i].getWorker(0).gameToItem(this);
                players[i].getWorker(0).playerOfItem(players[i]);
            }
            placeMainBuilding();

        }else{
            throw new AgeofEmpiresException();
        }
    }
    public Game(String fileName, boolean isBinary) {
        if (isBinary) {
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
                Game game = (Game) in.readObject();
                in.close();

                this.players = game.players;
                this.numberOfPlayers = game.numberOfPlayers;
                this.map = game.map;
                this.playerTurn = game.playerTurn;
                for (int i=0; i<numberOfPlayers;i++) {
                    this.getPlayer(i).workers = game.getPlayer(i).workers;
                    this.getPlayer(i).soldiers=game.getPlayer(i).soldiers;
                    this.getPlayer(i).towers= game.getPlayer(i).towers;
                    this.getPlayer(i).g=game.getPlayer(i).g;

                    for(int j=0; i<game.getPlayer(i).getSoldierCount();j++) {
                        this.getPlayer(i).getSoldier(j).setPower(game.getPlayer(i).getSoldier(j).getPower());
                        this.getPlayer(i).getSoldier(j).setLifePoints((game.getPlayer(i).getSoldier(j).getLifePoints()));
                        this.getPlayer(i).getSoldier(j).g = game.getPlayer(i).getSoldier(j).g;
                        this.getPlayer(i).getSoldier(j).x= game.getPlayer(i).getSoldier(j).getX();
                        this.getPlayer(i).getSoldier(j).y= game.getPlayer(i).getSoldier(j).getY();
                    }

                    for(int j=0; j<game.getPlayer(i).getWorkerCount();j++) {
                        this.getPlayer(i).getWorker(j).setLifePoints((game.getPlayer(i).getWorker(j).getLifePoints()));
                        this.getPlayer(i).getWorker(j).g = game.getPlayer(i).getWorker(j).g;
                        this.getPlayer(i).getWorker(j).x= game.getPlayer(i).getWorker(j).getX();
                        this.getPlayer(i).getWorker(j).y= game.getPlayer(i).getWorker(j).getY();
                    }
                    for(int j=0; j<game.getPlayer(i).towers.size();j++) {
                        this.getPlayer(i).getTower(j).setLifePoints((game.getPlayer(i).getTower(j).getLifePoints()));
                        this.getPlayer(i).getTower(j).g = game.getPlayer(i).getTower(j).g;
                        this.getPlayer(i).getTower(j).x= game.getPlayer(i).getTower(j).getX();
                        this.getPlayer(i).getTower(j).y= game.getPlayer(i).getTower(j).getY();
                        this.getPlayer(i).getTower(j).worker=game.getPlayer(i).getTower(j).worker;

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            try {
                BufferedReader in = new BufferedReader(new FileReader(fileName));
                in.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public void save_text(String filename) {

        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(filename));
            out.println();
            out.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void save_binary(String filename) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(this);
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }



    @Override
    public Player getPlayer(int x){
        if(players[x]!= null) {
            this.player = x;
            return players[x];
        }else return null;
    }
    public boolean turn() throws AgeofEmpiresException{
        if ((playerTurn % numberOfPlayers) == player) {
            while(players[((playerTurn%numberOfPlayers)+1)%numberOfPlayers].getMainBuilding() == null) {
                playerTurn++;
            }
            playerTurn++;
            players[player].setWood(players[player].getWood() + 10);
            players[player].setStone(players[player].getStone() + 5);
            players[player].setGold(players[player].getGold() + 2);
            return true;
        } else {
            throw new AgeofEmpiresException();
        }
    }
    int player;
    @Override
    public Map getMap() {
        return map;
    }
    private void placeMainBuilding(){
        int x=0 ,y=0;
        for(int i=0; i<numberOfPlayers; i++){
            if(i==0){
                x=1;
                y=1;
            }if(i==1){
                x=100;
                y=50;
            }if(i==2){
                x=1;
                y=50;
            }if(i==3){
                x=100;
                y=1;
            }
            players[i].getMainBuilding().humans.add(players[i].getWorker(0));
            players[i].getMainBuilding().x=x;
            players[i].getMainBuilding().y=y;
            players[i].getWorker(0).x=x;
            players[i].getWorker(0).y=y;
            updateMap(x ,y,players[i].getMainBuilding());
        }
    }
    public void updateMap (int x, int y, Item i) {
        try {
            if (map.itemStatus[y-1][x-1] == null){
                map.itemStatus[y-1][x-1] = i;
                if ((i instanceof Human) &&(map.itemStatus[i.getY()-1][i.getX()-1] instanceof MainBuilding)) {
                    i.getPlayerOfItem().getMainBuilding().humans.remove(i);
                }else if ((i instanceof Worker) && (map.itemStatus[i.getY()-1][i.getX()-1] instanceof Building) && !(map.itemStatus[i.getY()-1][i.getX()-1] instanceof MainBuilding)){
                    ((Building) map.itemStatus[i.getY()-1][i.getX()-1]).worker = null;
                }else if(!(i instanceof MainBuilding)){
                    map.itemStatus[i.getY()-1][i.getX()-1] = null;
                }
            }else if((map.itemStatus[y-1][x-1] instanceof Worker) && (i instanceof Building) && !(i instanceof MainBuilding)){
                map.itemStatus[y-1][x-1] = i;
            } else {
                throw new AgeofEmpiresException();
            }
        }catch (AgeofEmpiresException e){
            e.printStackTrace();
        }
    }
    public void isGameEnded(){
        int countDefeated=0;
        for(int i = 0; i<numberOfPlayers; i++){
            if(players[i].getMainBuilding()==null ){
                countDefeated++;
                if(countDefeated==numberOfPlayers-1){
                    System.out.println("Game over!");
                }
            }
        }
    }


}
