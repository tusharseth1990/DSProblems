package array.backtracking;
//time :  o (m* 4^n)
/*Initialization:
ROWS and COLS store the dimensions of the grid.
The exist method iterates through each cell in the grid, treating it as a potential starting point for the word.
Recursive Depth-First Search (DFS):
The dfs method is used to explore all possible paths from the current cell to match the word.
Base Case: If the index i equals the length of the word, it means the word has been successfully found, and the method returns true.
Boundary Conditions: If the current cell is out of bounds, already visited (marked as #), or does not match the current character of the word, the method returns false.
Marking and Backtracking:
The current cell is temporarily marked as visited by replacing its value with #.
The method recursively explores all four possible directions (up, down, left, right) from the current cell.
After exploring, the cell is restored to its original value to allow other paths to use it.
Final Result:
If any path returns true, the exist method returns true.
If no path matches the word, the method returns false.
This approach ensures all possible paths are explored while adhering to the constraints of the problem.

 */
public class WordSearch {
    private int ROWS, COLS;

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS ||
                board[r][c] != word.charAt(i) || board[r][c] == '#') {
            return false;
        }

        board[r][c] = '#';
        boolean res = dfs(board, word, r + 1, c, i + 1) ||
                dfs(board, word, r - 1, c, i + 1) ||
                dfs(board, word, r, c + 1, i + 1) ||
                dfs(board, word, r, c - 1, i + 1);
        board[r][c] = word.charAt(i);
        return res;
    }
}
