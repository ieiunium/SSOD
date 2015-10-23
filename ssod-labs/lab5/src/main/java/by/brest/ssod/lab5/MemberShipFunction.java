package by.brest.ssod.lab5;

/**
 * Created by kirill on 23.10.15.
 */
public class MemberShipFunction {
    private double a;
    private double sigma;

    public MemberShipFunction(double a, double sigma) {
        this.a = a;
        this.sigma = sigma;
    }

    public double getValue(double x){
        return gaussian(x,sigma,a);
    }

    public static double gaussian(double x, double sigma,double a){
        return Math.exp(((x-a)*(x-a))/(-sigma*sigma));
    }
}
