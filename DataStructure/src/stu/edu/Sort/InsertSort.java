package stu.edu.Sort;
//插入排序
public class InsertSort {
    public static void sort(Integer[] arr){
        for(int i=1; i<arr.length; i++){
            if(arr[i] < arr[i-1]){
                for(int j=i-1; j>=0&&arr[j]>arr[j+1]; j--){
                    swap(arr, j ,j+1);
                }
            }
        }
    }
    //交换元素
    private static void swap(Integer[] arr, int n, int m){
        Integer temp = arr[n];
        arr[n] = arr[m];
        arr[m] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5,2,2,4,9,7,6,10,8};
        sort(arr);
        for(Integer i : arr){
            System.out.print(i + " ");
        }
    }

}
