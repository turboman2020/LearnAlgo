package CodeInterviews.src.LeetcodeHot100.P19_Leetcode54;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String [] args){
        int [][] matrix = new int [][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        List<Integer> res = spiralOrder(matrix);
        System.out.println(Arrays.toString(res.toArray()));

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int rs = 0, re = matrix.length - 1;
        int cs = 0, ce = matrix[0].length - 1;
        while (rs <= re && cs <= ce){
            for(int j = cs; rs <= re && j <= ce; j++)
                res.add(matrix[rs][j]);
            rs++;
            for(int i = rs; cs <= ce && i <= re ; i++)
                res.add(matrix[i][ce]);
            ce--;

            for(int j = ce; rs <= re && j >= cs ; j--)
                res.add(matrix[re][j]);
            re--;

            for(int i = re; cs <= ce && i >= rs ; i--)
                res.add(matrix[i][cs]);
            cs++;
        }

        return res;

    }
}
