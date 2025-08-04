package graphs;

public class MaxArea {

    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int area = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    area = Math.max(area, dfs(grid, r, c));
                }
            }
        }

        return area;
    }

    private int dfs(int[][] grid, int i, int j) {
        if( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = '0';
        int res = 1;
        res +=dfs(grid, i + 1, j);
        res +=dfs(grid, i , j + 1);
        res +=dfs(grid, i - 1, j);
        res +=dfs(grid, i , j - 1);
        return res;
    }

    // it will cover diagonal case also
    private int dfsII(int[][] grid, int i, int j) {
        if( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = '0';
        int res = 1;
        res +=dfsII(grid, i + 1, j);
        res +=dfsII(grid, i , j + 1);
        res +=dfsII(grid, i - 1, j);
        res +=dfsII(grid, i , j - 1);
        res +=dfsII(grid, i - 1, j - 1); // top-left
        res +=dfsII(grid, i - 1, j + 1); // top-right
        res +=dfsII(grid, i + 1, j - 1); // bottom-left
        res +=dfsII(grid, i + 1, j + 1); // bottom - right

        return res;
    }

}
