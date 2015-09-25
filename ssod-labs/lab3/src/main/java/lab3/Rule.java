package lab3;

/**
 * Created by kirill on 25.9.15.
 */
public class Rule {
    private Function f1;
    private Function f2;
    private Function f3;
    private RuleType ruleType;

    public Rule(Function f1, Function f2, Function f3, RuleType ruleType) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.ruleType = ruleType;
    }

    public double getM1(double x){
        return f1.getY(x);
    }
    public double getM2(double x){
        return f2.getY(x);
    }
    public double getM3(double x){
        return f3.getY(x);
    }
    public double getM12(double x1,double x2){
        if(ruleType==RuleType.AND){
            return Math.min(getM1(x1), getM2(x2));
        }else{
            return Math.max(getM1(x1), getM2(x2));
        }
    }
    public double getM(double x1,double x2,double x3){
        return getM12(x1,x2) * getM3(x3);
    }
}

