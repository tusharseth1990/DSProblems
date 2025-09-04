package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {


    private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

       //if starting color already has same new color
        if(image[sr][sc] == newColor){
            return image;
        }

        // Call DFS with the original color of the starting pixel
        dfs(image,sr,sc,image[sr][sc],newColor);
        return image;
    }

    private static void dfs(int[][] image, int x, int y, int oldColor, int newColor) {
         //base case
        if(x < 0 || x >= image.length ||
            y < 0 || y >= image[0].length ||
            image[x][y] != oldColor) {
            return ;
        }

        // Change the color of the current pixel
        image[x][y] = newColor;

        // Recursively call DFS in all four directions
        dfs(image, x + 1, y, oldColor, newColor);
        dfs(image, x - 1, y, oldColor, newColor);
        dfs(image, x, y + 1, oldColor, newColor);
        dfs(image, x, y - 1, oldColor, newColor);

    }

    private static final int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    private static int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        int oldColor = image[sr][sc];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!q.isEmpty()) {
            int[] front = q.poll();
            int x = front[0], y = front[1];

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];


                // Check boundary conditions and color match
                if (nx > 0 && nx < image.length
                        && ny > 0 && ny < image[0].length
                        && image[nx][ny] == oldColor) {
                    image[nx][ny] = newColor;
                    q.offer(new int[]{nx, ny});
                }
            }

        }
        return image;
    }

    // Driver code to test the flood fill function
    public static void main(String[] args) {

        // Define the image matrix
        int[][] image = {
                {1, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };

        // Starting pixel and the new color
        int sr = 1, sc = 2, newColor = 2;

        // Perform flood fill
        int[][] result = floodFill(image, sr, sc, newColor);
        int[][] result1 = floodFillBFS(image, sr, sc, newColor);
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }




}
