package stu.edu.InterviewQuestion;

/**
 * @author Admin
 * 统计一个整数转换为二进制时一共有多少个1
 */
public class CountOne {

    public static int countOnt(Integer num) {
        int count = 0;
        while (num != 0) {
            count ++;
            num = num & (num-1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countOnt(2));
        System.out.println(countOnt(3));
        System.out.println(countOnt(4));
        System.out.println(countOnt(5));
        System.out.println(countOnt(6));
    }


}
