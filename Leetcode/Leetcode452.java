package Leetcode;

import java.util.*;

public class Leetcode452 {


    public static void main(String [] args) {
        int [][] points = new int [][] {{-2147483646,-2147483645},{2147483646,2147483647}};
        int res = new Leetcode452().findMinArrowShots(points);
        System.out.println(res);
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[0] > point2[0]) {
                    return 1;
                } else if(point1[0] < point2[0]){
                    return -1;
                } else {
                    return 0;
                }

            }
        });

        int res = 1;
        for(int i=1; i < points.length; i++){
            if(points[i][0] > points[i-1][1]) {
                res ++;
            } else {
                points[i][1] = Math.min(points[i][1], points[i-1][1]);
            }

        }
        return res;
    }
}