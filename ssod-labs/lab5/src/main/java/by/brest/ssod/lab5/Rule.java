package by.brest.ssod.lab5;

import java.util.*;

/**
 * Created by kirill on 23.10.15.
 */
public class Rule {
    private MemberShipFunction[] functionList;
    private final double g;
    public Rule(MemberShipFunction[] functionList, double g) {
        this.g = g;
        this.functionList = functionList;
    }

    public double getValue(double[] x){
        double M = 1;
        for (int i = 0; i < functionList.length; i++) {
            M *= functionList[i].getValue(x[i]);
        }
        return M;
    }

    public double getG() {
        return g;
    }
}
