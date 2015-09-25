package lab3;

/**
 * Created by kirill on 25.9.15.
 */
public class Function {
    private double x1,y1,x2,y2,x3,y3;
    private String title;
    public Function(double x1, double y1, double x2, double y2, double x3, double y3,String title) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public double getY(double x){
        double res = 0;
        if(x<x2){
            res = getY(x,x1,y1,x2,y2);
        }else{
            res = getY(x,x2,y2,x3,y3);
        }
        return (res<0)?0:res;
    }

    private double getY(double x,double x1,double y1,double x2,double y2){
        return ((x-x1)*(y2-y1)/(x2-x1)) + y1;
    }
}