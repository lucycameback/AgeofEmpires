import java.io.Serializable;

public class Map implements MapInterface , Serializable {
    String[][] status = new String[50][100];
    Item[][] itemStatus = new Item[50][100];

    public Map (){
    }
    public void status(){
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 100; j++) {
                if(itemStatus[i][j] == null){
                    status[i][j] = "_";
                }else{
                    status[i][j] = itemStatus[i][j].getSymbol();
                }
            }
        }
    }

    public void print() {
        status();
         for (int i = 0; i < 50; i++) {
             for (int j = 0; j < 100; j++) {
                 System.out.print(status[i][j] + " ");
             }
             System.out.println();
         }
    }

}
