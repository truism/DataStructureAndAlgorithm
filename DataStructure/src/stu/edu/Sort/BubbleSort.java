package stu.edu.Sort;

public class BubbleSort {

    //冒泡排序
    public static void sort(Integer[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }
    //交换数组arr的n处和m处的元素
    private static void swap(Integer[] arr, int n, int m){
        Integer temp = arr[n];
        arr[n] = arr[m];
        arr[m] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5,2,4,9,7,6};
        sort(arr);
        for(Integer i : arr){
            System.out.print(i + " ");
        }
    }

}
