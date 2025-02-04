package CodeInterviews.src.LeetcodeHot100.P14_Leetcode56;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String [] args){

    }

    public int[][] merge(int[][] intervals) {
        LinkedList<int []> res = new LinkedList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        res.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++){

           if(intervals[i][0] <= res.getLast()[1]){
                int [] curPair = res.removeLast();
                int end = Math.max(curPair[1], intervals[i][1]);
                res.add(new int [] {curPair[0], end});
            } else {
                res.add(intervals[i]);
            }

        }
        return res.toArray(new int [res.size()][2]);
    }
}
