package CodeInterviews.src.RecursiveAndDP.Problem12;

public class Solution01 {
    // leetcode79: 单词搜索
    public static void main(String [] args) {
//        char[][] board = new char [][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board = new char [][] {{'A','B','C','E'}, {'S','F','E','S'}, {'A','D','E','E'}};
        boolean isExist = existWord(board, "ABCEFSADEESE");
        System.out.println(isExist);

    }
    public static boolean existWord(char[][] board, String word) {

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++) {
                boolean [][]visited = new boolean[board.length][board[0].length];
                boolean res = existChar(board, visited, i, j, word,0);
                if(res) return true;
            }
        }
        return false;
    }

    public static boolean existChar(char[][]  board, boolean [][]visited, int row, int col, String word, int charIndex){
        if(charIndex == word.length()) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return  false;
        }
        if(visited[row][col]) return false;

        boolean isExist = false;
        if(board[row][col] == word.charAt(charIndex)) {
            visited[row][col] = true;
            isExist = existChar(board, visited, row, col+1, word, charIndex+1) ||
                    existChar(board, visited, row+1, col, word, charIndex+1) ||
                    existChar(board, visited, row, col-1, word, charIndex+1) ||
                    existChar(board, visited, row-1, col, word, charIndex+1);
            visited[row][col] = false;
        }
        
        return isExist;
    }

}
