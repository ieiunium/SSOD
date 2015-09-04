package by.brest.ssod.lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by kirill on 4.9.15.
 */
public class Way {
    public static final Logger log = Logger.getLogger(Way.class.toString());

    private Train rails[] = new Train[1000];
    private List<Train> trainList = new ArrayList();

    public Way(){
        for (int i = 0; i < rails.length; i++) {
            rails[i] = null;
        }
    }

    public void tick() throws Exception {
        for(Train i: trainList){
            int x1 = i.getLocation();
            int inc = i.getSpeed()/Math.abs(i.getSpeed());
            rails[x1] = null;
            i.tick();
            int x2 = i.getLocation();
            for (int j = x1; j != x2; j = (j + inc)%1000 ) {
                if(rails[j]!=null){
                    i.setLocation(j);
                    throw new Exception("Crash!");
                }
            }
            rails[x2] = i;
        }
    }

    public void start(){
        Painter painter = new Painter();
        painter.setVisible(true);
        painter.setWay(this);
        try{
            for(;;){
                tick();
                painter.update(painter.getGraphics());
                Thread.sleep(500);
            }
        }catch (Exception ex){
            log.info(ex.toString());
        }
    }

    public List<Train> getTrainList() {
        return trainList;
    }

    public void setTrainList(List<Train> trainList) {
        this.trainList = trainList;
    }
}
