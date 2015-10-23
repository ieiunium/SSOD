import java.util.List;

/**
 * Created by kirill on 23.10.15.
 */
public class Rules {
    private List<Rule> ruleList;


    public Rules(List<Rule> ruleList) {
        this.ruleList = ruleList;
    }

    public double getValue(double[] x){
        double p1 = 0;
        double p2 = 0;
        for (int i = 0; i < ruleList.size(); i++) {
            double M = ruleList.get(i).getValue(x);
            double G = ruleList.get(i).getG();
            p1 += M * G;
            p2 += M;
        }
        double y = p1/p2;
        return  y;
    }
}
