package CodeInterviews.src.LeetcodeHot100.Part10_Recursive.Leetcode79;

public class Solution {
    public static void main(String [] args){
            char [] [] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
            System.out.println(exist(board, "SEE"));
    }

    public static boolean exist(char[][] board, String word) {

        for(int i = 0;  i < board.length; i++){
            for(int j = 0;  j < board[i].length; j++){

                boolean res = existHelper(board, i ,j, new boolean[board.length][board[0].length], word, 0);

                if(res) return true;
            }
        }

        return false;
    }

    public static boolean existHelper(char[][] board, int row, int col, boolean [][] vis, String word, int index) {
        if(index >= word.length())
            return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return false;
        if(vis[row][col])
            return false;
        vis[row][col] = true;
         boolean flag =  board[row][col] == word.charAt(index) && (
                 existHelper(board, row-1, col, vis, word, index+1) ||
                 existHelper(board, row, col+1, vis, word, index+1) ||
                 existHelper(board, row+1, col, vis, word, index+1) ||
                 existHelper(board, row, col-1, vis, word, index+1)
                 );
        vis[row][col] = false;

        return flag;

    }
}
