package stu.edu.Sort;
//希尔排序,改进版插进

/**
 * 考虑到插入排序的特点，对于有序的序列其不需要移动元素，大大缩减了排序时间，
 * 希尔排序就是考虑到这点。
 * 它设计待排序列按增量分组，对每一组利用插入进行排序，然后减小增量，待增量缩小到1时，
 * 序列已经完成了大部分排序，因此再利用插入进行排序就很快了。
 */
public class ShellSort {

    public static void sort(Integer[] arr){
        for(int gap=arr.length/2; gap>0; gap/=2){
            for(int i=gap; i<arr.length; i++){
                    for(int j=i-gap; j>=0&&arr[j]>arr[j+gap]; j-=gap){
                        swap(arr, j, j+gap);
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
        Integer[] arr = new Integer[]{5,2,2,4,9,7,6,10,8};
        sort(arr);
        for(Integer i : arr){
            System.out.print(i + " ");
        }
    }

}
