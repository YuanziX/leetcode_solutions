class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, word, 0, i, j)) return true;
            }
        }

        return false;
    }

    boolean helper(char[][] board, String word, int i, int n, int m) {
        if (i == word.length()) return true;
        if (n < 0 || m < 0 || n >= board.length || m >= board[0].length || board[n][m] != word.charAt(i)) {
            return false;
        }

        char temp = board[n][m];
        board[n][m] = '#';

        boolean res = helper(board, word, i + 1, n - 1, m) || helper(board, word, i + 1, n + 1, m) ||
            helper(board, word, i + 1, n, m - 1) || helper(board, word, i + 1, n, m + 1);

        board[n][m] = temp;
        return res;
    }
}