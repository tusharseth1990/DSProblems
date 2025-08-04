package graphs;

public class NoOfIslands {
    //numIslands: Iterates through the grid. When it finds '1', it triggers DFS
    // and increments the island count.
    public int numIslands(char [][] grid){
        int island = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    dfs(grid, i , j);
                    island++;
                }
            }
        }
        return island;
    }

    //dfs: Recursively visits all connected '1's (up, down, left, right)
    // and marks them as '0' to avoid revisiting.
    private void dfs(char[][] grid, int i, int j) {
        if( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i , j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i , j - 1);
    }

    // it will cover diagonal case also
    private void dfsII(char[][] grid, int i, int j) {
        if( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return;
        }
        grid[i][j] = '0';
        dfsII(grid, i + 1, j);     // down
        dfsII(grid, i - 1, j);     // up
        dfsII(grid, i, j + 1);     // right
        dfsII(grid, i, j - 1);     // left
        dfsII(grid, i - 1, j - 1); // top-left
        dfsII(grid, i - 1, j + 1); // top-right
        dfsII(grid, i + 1, j - 1); // bottom-left
        dfsII(grid, i+1, j+1); //bottom - right
    }



}
