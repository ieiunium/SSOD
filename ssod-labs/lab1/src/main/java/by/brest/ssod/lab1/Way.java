package by.brest.ssod.lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    private volatile boolean crash = false;

    public Way(){
        for (int i = 0; i < rails.length; i++) {
            rails[i] = null;
        }
    }

    public void tick() throws Exception {
        for(Train i: trainList){
            int x1 = i.getLocation();
            int inc;
            try {
                inc = i.getSpeed() / Math.abs(i.getSpeed());
            }catch (ArithmeticException ex){
                inc = 1;
            }
            rails[x1] = null;
            i.tick();
            int x2 = i.getLocation();
            for (int j = x1; j != x2; j = (j + inc+1000)%1000 ) {
                if(rails[j]!=null){
                    i.setLocation(j);
                    crash = true;
                    throw new Exception("Crash!");
                }
            }
            rails[x2] = i;
        }
        int sum = 0;
        for (int i = 0; i < trainList.size(); i++) {
            int dist;
            if(trainList.get(i).getSpeed()>=0){
                dist = trainList.get((i+1)%trainList.size()).getLocation() -
                        trainList.get(i).getLocation();
            }else{
                dist = trainList.get(i).getLocation() -
                        trainList.get((i-1+trainList.size())%trainList.size()).getLocation();
            }
            if(dist<0){
                dist += 1000;
            }
            sum += dist;
            trainList.get(i).setDistToNextTrain(dist);
        }
        //log.info("sum: "+sum);
    }

    public void start(){
        Painter painter = new Painter();
        painter.setVisible(true);
        painter.setWay(this);
        int ms = 300;
        painter.start(ms);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        log.info("get ready");
        try {
            br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            for(;;){
                tick();
                //painter.update(painter.getGraphics());
                Thread.sleep(ms);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public List<Train> getTrainList() {
        return trainList;
    }

    public void setTrainList(List<Train> trainList) {
        this.trainList = trainList;
    }

    public boolean isCrash() {
        return crash;
    }
}
