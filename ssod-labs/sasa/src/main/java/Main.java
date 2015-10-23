import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kirill on 23.10.15.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MemberShipFunction small = new MemberShipFunction(0,0.2);
        MemberShipFunction medium = new MemberShipFunction(0.5,0.3);
        MemberShipFunction large = new MemberShipFunction(1.0,0.2);
        //paint("1.png",new MemberShipFunction[]{small,medium,large});
        double[][] data = new double[75][5];
        try {
            Scanner scanner = new Scanner(new File("1.txt"));
            for (int i = 0; i < data.length; i++) {
                String[] line = scanner.nextLine().split(" ");
                for (int j = 0; j < data[i].length; j++) {
                    data[i][j] = Double.parseDouble(line[j]);
                }
                //System.out.println(Arrays.toString(data[i]));
            }
        }catch (Throwable ex){

        }

        f2(small, medium, large, data);
        //f2(small, medium, large, data);
    }

    private static void f1(MemberShipFunction small, MemberShipFunction medium, MemberShipFunction large, double[][] data) {
        List<Rule> ruleList1 = new ArrayList<>();
        List<Rule> ruleList2 = new ArrayList<>();
        List<Rule> ruleList3 = new ArrayList<>();

        ruleList1.add(new Rule(new MemberShipFunction[]{medium,large,small,small},0.9));
        ruleList2.add(new Rule(new MemberShipFunction[]{medium,large,small,small},0.05));
        ruleList3.add(new Rule(new MemberShipFunction[]{medium,large,small,small},0.05));

        ruleList1.add(new Rule(new MemberShipFunction[]{small,small,small,small},0.9));
        ruleList2.add(new Rule(new MemberShipFunction[]{small,small,small,small},0.05));
        ruleList3.add(new Rule(new MemberShipFunction[]{small,small,small,small},0.05));

        ruleList1.add(new Rule(new MemberShipFunction[]{medium,small,medium,small},0.9));
        ruleList2.add(new Rule(new MemberShipFunction[]{medium,small,medium,small},0.05));
        ruleList3.add(new Rule(new MemberShipFunction[]{medium,small,medium,small},0.05));

        ruleList1.add(new Rule(new MemberShipFunction[]{large,medium,medium,medium},0.05));
        ruleList2.add(new Rule(new MemberShipFunction[]{large,medium,medium,medium},0.50));
        ruleList3.add(new Rule(new MemberShipFunction[]{large,medium,medium,medium},0.45));

        ruleList1.add(new Rule(new MemberShipFunction[]{large,medium,large,large},0.01));
        ruleList2.add(new Rule(new MemberShipFunction[]{large,medium,large,large},0.29));
        ruleList3.add(new Rule(new MemberShipFunction[]{large,medium,large,large},0.7));

        ruleList1.add(new Rule(new MemberShipFunction[]{large,large,large,large},0.001));
        ruleList2.add(new Rule(new MemberShipFunction[]{large,large,large,large},0.001));
        ruleList3.add(new Rule(new MemberShipFunction[]{large,large,large,large},0.998));

        Rules rules1 = new Rules(ruleList1);
        Rules rules2 = new Rules(ruleList2);
        Rules rules3 = new Rules(ruleList3);
        doIt(rules1,rules2,rules3,data);
    }
    private static void f2(MemberShipFunction small, MemberShipFunction medium, MemberShipFunction large, double[][] data) {
        List<Rule> ruleList1 = new ArrayList<>();
        List<Rule> ruleList2 = new ArrayList<>();
        List<Rule> ruleList3 = new ArrayList<>();

        ruleList1.add(new Rule(new MemberShipFunction[]{medium,large,small,small},0.7));
        ruleList2.add(new Rule(new MemberShipFunction[]{medium,large,small,small},0.2));
        ruleList3.add(new Rule(new MemberShipFunction[]{medium,large,small,small},0.1));

        ruleList1.add(new Rule(new MemberShipFunction[]{large,large,small,small},0.78));
        ruleList2.add(new Rule(new MemberShipFunction[]{large,large,small,small},0.11));
        ruleList3.add(new Rule(new MemberShipFunction[]{large,large,small,small},0.11));

        ruleList1.add(new Rule(new MemberShipFunction[]{large,large,medium,medium},0.1));
        ruleList2.add(new Rule(new MemberShipFunction[]{large,large,medium,medium},0.7));
        ruleList3.add(new Rule(new MemberShipFunction[]{large,large,medium,medium},0.2));

        ruleList1.add(new Rule(new MemberShipFunction[]{large,medium,medium,medium},0.09));
        ruleList2.add(new Rule(new MemberShipFunction[]{large,medium,medium,medium},0.8));
        ruleList3.add(new Rule(new MemberShipFunction[]{large,medium,medium,medium},0.11));

        ruleList1.add(new Rule(new MemberShipFunction[]{large,medium,large,large},0.07));
        ruleList2.add(new Rule(new MemberShipFunction[]{large,medium,large,large},0.13));
        ruleList3.add(new Rule(new MemberShipFunction[]{large,medium,large,large},0.8));

        ruleList1.add(new Rule(new MemberShipFunction[]{large,large,large,large},0.02));
        ruleList2.add(new Rule(new MemberShipFunction[]{large,large,large,large},0.18));
        ruleList3.add(new Rule(new MemberShipFunction[]{large,large,large,large},0.8));

        Rules rules1 = new Rules(ruleList1);
        Rules rules2 = new Rules(ruleList2);
        Rules rules3 = new Rules(ruleList3);
        doIt(rules1,rules2,rules3,data);
    }

    public static void doIt(Rules rules1, Rules rules2, Rules rules3, double[][] data){
        io(rules1, rules2, rules3);
        System.exit(0);
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        int j = 0;
        for (int i = 0; i < data.length; i++) {
            double y1 = rules1.getValue(data[i]);
            double y2 = rules2.getValue(data[i]);
            double y3 = rules3.getValue(data[i]);
            int res = 0;
            if(y1>y2 && y1>y3){
                res = 1;
            }
            if(y2>y1 && y2>y3){
                res = 2;
            }
            if(y3>y2 && y3>y1){
                res = 3;
            }
            double realY = data[i][4];
            System.out.printf("%.2f\t%.2f\t%.2f\t%.0f\t%d\t",y1,y2,y3,realY,res);
            System.out.println((int)(realY)==res);
            if((int)(realY)==res){
                j++;
            }
            if((i<25 && i>=0)&&(int)(realY)==res){
                i1++;
            }
            if((i<50 && i>=25)&&(int)(realY)==res){
                i2++;
            }
            if((i<75 && i>=50)&&(int)(realY)==res){
                i3++;
            }
        }
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(j);


    }

    private static void io(Rules rules1, Rules rules2, Rules rules3) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        double xx[] = new double[4];
        for (int i = 0; i < xx.length; i++) {
            xx[i] = Double.parseDouble(s[i]);
        }
        double y1 = rules1.getValue(xx);
        double y2 = rules2.getValue(xx);
        double y3 = rules3.getValue(xx);
        int res = 0;
        if(y1>y2 && y1>y3){
            res = 1;
        }
        if(y2>y1 && y2>y3){
            res = 2;
        }
        if(y3>y2 && y3>y1){
            res = 3;
        }
        System.out.printf("y1=%.2f\ny2=%.2f\ny3=%.2f\nresult=%d\n",y1,y2,y3,res);
    }

    public static void paint(String file,final MemberShipFunction[] f){
        JFrame jFrame = new JFrame(){
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.setColor(Color.WHITE);
                g.setColor(Color.BLACK);
                for (double i = 0; i < 1; i+=0.01) {
                    for (MemberShipFunction j: f){
                        int x = (int)(i*200);
                        int y = 150-(int)(100*j.getValue(i));
                        g.drawOval(x,y,3,3);
                    }
                }
            }
        };
        jFrame.setBounds(0,0,300,300);
        jFrame.setVisible(true);
        Graphics g = jFrame.getGraphics();
    }
}
