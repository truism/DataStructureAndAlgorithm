package stu.edu.Sort;

//快速排序
public class QuickSort<E extends Comparable<E>> {

    public static void sort(Comparable[] array){
        sort(array, 0, array.length-1);
    }

    private static void sort(Comparable[] arr, int low, int high) {
        if(high <= low)
            return;
        int j = partition(arr, low, high);
        sort(arr, low, j);
        sort(arr, j+1, high);
    }

    //切分，返回切分元素切分后的位置·
    //代表切分元素已到达正确位置
    private static int partition(Comparable[] arr, int low, int high) {
        //  v作为切分元素
        //  i代表从左往右找大于v的元素
        //  j代表从右往左找小于v的元素
        int i = low, j = high + 1;
        Comparable v = arr[i];
        while(true) {
            //跳出了循环代表找到了左边比v大的元素或没有比v大的元素
            while(v.compareTo(arr[++i])<0) {
                if(i == high) {
                    break;
                }
            }
            //跳出循环代表找到了右边比v小的元素或没有比v小的元素
            while(v.compareTo(arr[--j])>0) {
                if(j == low) {
                    break;
                }
            }
            if(i >= j) {
                break;
            }
            //将左边比v大的元素与右边比v小的元素互换
            swap(arr, i, j);
        }
        //将切分元素放到合适位置
        swap(arr, low, j);
        return j;
    }

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5,2,4,9,7,6};
        sort(arr);
        for(Integer i : arr){
            System.out.print(i + " ");
        }
    }

}
