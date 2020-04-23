package stu.edu.InterviewQuestion;

/**
 * 斐波那契数列
 */
public class Fabonacci {

    /**
     * 递归法
     * @param n
     * @return
     */
    public static int fabonacci(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        return fabonacci(n-1) + fabonacci(n-2);
    }

    /**
     * 遍历法
     * @param n
     * @return
     */
    public static int fabonacci2(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        int sum = 0;
        int r1 = 1;
        int r2 = 0;
        for (int i=2; i<=n; i++) {
            sum = r1 + r2;
            r2 = r1;
            r1 = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(fabonacci2(10));
    }

}
