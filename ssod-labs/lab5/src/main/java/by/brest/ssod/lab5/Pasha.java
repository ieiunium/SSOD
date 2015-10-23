package by.brest.ssod.lab5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by kirill on 23.10.15.
 */
public class Pasha {
    public static void main(String[] args) throws FileNotFoundException {

        int[][] rules = {
                  {2, 3, 1, 1, 1}
                , {3, 3, 2, 1, 1}
                , {3, 2, 2, 2, 2}
                , {3, 3, 2, 2, 2}
                , {3, 2, 3, 3, 3}
                , {3, 3, 3, 3, 3}
        };

        double[][] inputData = new double[75][5];

        File in = new File("D:input.txt");
        Scanner scanFile = new Scanner(in);
        for(int i = 0; i < 75; i++) {

            for(int j = 0; j < 4; j++) {
                double tmp = scanFile.nextDouble();
                inputData[i][j] = tmp;
            }

            if(i < 25)
                inputData[i][4] = 1;
            else if (i < 50)
                inputData[i][4] = 2;
            else
                inputData[i][4] = 3;
        }

        ArrayList<Double[]> totalArr = new ArrayList<>();

        for(double[] item : inputData) {
            double[] out = new double[6];

            for (int i = 0; i < rules.length ; i++) {
                out[i] = 1.0;
                for (int j = 0; j < 4; j++) {
                    out[i] *= getParam(rules[i][j], item[j]);
                }
            }

            double delimoe = 0;
            double deleter = 0;
            for (int i = 0; i < rules.length; i++) {
                delimoe += out[i] * rules[i][4];
                deleter += out[i];
            }


            System.out.println(delimoe);
            System.out.println(deleter);
            double y1 = delimoe / deleter;
            double y2 = returnType(y1);
            System.out.println(y2 + " " + item[4]);

            Double[] tmpArr = {y1, y2, item[4]};

            System.out.println(tmpArr[2]);
            totalArr.add(tmpArr);
        }


        double right = 0;
        double wrong = 0;
        for(Double[] item : totalArr) {
            System.out.print(item[0] + "\t");
            System.out.print(item[1] + "\t");
            if(Math.abs(item[2] - item[1]) < 0.1) {
                System.out.println("Success");
                right++;
            } else {
                System.out.println("Not Success");
                wrong++;
            }
        }

        System.out.println("Total percentage = " + right / (right + wrong));

        Scanner scanner = new Scanner(System.in);
        while(true) {
            double[] x = new double[4];
            for (int i = 0; i < 4; i++) {
                x[i] = scanner.nextDouble();
            }

            double[] out = new double[6];
            for (int i = 0; i < rules.length ; i++) {
                out[i] = 1;
                for (int j = 0; j < 4; j++) {
                    out[i] *= getParam(rules[i][j], x[j]);
                }
            }

            double delimoe = 0;
            double deleter = 0;
            for (int i = 0; i < rules.length; i++) {
                delimoe += out[i] * rules[i][4];
                deleter += out[i];
            }

            double y1 = delimoe / deleter;
            double y2 = returnType(y1);

            System.out.println("This is type  " + y2);
        }

    }

    static double gaussValue(double x, double ave) {
        double sigma = 0.3;
        return 1.0 / (2 * Math.PI * sigma) * Math.exp(-Math.pow((x - ave) / sigma, 2.0));
    }

    static double getParam(int type, double value) {
        switch(type){
            case 1: return gaussValue(value, 0.0);
            case 2: return gaussValue(value, 0.5);
            case 3: return gaussValue(value, 1);
            default: return 1;
        }
    }

    static int returnType(double y) {
        double b1 = 1.2;
        double b2 = 2.2;
        double b3 = 4;
        if(y < b1)
            return 1;
        else if(y >= b1 && y < b2)
            return 2;
        else if(y < b3)
            return 3;
        return -1;
    }
}
