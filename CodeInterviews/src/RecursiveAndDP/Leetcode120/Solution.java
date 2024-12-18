package CodeInterviews.src.RecursiveAndDP.Leetcode120;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String [] args){
        int [][] arr = {{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>> triangle = Arrays.stream(arr)
                .map(a -> Arrays.stream(a).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());

          System.out.println(minimumTotal(triangle));

    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        Integer [] memo = new Integer [triangle.size()];

        minimumTotalHelper(triangle, triangle.size()-1, triangle.size()-1, memo);
        Arrays.sort(memo);
        return memo[0];
    }

    public static Integer minimumTotalHelper(List<List<Integer>> triangle, int k ,int index, Integer [] memo) {
        if(k < 0 || index < 0 || index > k)
            return Integer.MAX_VALUE;
        if(k == 0) {
            memo[index] = triangle.get(0).get(0);
            return memo[index];
        }

        if(memo[index] != null)
            return memo[index];
        for(int i = k; i >= 0; i--){

            int value1 = minimumTotalHelper(triangle, k-1, i, memo);

            int value2 = minimumTotalHelper(triangle, k-1, i-1, memo);

            memo[i] = triangle.get(k).get(i) + Math.min(value1, value2);
        }
        return memo[index];

    }
}
