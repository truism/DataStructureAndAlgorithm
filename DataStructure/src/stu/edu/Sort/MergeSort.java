package stu.edu.Sort;

import java.util.Arrays;

/**
 * 基本思想： 利用分而治之的思想，当要对一个序列的数据进行排序时，首先将这个序列一分为二，
 * 然后对这个两个序列进行分组，再然后将两个有序序列进行合并，递归进行即可
 * 归并排序
 */
public class MergeSort {

  public static void main(String[] args) {
    int[] arr = new int[] {1,3,2,5,4,8,7,6,9,1};
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void  sort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }
    sort(arr,0,arr.length-1);
  }

  /**
   * 对 arr[left,right]进行排序
   * @param arr
   * @param left
   * @param right
   */
  private static void sort(int[] arr, int left, int right) {
    if(left >= right) {
      return;
    }
    int mid = left + (right - left)/2;
    sort(arr,left,mid);
    sort(arr,mid+1,right);
    merge(arr, left, mid, right);
  }

  /**
   * 将arr[left,mid] 和 arr[mid+1,right]的有序序列进行合并
   * @param arr
   * @param left
   * @param mid
   * @param right
   */
  private static void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right-left+1];

    int l = left;
    int r = mid+1;
    int index = 0;
    while (l <= mid && r <= right) {
      if(arr[l] > arr[r]) {
        temp[index++] = arr[r++];
      }else {
        temp[index++] = arr[l++];
      }
    }
    while (l <= mid) {
      temp[index++] = arr[l++];
    }
    while (r <= right) {
      temp[index++] = arr[r++];
    }
    for(int i=0; i<temp.length; i++) {
      arr[left++] = temp[i];
    }
  }

}
