package array.math;
import java.util.*;

//https://leetcode.com/problems/spiral-matrix/
/*
Given an m x n matrix, return all elements of the matrix in spiral order.
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

 */

public class SpiralMatrix {
//
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            int rows = matrix.length;
            int columns = matrix[0].length;
            int up = 0;
            int left = 0;
            int right = columns - 1;
            int down = rows - 1;

            while (result.size() < rows * columns) {
                // Traverse from left to right.
                for (int col = left; col <= right; col++) {
                    result.add(matrix[up][col]);
                }
                // Traverse downwards.
                for (int row = up + 1; row <= down; row++) {
                    result.add(matrix[row][right]);
                }
                // Make sure we are now on a different row.
                if (up != down) {
                    // Traverse from right to left.
                    for (int col = right - 1; col >= left; col--) {
                        result.add(matrix[down][col]);
                    }
                }
                // Make sure we are now on a different column.
                if (left != right) {
                    // Traverse upwards.
                    for (int row = down - 1; row > up; row--) {
                        result.add(matrix[row][left]);
                    }
                }
                left++;
                right--;
                up++;
                down--;
            }

            return result;
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rb = 0;
        int re = matrix.length - 1;
        int cb = 0;
        int ce = matrix[0].length - 1;

        while (rb <= re && cb <= ce) {
            for (int j = cb; j <= ce; j++) {
                list.add(matrix[rb][j]);
            }
            rb++;

            for (int i = rb; i <= re; i++) {
                list.add(matrix[i][ce]);
            }
            ce--;

            if (rb <= re) {
                for (int j = ce; j >= cb; j--) {
                    list.add(matrix[re][j]);
                }
            }
            re--;

            if (cb <= ce) {
                for (int i = re; i >= rb; i--) {
                    list.add(matrix[i][cb]);
                }
            }
            cb++;
        }

        return list;
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
