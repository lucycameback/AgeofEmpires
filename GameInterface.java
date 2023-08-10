public interface GameInterface {
    Player getPlayer(int x) throws AgeofEmpiresException;

    Map getMap();

    void save_text(String filename);


    void save_binary(String filename);
}
