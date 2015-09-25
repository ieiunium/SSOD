package lab2;

import java.util.Arrays;

/**
 * Created by kirill on 11.9.15.
 */
public class MainL2 {
    public static void main(String[] args){
        double slow[] = new double[50];
        double long_[] = new double[50];
        for (int i = 0; i < slow.length; i++) {
            slow[i] = getMidSpeed(i);
        }
        for (int i = 0; i < long_.length; i++) {
            long_[i] = getMidDist(i*6);
        }
        //System.out.println(Arrays.toString(slow));
        //System.out.println(Arrays.toString(long_));
        double field[][]  = new double[50][50];

        for (int i = 0; i < slow.length; i++) {
            field[i] = new double[long_.length];
            for (int j = 0; j < long_.length; j++) {
                double d = field[i][j] = Math.min(slow[i],long_[j]);
                System.out.print(d+" ");
            }
            System.out.println();
        }
    }

    public static double getMidSpeed(double x){
        if(x<10 || x>30){
            return 0;
        }else if(x<20){
            return x/10-1;
        }else{
            return -x/10+3;
        }

    }
    public static double getMidDist(double x){
        if(x<50 || x>150){
            return 0;
        }else if(x<100){
            return x/50-1;
        }else{
            return -x/50+3;
        }
    }

    /*public static double getVerySlow(double x){
        final double w = 50;
        if(x<0){
            return 1;
        }else if(x>=0 && x<w){
            return (x*(-1)/w+1);
        }else return 0;
    }
    public static double getVeryLong(double x){
        if(x>200){
            return 1;
        }else if(x>=150){
            return (x*(1)/50)-3;
        }else return 0;
    }*/
}
