package stu.edu.Sort;
//选择排序
public class SelectSort {

    public static void sort(Integer[] arr){
        for(int i=0; i<arr.length; i++){
            //int index = i; //记录当前已排序的最后的位置
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] > arr[j]){
                    swap(arr, i ,j);
                }
            }
        }
    }

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
