package array.math;
import java.util.*;

//https://leetcode.com/problems/spiral-matrix/
/*
Given an m x n matrix, return all elements of the matrix in spiral order.
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
        L       R
   T    1 2 3 4
        5 6 7 8
        9 1 5 3
   B
 */

public class SpiralMatrix {
//
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length;
        int top = 0, bottom = matrix.length;

        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i < bottom; i++) {
                res.add(matrix[i][right - 1]);
            }
            right--;
            if (!(left < right && top < bottom)) {
                break;
            }
            for (int i = right - 1; i >= left; i--) {
                res.add(matrix[bottom - 1][i]);
            }
            bottom--;
            for (int i = bottom - 1; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }

        return res;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix= new SpiralMatrix();
        int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
        spiralMatrix.spiralOrder(arr);
        for(int[] row:arr)
        {
            System.out.println(Arrays.toString(row));
        }
    }
}
