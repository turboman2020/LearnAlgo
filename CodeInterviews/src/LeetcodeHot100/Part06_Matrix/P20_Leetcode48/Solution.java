package CodeInterviews.src.LeetcodeHot100.Part06_Matrix.P20_Leetcode48;

public class Solution {
    public static void main(String [] args){

    }

    public void rotate(int[][] matrix) {

        //水平翻转
        for(int i = 0; i < matrix.length / 2 ; i++){
            for(int j = 0; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - i][j];
                matrix[matrix.length - 1 - i][j] = temp;
            }
        }

        //主对角线翻转
        for(int i = 0; i < matrix.length; i++){
            for(int j = i + 1; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }
}
