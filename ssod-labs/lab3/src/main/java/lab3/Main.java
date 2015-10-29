package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kirill on 25.9.15.
 */
public class Main {
    public static Function speedVerySlow = new Function(
            0,1,
            5,1,
            15,0,"verySlow");
    public static Function speedSlow = new Function(
            5,0,
            15,1,
            25,0,"slow");
    public static Function speedMid = new Function(
            15,0,
            25,1,
            35,0,"midSpeed");
    public static Function speedFast = new Function(
            25,1,
            35,1,
            45,0,"fast");
    public static Function speedVeryFast = new Function(
            35,0,
            45,1,
            55,1,"veryFast");


    public static Function distVeryShort = new Function(
            0,1,
            50,1,
            100,0,"veryShort");
    public static Function distShort = new Function(
            50,0,
            100,1,
            300,0,"short");
    public static Function distMid = new Function(
            100,0,
            300,1,
            500,0,"midDist");
    public static Function distLong = new Function(
            300,0,
            500,1,
            700,0,"long");
    public static Function distVeryLong = new Function(
            500,0,
            700,1,
            1000,1,"veryLong");


    public static Function breakVeryLittle = new Function(
            -1,1,
            1,1,
            2.5,0,"veryLittle");
    public static Function breakLittle = new Function(
            0,0,
            2.5,1,
            5,0,"Little");
    public static Function breakMid = new Function(
            2.5,0,
            5,1,
            7.5,0,"midBreak");
    public static Function breakStrong = new Function(
            5,0,
            7.5,1,
            10,0,"strong");
    public static Function breakVeryStrong = new Function(
            10,0,
            12.5,1,
            15,1,"veryStrong");

    public static Rule rule11 = new Rule(speedVeryFast,distVeryShort,breakVeryStrong,RuleType.AND);
    public static Rule rule12 = new Rule(speedVeryFast,distShort,breakVeryStrong,RuleType.AND);
    public static Rule rule13 = new Rule(speedVeryFast,distMid,breakStrong,RuleType.AND);
    public static Rule rule14 = new Rule(speedVeryFast,distLong,breakMid,RuleType.AND);
    public static Rule rule15 = new Rule(speedVeryFast,distVeryLong,breakLittle,RuleType.AND);

    public static Rule rule21 = new Rule(speedVerySlow,distVeryShort,breakLittle,RuleType.AND);
    public static Rule rule22 = new Rule(speedVerySlow,distShort,breakLittle,RuleType.AND);
    public static Rule rule23 = new Rule(speedVerySlow,distMid,breakLittle,RuleType.AND);
    public static Rule rule24 = new Rule(speedVerySlow,distLong,breakVeryLittle,RuleType.AND);
    public static Rule rule25 = new Rule(speedVerySlow,distVeryLong,breakVeryLittle,RuleType.AND);

    public static Rule rule31 = new Rule(speedSlow,distVeryShort,breakMid,RuleType.AND);
    public static Rule rule32 = new Rule(speedSlow,distShort,breakMid,RuleType.AND);
    public static Rule rule33 = new Rule(speedSlow,distMid,breakMid,RuleType.AND);
    public static Rule rule34 = new Rule(speedSlow,distLong,breakLittle,RuleType.AND);
    public static Rule rule35 = new Rule(speedSlow,distVeryLong,breakVeryLittle,RuleType.AND);

    public static Rule rule41 = new Rule(speedMid,distVeryShort,breakStrong,RuleType.AND);
    public static Rule rule42 = new Rule(speedMid,distShort,breakStrong,RuleType.AND);
    public static Rule rule43 = new Rule(speedMid,distMid,breakMid,RuleType.AND);
    public static Rule rule44 = new Rule(speedMid,distLong,breakVeryLittle,RuleType.AND);
    public static Rule rule45 = new Rule(speedMid,distVeryLong,breakVeryLittle,RuleType.AND);

    public static Rule rule51 = new Rule(speedFast,distVeryShort,breakStrong,RuleType.AND);
    public static Rule rule52 = new Rule(speedFast,distShort,breakStrong,RuleType.AND);
    public static Rule rule53 = new Rule(speedFast,distMid,breakMid,RuleType.AND);
    public static Rule rule54 = new Rule(speedFast,distLong,breakMid,RuleType.AND);
    public static Rule rule55 = new Rule(speedFast,distVeryLong,breakLittle,RuleType.AND);

    public static void main(String[] args) throws FileNotFoundException {


        double distance = 220;
        List<Rule> rules1 = new ArrayList();
        rules1.add(new Rule(speedVeryFast,distVeryShort,breakVeryStrong,RuleType.AND));
        rules1.add(new Rule(speedVeryFast,distShort,breakVeryStrong,RuleType.AND));
        rules1.add(new Rule(speedVeryFast,distLong,breakStrong,RuleType.AND));
        rules1.add(new Rule(speedVeryFast,distVeryLong,breakMid,RuleType.AND));

        rules1.add(new Rule(speedFast,distVeryShort,breakVeryStrong,RuleType.AND));
        rules1.add(new Rule(speedFast,distShort,breakStrong,RuleType.AND));
        rules1.add(new Rule(speedFast,distMid,breakMid,RuleType.AND));
        rules1.add(new Rule(speedFast,distLong,breakMid,RuleType.AND));
        rules1.add(new Rule(speedFast,distVeryLong,breakLittle,RuleType.AND));

        rules1.add(new Rule(speedMid,distVeryLong,breakMid,RuleType.AND));
        rules1.add(new Rule(speedMid,distMid,breakMid,RuleType.AND));
        rules1.add(new Rule(speedMid,distLong,breakLittle,RuleType.AND));
        rules1.add(new Rule(speedMid,distVeryShort,breakMid,RuleType.AND));

        rules1.add(new Rule(speedSlow,distLong,breakLittle,RuleType.AND));
        rules1.add(new Rule(speedSlow,distMid,breakLittle,RuleType.AND));

        rules1.add(new Rule(speedVerySlow,distLong,breakVeryLittle,RuleType.AND));
        rules1.add(new Rule(speedVerySlow,distShort,breakLittle,RuleType.AND));
        rules1.add(new Rule(speedVerySlow,distVeryShort,breakMid,RuleType.AND));

        List<Rule> rules2 = new ArrayList();
        rules2.add(new Rule(speedVerySlow,distVeryLong,breakVeryLittle,RuleType.AND));
        rules2.add(new Rule(speedVeryFast,distVeryLong,breakMid,RuleType.AND));
        rules2.add(new Rule(speedVeryFast,distVeryShort,breakVeryStrong,RuleType.AND));
        rules2.add(new Rule(speedMid,distMid,distMid,RuleType.AND));
        rules2.add(new Rule(speedVerySlow,distVeryShort, breakStrong,RuleType.AND));

        rules2.add(new Rule(speedFast,distVeryShort, breakVeryStrong,RuleType.AND));
        rules2.add(new Rule(speedFast,distMid,breakStrong,RuleType.AND));
        rules2.add(new Rule(speedFast,distLong,breakMid,RuleType.AND));
        rules2.add(new Rule(speedFast,distVeryLong,breakMid,RuleType.AND));
        rules2.add(new Rule(speedSlow,distMid,breakLittle,RuleType.AND));

        PrintWriter pw1 = new PrintWriter(new File("out1.txt"));
        PrintWriter pw2 = new PrintWriter(new File("out2.txt"));
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            String line1 = printInFile(100*i, rules1, pw1);
            String line2 = printInFile(100*i, rules2, pw2);
            sb1.append(line1);
            sb2.append(line2);
        }
        pw1.println("\n" + sb1.toString());
        pw2.println("\n" + sb2.toString());

        pw1.flush();
        pw1.close();
        pw2.flush();
        pw2.close();
    }

    private static String printInFile(double distance, List<Rule> rules, PrintWriter pw) {
        for(Rule rule: rules) {
            pw.print(rule.toString() + " \n");
        }
        StringBuilder line = new StringBuilder();
        for (int i = 0; i <= 60; i+=5) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Speed ");
            stringBuilder.append("distance ");
            stringBuilder.append("break ");
            stringBuilder.append("max ");
            stringBuilder.append("final_brake \n");
            double speed = i;
            double x = 0;
            double sum = 0;
            for (int j = 0; j < 10; j++) {
                stringBuilder.append(speed + " ");
                stringBuilder.append(distance + " ");
                stringBuilder.append(j + " ");
                double maxM = Double.NEGATIVE_INFINITY;
                for (Rule rule: rules){
                    double m1 = rule.getM1(speed);
                    double m2 = rule.getM2(distance);
                    double m3 = rule.getM3(j);
                    double m = rule.getM(speed,distance,j);
                    if(m>maxM){
                        maxM = m;
                    }
                }
                x += j * maxM;
                sum += maxM;
                stringBuilder.append(String.format("%.2f",maxM) + " \n");
            }
            x /= sum;
            stringBuilder.append("final_brake: " + String.format("%.2f",x)+"\n");
            line.append(String.format("%.2f",Double.isNaN(x)?0:x)+" ");
            if(x>0.01){
                pw.print(stringBuilder.toString().replace('.', ','));
            }
        }
        line.append("\n");
        return line.toString().replace('.',',');
    }
}
