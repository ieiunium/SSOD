package lab3;

/**
 * Created by kirill on 25.9.15.
 */
public class Main {
    public static void main(String[] args){

        Function speedVerySlow = new Function(
                0,1,
                5,1,
                15,0,"verySlow");
        Function speedSlow = new Function(
                5,0,
                15,1,
                25,0,"slow");
        Function speedMid = new Function(
                15,0,
                25,1,
                35,0,"midSpeed");
        Function speedFast = new Function(
                25,1,
                35,1,
                45,0,"fast");
        Function speedVeryFast = new Function(
                35,1,
                45,1,
                55,1,"veryFast");


        Function distVeryShort = new Function(
                0,1,
                50,1,
                100,0,"veryShort");
        Function distShort = new Function(
                50,0,
                100,1,
                300,0,"short");
        Function distMid = new Function(
                100,0,
                300,1,
                500,0,"midDist");
        Function distLong = new Function(
                300,1,
                500,1,
                700,0,"long");
        Function distVeryLong = new Function(
                500,1,
                700,1,
                1000,1,"veryLong");


        Function breakVeryLittle = new Function(
                -1,1,
                1,1,
                2.5,0,"veryLittle");
        Function breakLittle = new Function(
                0,0,
                2.5,1,
                5,0,"Little");
        Function breakMid = new Function(
                2.5,0,
                5,1,
                7.5,0,"midBreak");
        Function breakStrong = new Function(
                5,1,
                7.5,1,
                10,0,"strong");
        Function breakVeryStrong = new Function(
                7.5,1,
                10,1,
                20,1,"veryStrong");

        Rule rule11 = new Rule(speedVeryFast,distVeryShort,breakVeryStrong,RuleType.AND);
        Rule rule12 = new Rule(speedVeryFast,distShort,breakStrong,RuleType.AND);
        Rule rule13 = new Rule(speedVeryFast,distMid,breakMid,RuleType.AND);
        Rule rule14 = new Rule(speedVeryFast,distLong,breakLittle,RuleType.AND);
        Rule rule15 = new Rule(speedVeryFast,distVeryLong,breakVeryLittle,RuleType.AND);

        Rule rule21 = new Rule(speedVerySlow,distVeryShort,breakVeryStrong,RuleType.AND);
        Rule rule22 = new Rule(speedVerySlow,distShort,breakVeryLittle,RuleType.AND);
        Rule rule23 = new Rule(speedVerySlow,distMid,breakVeryLittle,RuleType.AND);
        Rule rule24 = new Rule(speedVerySlow,distLong,breakVeryLittle,RuleType.AND);
        Rule rule25 = new Rule(speedVerySlow,distVeryLong,breakVeryLittle,RuleType.AND);

        Rule rule31 = new Rule(speedSlow,distVeryShort,breakVeryStrong,RuleType.AND);
        Rule rule32 = new Rule(speedSlow,distShort,breakStrong,RuleType.AND);
        Rule rule33 = new Rule(speedSlow,distMid,breakMid,RuleType.AND);
        Rule rule34 = new Rule(speedSlow,distLong,breakLittle,RuleType.AND);
        Rule rule35 = new Rule(speedSlow,distVeryLong,breakVeryLittle,RuleType.AND);

        Rule rule41 = new Rule(speedMid,distVeryShort,breakVeryStrong,RuleType.AND);
        Rule rule42 = new Rule(speedMid,distShort,breakStrong,RuleType.AND);
        Rule rule43 = new Rule(speedMid,distMid,breakMid,RuleType.AND);
        Rule rule44 = new Rule(speedMid,distLong,breakLittle,RuleType.AND);
        Rule rule45 = new Rule(speedMid,distVeryLong,breakVeryLittle,RuleType.AND);

        Rule rule51 = new Rule(speedFast,distVeryShort,breakVeryStrong,RuleType.AND);
        Rule rule52 = new Rule(speedFast,distShort,breakStrong,RuleType.AND);
        Rule rule53 = new Rule(speedFast,distMid,breakMid,RuleType.AND);
        Rule rule54 = new Rule(speedFast,distLong,breakLittle,RuleType.AND);
        Rule rule55 = new Rule(speedFast,distVeryLong,breakVeryLittle,RuleType.AND);

        
    }
}
