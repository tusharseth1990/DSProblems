package array.math;

//https://leetcode.com/problems/rotate-image/
/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 DO NOT allocate another 2D matrix and do the rotation
 */

import java.util.Arrays;

public class RotateImageBy90 {

    public void rotate(int[][] matrix) {
        int l = 0;
        int r = matrix.length - 1;

        while ( l < r )
        {
            for(int i = 0; i < r - l; i++)
            {
                int top = l;
                int bottom = r;
                //save the topleft
                int topLeft = matrix[top][l + i];

                //move bottom left into top left
                matrix[top][l + i] = matrix[bottom - i][l];

                // move bottom right into bottom left
                matrix[bottom - i][l] = matrix[bottom][r - i];

                // move top right into bottom right
                matrix[bottom][r - i] = matrix[top + i][r];

                // move top left into top right
                matrix[top + i][r] = topLeft;

            }

            r -= 1;
            l += 1;
        }
    }

    public static void main(String[] args) {
        RotateImageBy90 rotateImageBy90= new RotateImageBy90();
        int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
        rotateImageBy90.rotate(arr);
        for(int[] row:arr)
        {
            System.out.println(Arrays.toString(row));
        }
    }
}
