package CodeInterviews.src.LeetcodeHot100.P21_Leetcode240;

public class Solution {
    public static  void main(String [] args){

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rs = 0, cs = matrix[0].length - 1;
        while (rs < matrix.length && cs >= 0){
            if(matrix[rs][cs] == target)
                return true;
            if(matrix[rs][cs] > target){
                cs--;
            } else  if(matrix[rs][cs] < target){
                rs++;
            }

        }
        return false;
    }
}
