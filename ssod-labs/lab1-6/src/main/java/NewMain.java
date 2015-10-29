import by.brest.ssod.lab1.Train;
import by.brest.ssod.lab1.Way;
import lab3.Rule;
import lab3.RuleType;

import java.util.ArrayList;
import java.util.List;

import static lab3.Main.*;
/**
 * Created by kirill-good on 29.10.15.
 */
public class NewMain {
    public static void main(String[] args){
        Way way = new Way();
        way.getTrainList().add(new NewTrain(0,20,0,"A","0xFF0000",10));
        way.getTrainList().add(new NewTrain(250,20,0,"B","0x0000FF",7));
        try {
            way.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class NewTrain extends Train{

    private List<Rule> rules = new ArrayList();
    private int a = 5;
    public NewTrain(int location, int speed, int trainBreak, String title, String color,int a) {
        super(location, speed, trainBreak, title, color);
        this.a = a;
        rules.add(new Rule(speedVeryFast, distVeryShort, breakVeryStrong, RuleType.AND));
        rules.add(new Rule(speedVeryFast, distShort, breakVeryStrong, RuleType.AND));
        rules.add(new Rule(speedVeryFast, distLong, breakStrong, RuleType.AND));
        rules.add(new Rule(speedVeryFast, distVeryLong, breakMid, RuleType.AND));

        rules.add(new Rule(speedFast, distVeryShort, breakVeryStrong, RuleType.AND));
        rules.add(new Rule(speedFast, distShort, breakStrong, RuleType.AND));
        rules.add(new Rule(speedFast, distMid, breakMid, RuleType.AND));
        rules.add(new Rule(speedFast, distLong, breakMid, RuleType.AND));
        rules.add(new Rule(speedFast, distVeryLong, breakLittle, RuleType.AND));

        rules.add(new Rule(speedMid, distVeryLong, breakMid, RuleType.AND));
        rules.add(new Rule(speedMid, distMid, breakMid, RuleType.AND));
        rules.add(new Rule(speedMid, distLong, breakLittle, RuleType.AND));
        rules.add(new Rule(speedMid, distVeryShort, breakMid, RuleType.AND));

        rules.add(new Rule(speedSlow, distLong, breakLittle, RuleType.AND));
        rules.add(new Rule(speedSlow, distMid, breakLittle, RuleType.AND));

        rules.add(new Rule(speedVerySlow, distLong, breakVeryLittle, RuleType.AND));
        rules.add(new Rule(speedVerySlow, distShort, breakLittle, RuleType.AND));
        rules.add(new Rule(speedVerySlow, distVeryShort, breakMid, RuleType.AND));


    }

    @Override
    public void tick() {
        double x = 0;
        double sum = 0;
        for (int j = 0; j < 10; j++) {
            double maxM = Double.NEGATIVE_INFINITY;
            for (Rule rule: rules){
                double m1 = rule.getM1(speed);
                double m2 = rule.getM2(this.getDistToNextTrain());
                double m3 = rule.getM3(j);
                double m = rule.getM(speed,this.getDistToNextTrain(),j);
                if(m>maxM){
                    maxM = m;
                }
            }
            x += j * maxM;
            sum += maxM;
        }
        x /= sum;
        System.out.println(this.getDistToNextTrain() + " " + speed + " " + trainBreak);
        trainBreak = (int) x;

        location = (location + speed + 1000)%1000;
        speed = speed + random.nextInt(a) - trainBreak;
        if(speed<0){
            speed = 0;
        }
    }
}