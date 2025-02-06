package CodeInterviews.src.LeetcodeHot100.Part06_Matrix.P18_Leetcode73;

import java.util.HashSet;

public class Solution {
    public static void main(String [] args){

    }

    public void setZeroes(int[][] matrix) {

        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for(int row : rowSet){
            for(int j = 0; j < matrix[row].length; j++){
                matrix[row][j] = 0;
            }
        }

        for(int col : colSet){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][col] = 0;
            }
        }

    }
}
