package stu.edu.InterviewQuestion;

/**
 * 判断一个数是否是2的n次方
 * @author Admin
 */
public class NumberIsPowerOfTwo {


    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(3));
        System.out.println(isPowerOfTwo(10));
    }

    public static boolean isPowerOfTwo(int num) {
        if((num & (num-1)) == 0){
            return true;
        }
        return false;
    }

}
