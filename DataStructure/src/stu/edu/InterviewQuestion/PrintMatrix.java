package stu.edu.InterviewQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 按顺时针打印矩阵
 */
public class PrintMatrix {

  public static void main(String[] args) {
    int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    List<Integer> result = printMatrix(matrix);
    System.out.println(Arrays.toString(result.toArray()));
  }

  public static List<Integer> printMatrix(int[][] matrix) {
    ArrayList<Integer> list = new ArrayList<>();
    int r1 = 0, r2 = matrix.length-1;
    int c1 = 0, c2 = matrix[0].length-1;
    while (c1 <= c2 && r1 <= r2) {
      for (int i=c1; i<=c2; i++) {
        // 从左往右
        list.add(matrix[r1][i]);
      }
      for(int i=r1+1; i<=r2; i++) {
        // 从上往下
        list.add(matrix[i][c2]);
      }
      if(c1 < c2 && r1 < r2) {
        for (int i = c2-1; i > c1 ; i--) {
          // 从右往左
          list.add(matrix[r2][i]);
        }
        for (int i = r2; i > r1 ; i--) {
          list.add(matrix[i][c1]);
        }
      }
      r1++;
      r2--;
      c1++;
      c2--;
    }
    return list;
  }

}
