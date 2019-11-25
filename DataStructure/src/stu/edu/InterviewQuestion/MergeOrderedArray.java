package stu.edu.InterviewQuestion;

import java.util.Arrays;
import java.util.Random;

/**
 * 题目描述：
 * 对于两个有序数组，选择合适的算法对其排序。
 * 分析其最好和最坏情况下需要比较多少次并分析它们的数据分布情况
 * 假设两个数组的元素个数都是10
 */
public class MergeOrderedArray {

    private static Integer CAPACITYA = 10;
    private static Integer[] arrayA =  new Integer[CAPACITYA];
    private static Integer[] arrayB = new  Integer[CAPACITYA];

    public static void main(String[] args) {
        Random random = new Random();
        for(int i=0; i<CAPACITYA; i++) {
            arrayA[i] = random.nextInt(100);
            arrayB[i] = random.nextInt(100);
        }
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        System.out.println(Arrays.toString(arrayA));
        System.out.println(Arrays.toString(arrayB));
        Integer[] result = merge(arrayA, arrayB);
        System.out.println(Arrays.toString(result));
    }

    public static Integer[] merge(Integer[] arrayA, Integer[] arrayB) {
        int length = arrayA.length + arrayB.length;
        Integer[] temp = new Integer[length];
        for(int i=0,j=0,k=0; i<length; i++) {
            if(j >= arrayA.length) {
                temp[i] = arrayB[k];
                k++;
                continue;
            }
            if(k >= arrayB.length) {
                temp[i] = arrayA[j];
                j++;
                continue;
            }
            if(arrayA[j] <= arrayB[k]) {
                temp[i] = arrayA[j];
                j++;
            }else {
                temp[i] = arrayB[k];
                k++;
            }
        }
        return temp;
    }
}
