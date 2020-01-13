package leetcode.backtracking;


//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
// 示例:
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true.
//给定 word = "SEE", 返回 true.
//给定 word = "ABCB", 返回 false.
// Related Topics 数组 回溯算法

public class Lc79 {

    class Solution {

        public boolean exist(char[][] board, String word) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0) && search(board, word, 0, visited, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean search(char[][] board, String word, int index, boolean[][] visited, int x, int y) {
            if (word.length() <= index) {
                return true;
            }

            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                return false;
            }

            if (visited[x][y]) {
                return false;
            }

            if (board[x][y] != word.charAt(index)) {
                return false;
            }

            visited[x][y] = true;
            boolean find = search(board, word, index + 1, visited, x + 1, y)
                    || search(board, word, index + 1, visited, x, y + 1)
                    || search(board, word, index + 1, visited, x - 1, y)
                    || search(board, word, index + 1, visited, x, y - 1);

            if (find) {
                return true;
            }

            visited[x][y] = false;
            return false;
        }

    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};

        System.out.println(new Lc79().new Solution().exist(board, "ABCCED"));
        System.out.println(new Lc79().new Solution().exist(board, "SEE"));
        System.out.println(new Lc79().new Solution().exist(board, "ABCB"));
    }

}
