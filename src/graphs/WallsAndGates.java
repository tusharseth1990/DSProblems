package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    //BFS
/*
0: Gates, -1: Walls, Integer.MAX_VALUE: Empty rooms

Initialization:
A queue (q) is used to perform BFS.
The grid dimensions (m and n) are determined.
All gates (grid[i][j] == 0) are added to the queue as starting points for BFS.
Edge Case:   If the queue is empty (no gates in the grid), the method returns immediately.
BFS Traversal:
The dirs array defines the four possible directions (up, down, left, right) for movement.
While the queue is not empty:
Dequeue a cell (row, col).
For each direction in dirs:
Calculate the new position (r, c).
Skip invalid positions (out of bounds, walls, or already visited cells).
Update the distance of the empty room (grid[r][c] = grid[row][col] + 1).
Add the new position to the queue for further exploration.
 */

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }
        if (q.isEmpty()) return;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            // Move up
            if (row - 1 >= 0 && grid[row - 1][col] == Integer.MAX_VALUE) {
                grid[row - 1][col] = grid[row][col] + 1;
                q.add(new int[]{row - 1, col});
            }
            // Move down
            if (row + 1 < m && grid[row + 1][col] == Integer.MAX_VALUE) {
                grid[row + 1][col] = grid[row][col] + 1;
                q.add(new int[]{row + 1, col});
            }
            // Move left
            if (col - 1 >= 0 && grid[row][col - 1] == Integer.MAX_VALUE) {
                grid[row][col - 1] = grid[row][col] + 1;
                q.add(new int[]{row, col - 1});
            }
            // Move right
            if (col + 1 < n && grid[row][col + 1] == Integer.MAX_VALUE) {
                grid[row][col + 1] = grid[row][col] + 1;
                q.add(new int[]{row, col + 1});
            }
            }
        }

}
