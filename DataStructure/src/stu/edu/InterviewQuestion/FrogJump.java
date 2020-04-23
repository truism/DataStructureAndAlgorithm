package stu.edu.InterviewQuestion;

/**
 * 青蛙跳台阶
 */
public class FrogJump {

    /**
     * 青蛙可以一次跳一阶或两阶
     * @param n
     * @return
     */
    public static int jump(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        int sum = 0;
        int r1 = 1;
        int r2 = 2;
        for (int i = 3; i <= n; i++) {
            sum = r1 + r2;
            r1 = r2;
            r2 = sum;
        }
        return sum;
    }

    /**
     * 青蛙一次可以跳 1 ~ n 次
     * @param n
     * @return
     */
    public static int jumpN(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        return (int) Math.pow(2, n-1);
    }

    public static void main(String[] args) {
        System.out.println(jumpN(3));
    }


}
