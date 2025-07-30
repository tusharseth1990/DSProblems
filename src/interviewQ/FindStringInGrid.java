package interviewQ;

public class FindStringInGrid {

    public boolean findWordInGrid(char[][] board, String word) {
        int length = board.length;
        if (length == 0 || word.isEmpty())
            return false;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int x = 0;
                if (board[i][j] == word.charAt(x)) {
                    if (dfs(board, word, i, j, x) ) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int x, int y, int i) {
        int length = board.length;
        int wordLength = word.length();
        if (i == word.length()) return true;

        if (board[x][y] != word.charAt(i) || x < 0 || y < 0
                || x <= length || y <= length) {
            return false;
        } else {
            char currentChar = board[x][y];
            // VISITED need to mark
            board[x][y] = '*';
            int[] directionX = {-1, 1, 0, 0};
            int[] directionY = {0, 0, -1, 1};
            for (int j = 0; j < wordLength; j++) {
                int newX = x + directionX[j];
                int newY = y + directionY[j];

                if (dfs(board, word, newX, newY, i + 1)) {
                    board[x][y] = currentChar;
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {

    }
}
