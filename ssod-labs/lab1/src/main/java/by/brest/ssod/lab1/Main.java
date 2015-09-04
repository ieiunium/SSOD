package by.brest.ssod.lab1;

import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by kirill on 4.9.15.
 */
public class Main {
    public static final Logger log = Logger.getLogger(Main.class.toString());
    public static void main(String[] args){
        Way way = new Way();
        way.getTrainList().add(new Train(300,20,0,"A","0xFF0000"));
        way.getTrainList().add(new Train(500,20,0,"B","0x0000FF"));
        try {
            way.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
