package stu.edu.InterviewQuestion;

/**
 * 输入一个整数n，打印出1~到n位组成的最大数
 * 如：n = 3；则打印1~999
 * @author Admin
 */
public class PrintNumber {

    public static void main(String[] args) {
        printNumber(2);
    }

    public static void printNumber(int n) {
        if(n < 0) {
            return;
        }
        int[] arr = new int[n];
        printNumber(arr, 0);
    }

    private static void printNumber(int[] array, int n) {
        for (int i = 0; i < 10; i++) {
            if(n != array.length) {
                array[n] = i;
                printNumber(array, n+1);
            }else {
                boolean isFirstNoZero = false;
                for (int j = 0; j < array.length; j++) {
                    if(array[j] != 0) {
                        System.out.print(array[j]);
                        if(!isFirstNoZero) {
                            isFirstNoZero = true;
                        }
                    }else {
                        if(isFirstNoZero) {
                            System.out.print(array[j]);
                        }
                    }
                }
                System.out.println();
                return;
            }
        }
    }

}
