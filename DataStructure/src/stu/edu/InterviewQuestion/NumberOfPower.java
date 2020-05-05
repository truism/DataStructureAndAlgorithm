package stu.edu.InterviewQuestion;

/**
 * @author Admin
 * 求一个数的n次方，不借用函数库
 */
public class NumberOfPower {

    public static void main(String[] args) {
        System.out.println(power(2,0));
        System.out.println(power(2,2));
    }

    private static final double CRITICAL = 0.0000000001;

    public static double power(double target, int power) {
        if(equal(target, 0)) {
            return 0;
        }
        if(power == 0) {
            return 1.0;
        }else if(power > 0) {
            return multiply(target, power);
        }else {
            return multiply(1/target, -power);
        }
    }

    public static boolean equal(double a, double b) {
        if(a-b < CRITICAL || a-b > -CRITICAL) {
            return false;
        }
        return true;
    }

    public static double multiply(double e, int power) {
        double sum = 1;
        for (int i = 0; i < power; i++) {
            sum = sum * e;
        }
        return sum;
    }

}
