package Leetcode;

import java.util.Arrays;

import java.util.LinkedList;
import java.util.List;

public class Leetcode56 {


    public static void main(String [] args) {
        int [][] intervals = new int [][]{{1,3}, {2,6},{8,10},{15,18}};
        int[][] res = new Leetcode56().merge(intervals);
        System.out.println(res);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        LinkedList<int []> res = new LinkedList<>();
        res.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= res.getLast()[1]){
                int start = res.getLast()[0];
                int end = Math.max(res.getLast()[1], intervals[i][1]);
                res.removeLast();
                res.add(new int [] {start, end});
            } else {
                res.add(intervals[i]);
            }
        }

        return res.toArray(new int [res.size()][2]);

    }
}