package by.brest.ssod.lab1;

import java.util.Random;

/**
 * Created by kirill on 4.9.15.
 */
public class Train {
    private int location;
    private int speed;
    private int trainBreak;
    private String title;
    private String color;
    private int distToNextTrain;

    private final static Random random = new Random();

    public Train(int location, int speed, int trainBreak, String title,String color) {
        this.location = location;
        this.speed = speed;
        this.trainBreak = trainBreak;
        this.title = title;
        this.color = color;
    }

    public void tick(){
        location = (location + speed)%1000;
        speed = speed + random.nextInt(5)-2;
        //speed = speed - trainBreak;
    }

    @Override
    public String toString() {
        return "Train{" +
                "location=" + location +
                ", speed=" + speed +
                ", trainBreak=" + trainBreak +
                ", title='" + title + '\'' +
                ", color='" + color + '\'' +
                ", distToNextTrain=" + distToNextTrain +
                '}';
    }

    public int getDistToNextTrain() {
        return distToNextTrain;
    }

    public void setDistToNextTrain(int distToNextTrain) {
        this.distToNextTrain = distToNextTrain;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTrainBreak() {
        return trainBreak;
    }

    public void setTrainBreak(int trainBreak) {
        this.trainBreak = trainBreak;
    }
}
