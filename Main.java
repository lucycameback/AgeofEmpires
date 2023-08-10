public class Main {
    public static void main(String[] args) throws AgeofEmpiresException{
        Game g = new Game(3); // iki kişilik oyun başlatır

        g.getMap().print();
        System.out.println(g.getPlayer(0).getGold());
        g.getPlayer(0).purchase(new Cavalry());
        g.getPlayer(1).purchase(new Cavalry());
        g.getPlayer(2).purchase(new Catapult());
        g.getPlayer(0).purchase(new Spearaman());
        g.getPlayer(1).purchase(new Archer());
        g.getPlayer(2).purchase(new Swordman());
        System.out.println(g.getPlayer(0).getWorker(0).getY()+" "+g.getPlayer(1).getWorker(0).getY() +" "+g.getPlayer(2).getWorker(0).getY());
        g.getPlayer(0).getWorker(0).move(1,4);
        g.getPlayer(1).getWorker(0).move(100,47);
        g.getPlayer(2).getWorker(0).move(1,47);
        g.getPlayer(0).getWorker(0).build(new University());
        g.getMap().print();
        System.out.println(g.getPlayer(2).getMainBuilding().print_message());
        for(int i=1;i<6;i++){
            g.getPlayer(1).getSoldier(0).move(100-9*i,50);
            g.getPlayer(2).getSoldier(0).move(1+i,50);
            g.getPlayer(0).getSoldier(0).move(1,1+9*i);
        }
        g.getMap().print();
        g.getPlayer(1).getSoldier(0).move(46,50);
        g.getMap().print();
        g.getPlayer(2).getWorker(0).attack(1,46);
        g.getMap().print();
        g.getPlayer(0).getSoldier(0).move(1,49);
        g.getPlayer(1).getWorker(0).build(new University());
        g.getPlayer(2).purchase(new Worker());
        System.out.println(g.getPlayer(0).getSoldier(0).getLifePoints() +" "+g.getPlayer(1).getSoldier(0).getLifePoints());
        g.getPlayer(0).getUniversity().trainCavalry();
        g.getPlayer(1).getUniversity().trainCavalry();
        g.getPlayer(2).purchase(new Cavalry());
        g.getPlayer(0).getSoldier(0).attack(1,50);
        g.getPlayer(1).getSoldier(0).move(37,50);
        g.getPlayer(2).getSoldier(2).move(9,50);
        g.getPlayer(0).getSoldier(0).attack(1,50);
        g.getPlayer(1).getSoldier(0).move(28,50);
        g.getPlayer(2).getSoldier(2).move(18,50);
        g.getPlayer(0).getSoldier(0).attack(1,50);
        g.getPlayer(1).getSoldier(0).move(19,50);
        g.getPlayer(2).getSoldier(2).attack(19,50);
        g.getPlayer(0).getSoldier(0).attack(1,50);
        g.getPlayer(1).getSoldier(0).attack(18,50);
        g.getPlayer(2).getSoldier(2).attack(19,50);
        g.getPlayer(0).getSoldier(0).attack(1,50);
        g.getMap().print();

        g.getPlayer(1).getSoldier(0).attack(18,50);
        System.out.println("****" + g.getPlayer(2).soldiers);
        g.getPlayer(2).getSoldier(1).attack(1,49);
        System.out.println(g.getPlayer(2).getMainBuilding().humans);
        g.getPlayer(0).getSoldier(0).attack(1,50);
        g.getPlayer(1).getSoldier(0).move(10,50);

        g.getPlayer(2).getSoldier(0).move(7,50);

        g.getPlayer(0).getSoldier(0).attack(1,50);
        g.getPlayer(1).getSoldier(0).move(2,50);

        g.getPlayer(2).getSoldier(0).move(8,50);
        g.getMap().print();
        System.out.println(g.getPlayer(2).soldiers);
        g.getPlayer(0).getSoldier(0).attack(1,50);
        g.getPlayer(1).getSoldier(0).attack(1,50);
        g.getPlayer(2).getWorker(0).attack(1,49);
       g.getPlayer(0).getSoldier(0).attack(1,50);
        for(int i=9; i<46; i+=9){
            g.getPlayer(1).getSoldier(0).move(2,50-i);
            g.getPlayer(0).getSoldier(0).move(1+i,49);
        }
        g.getPlayer(1).getSoldier(0).attack(1, 4);
        g.getPlayer(0).getSoldier(0).move(55, 49);
        g.getPlayer(1).getSoldier(0).attack(1, 4);
        g.getPlayer(0).getSoldier(0).move(64, 49);
        g.getPlayer(1).getSoldier(0).attack(1, 4);
        g.getPlayer(0).getSoldier(0).move(73, 49);
        g.getMap().print();
        System.out.println(g.getPlayer(1).getSoldier(0).print_message());
        g.getPlayer(1).getSoldier(0).attack(1, 4);
        g.getPlayer(0).getSoldier(0).move(82, 49);
        g.getPlayer(1).getSoldier(0).move(100, 49);
        g.getPlayer(0).getSoldier(0).move(91, 49);
        g.getPlayer(1).getSoldier(0).move(98, 49);
        g.getPlayer(0).getSoldier(0).move(99, 49);
        g.getPlayer(1).getSoldier(0).move(97, 49);
        g.getPlayer(0).getSoldier(0).attack(100, 50);
        g.getPlayer(1).getSoldier(0).move(96, 49);

        for(int i= 0;i<8;i++){
            g.getPlayer(0).getSoldier(0).attack(100, 50);
            g.getPlayer(1).getSoldier(0).move(95-i, 49);
        }

        g.getMap().print();
        System.out.println(g.getPlayer(1).getMainBuilding().getLifePoints());
        System.out.println(g.getPlayer(2));
        System.out.println(g.getPlayer(0).getSoldier(0).getLifePoints() +" "+g.getPlayer(1).getSoldier(0).getLifePoints());
        System.out.println(g.getPlayer(0).getSoldier(0).getPower() +" "+g.getPlayer(1).getSoldier(0).getPower());
        System.out.println(g.getPlayer(2).getSoldier(0).getX() +" "+g.getPlayer(2).getSoldier(0).getY());
       //
        //g.save_binary("SavedGame.txt");
        //Game g1 = new Game("SavedGame.txt",true);
       // g.getPlayer(1).getSoldier(0).move(100, 49);
        //g.getPlayer(0).getSoldier(0).move(91, 49);
        //g1.getMap().print();
       g.getPlayer(0).getSoldier(0).attack(100, 50);

        /*System.out.println(g1.getPlayer(1).soldiers);
        System.out.println(g1.getPlayer(2));
        System.out.println(g1.getPlayer(0).getSoldier(0).getLifePoints() +" "+g.getPlayer(1).getSoldier(0).getLifePoints());
        System.out.println(g1.getPlayer(0).getSoldier(0).getPower() +" "+g.getPlayer(1).getSoldier(0).getPower());
        System.out.println(g1.getPlayer(2).getSoldier(0).getX() +" "+g.getPlayer(2).getSoldier(0).getY());

        g1.save_text("SavedStringGame");*/
        /*g.getPlayer(0).getWorker(1).move(4,1);
        g.getPlayer(1).getWorker(0).move(99,48);
        g.getPlayer(0).getWorker(1).build(new University());
        g.getPlayer(1).getWorker(1).move(100,47);
        //System.out.println(g.getPlayer(0).soldiers);
        //System.out.println(g.getPlayer(0).getUniversity().getSymbol());
        System.out.println("**************************");
        g.getMap().print();
        System.out.println("**************************");
        //System.out.println(g.getPlayer(1).getMainBuilding().humans);
        g.getPlayer(0).getWorker(1).move(7,1);
        g.getPlayer(1).getWorker(0).move(99,45);
       // g.getMap().print();
        System.out.println("**************************");
        g.getPlayer(0).getWorker(1).move(10,1);
        g.getPlayer(1).getWorker(0).move(99,42);
        g.getPlayer(0).getWorker(1).move(13,1);
        g.getPlayer(1).getWorker(0).move(99,39);
        g.getPlayer(0).getWorker(1).move(16,1);
        g.getPlayer(1).getWorker(0).move(99,36);
        g.getPlayer(0).getWorker(1).move(19,1);
        g.getPlayer(1).getWorker(0).move(99,33);
        g.getPlayer(0).getWorker(1).move(22,1);
        g.getPlayer(1).getWorker(0).move(99,30);
        g.getPlayer(0).getWorker(1).move(25,1);
        g.getPlayer(1).getWorker(0).move(99,27);
        g.getPlayer(0).getWorker(1).move(27,2);
        g.getPlayer(1).getWorker(0).move(98,25);
        g.getPlayer(0).getWorker(1).move(29,3);
        g.getPlayer(1).getWorker(0).move(97,23);
        //g.getMap().print();
        g.getPlayer(0).getWorker(1).move(32,3);
        g.getPlayer(1).getWorker(0).move(97,20);
        g.getPlayer(0).getWorker(1).move(35,3);
        g.getPlayer(1).getWorker(0).move(96,18);
        g.getPlayer(0).getWorker(1).move(38,3);
        g.getPlayer(1).getWorker(0).move(95,16);
        g.getPlayer(0).getWorker(1).move(41,3);
        g.getPlayer(1).getWorker(0).move(94,14);
        g.getPlayer(0).getWorker(1).move(44,3);
        g.getPlayer(1).getWorker(0).move(93,12);
        g.getPlayer(0).getWorker(1).move(46,4);
        g.getPlayer(1).getWorker(0).move(92,10);
        g.getPlayer(0).getWorker(1).move(48,5);
        g.getPlayer(1).getWorker(0).move(91,8);
        g.getPlayer(0).getWorker(1).move(50,6);
        g.getPlayer(1).getWorker(0).move(90,6);
        g.getPlayer(0).getWorker(1).move(53,6);
        g.getPlayer(1).getWorker(0).move(87,6);
        g.getPlayer(0).getWorker(1).move(56,6);
        g.getPlayer(1).getWorker(0).move(84,6);
        g.getPlayer(0).getWorker(1).move(59,6);
        g.getPlayer(1).getWorker(0).move(81,6);
        g.getPlayer(0).getWorker(1).move(62,6);
        g.getPlayer(1).getWorker(0).move(78,6);
        g.getPlayer(0).getWorker(1).move(65,6);
        g.getPlayer(1).getWorker(0).move(75,6);
        g.getPlayer(0).getWorker(1).move(68,6);
        g.getPlayer(1).getWorker(0).move(72,6);
        g.getPlayer(0).getWorker(1).move(71,6);
        try{
            g.getPlayer(0).purchase(new Cavalry());
        }catch (AgeofEmpiresException e){

        }
        System.out.println(g.getPlayer(1).getWorker(0).getLifePoints());
        g.getPlayer(1).getWorker(0).attack(71,6);

        System.out.println("**************************");
        g.getMap().print();
        System.out.println(g.getPlayer(1).getWorker(0).getLifePoints());
        System.out.println(g.getPlayer(0).getWorker(1).getLifePoints());
        g.getPlayer(0).getWorker(1).build(new Tower());
        System.out.println("**************************");
        g.getMap().print();
        try {
            g.getPlayer(1).getWorker(0).attack(72, 6);
        }catch (AgeofEmpiresException e){

        }
        g.getPlayer(1).getWorker(0).attack(71,6);
        System.out.println("**************************");
        g.getMap().print();
        g.getPlayer(0).purchase(new Archer());
        g.getPlayer(1).purchase(new Archer());
        System.out.println("**************************");
        g.getMap().print();

        g.getPlayer(0).getSoldier(1).move(3,1);
        g.getPlayer(1).getSoldier(1).move(100,48);
        g.getPlayer(0).getSoldier(1).move(5,1);
        g.getPlayer(1).getSoldier(1).move(100,46);
        g.getPlayer(0).getSoldier(1).move(7,1);
        g.getPlayer(1).getSoldier(1).move(100,44);
        g.getPlayer(0).getSoldier(1).move(9, 1);
        g.getPlayer(1).getSoldier(1).move(100, 42);
        g.getPlayer(0).getSoldier(1).move(11, 1);
        g.getPlayer(1).getSoldier(1).move(100, 40);
        g.getPlayer(0).getSoldier(1).move(13, 1);
        g.getPlayer(1).getSoldier(1).move(100, 38);
        g.getPlayer(0).getSoldier(1).move(15, 1);

        g.getPlayer(1).getSoldier(1).move(100, 36);

        g.getPlayer(0).getSoldier(1).move(17, 1);

        g.getPlayer(1).getSoldier(1).move(100, 34);

        g.getPlayer(0).getSoldier(1).move(19, 1);

        g.getPlayer(1).getSoldier(1).move(100, 32);

        g.getPlayer(0).getSoldier(1).move(21, 1);
        g.getPlayer(1).getSoldier(1).move(100, 30);
        g.getPlayer(0).getSoldier(1).move(23, 1);
        g.getPlayer(1).getSoldier(1).move(100, 28);
        g.getPlayer(0).getSoldier(1).move(25, 1);
        g.getPlayer(1).getSoldier(1).move(100, 26);
        System.out.println("**************************");
        g.getMap().print();
        g.getPlayer(0).getSoldier(1).move(27, 1);
        g.getPlayer(1).getSoldier(1).move(100, 24);
        g.getPlayer(0).getSoldier(1).move(29, 1);
        g.getPlayer(1).getSoldier(1).move(100, 22);
        g.getPlayer(0).getSoldier(1).move(31, 1);
        g.getPlayer(1).getSoldier(1).move(100, 20);
        g.getPlayer(0).getSoldier(1).move(33, 1);
        g.getPlayer(1).getSoldier(1).move(100, 18);
        g.getPlayer(0).getSoldier(1).move(35, 1);
        g.getPlayer(1).getSoldier(1).move(100, 16);
        g.getPlayer(0).getSoldier(1).move(37, 1);
        g.getPlayer(1).getSoldier(1).move(100, 14);
        g.getPlayer(0).getSoldier(1).move(39, 1);
        g.getPlayer(1).getSoldier(1).move(100, 12);
        g.getPlayer(0).getSoldier(1).move(41, 1);
        g.getPlayer(1).getSoldier(1).move(100, 10);
        g.getPlayer(0).getSoldier(1).move(43, 1);
        g.getPlayer(1).getSoldier(1).move(100, 8);
        g.getPlayer(0).getSoldier(1).move(45, 1);
        g.getPlayer(1).getSoldier(1).move(100, 6);
        g.getPlayer(0).getSoldier(1).move(47, 1);
        g.getPlayer(1).getSoldier(1).move(100, 4);
        g.getPlayer(0).getSoldier(1).move(49, 1);
        g.getPlayer(1).getSoldier(1).move(100, 2);
        g.getPlayer(0).getSoldier(1).move(51, 1);
        g.getPlayer(1).getSoldier(1).move(98, 2);
        g.getPlayer(0).getSoldier(1).move(53, 1);
        g.getPlayer(1).getSoldier(1).move(96, 2);
        g.getPlayer(0).getSoldier(1).move(55, 1);
        g.getPlayer(1).getSoldier(1).move(94, 2);
        g.getPlayer(0).getSoldier(1).move(57, 1);
        g.getPlayer(1).getSoldier(1).move(92, 2);
        g.getPlayer(0).getSoldier(1).move(59, 1);
        g.getPlayer(1).getSoldier(1).move(90, 2);
        g.getPlayer(0).getSoldier(1).move(61, 1);
        g.getPlayer(1).getSoldier(1).move(88, 2);
        g.getPlayer(0).getSoldier(1).move(63, 1);
        g.getPlayer(1).getSoldier(1).move(86, 2);
        g.getPlayer(0).getSoldier(1).move(65, 1);
        g.getPlayer(1).getSoldier(1).move(84, 2);
        g.getPlayer(0).getSoldier(1).move(67, 1);
        g.getPlayer(1).getSoldier(1).move(82, 2);
        g.getPlayer(0).getSoldier(1).move(69, 1);
        g.getPlayer(1).getSoldier(1).move(80, 2);
        g.getPlayer(0).getSoldier(1).move(71, 1);
        g.getPlayer(1).getSoldier(1).move(78, 2);
        g.getPlayer(0).getSoldier(1).move(73, 1);
        g.getPlayer(1).getSoldier(1).move(76, 2);
        g.getPlayer(0).getSoldier(1).move(75, 1);
        //g.getPlayer(1).getSoldier(1).attack(76, 2);
        System.out.println("**************************");
        g.getMap().print();
        System.out.println(g.getPlayer(1).getWorker(1).getX() +" "+ g.getPlayer(1).getWorker(0).getY());
        System.out.println(g.getPlayer(0).getWorker(0).getX() +" "+ g.getPlayer(0).getWorker(0).getY());
        System.out.println(g.getPlayer(0).getTower(0).getX() + " "+ g.getPlayer(0).getTower(0).getY()  );


         */
    }


}