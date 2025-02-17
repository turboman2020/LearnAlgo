package CodeInterviews.src.LeetcodeHot100.Part09_Graph.Leetcode210_DAG2;

import java.util.*;

public class Solution {

    public static void main(String [] args){
        int numCourses = 2;
        int [] [] prerequisites = new int [][] {{1,0}};
        int [] res = findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(res));
    }

    //BFS
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        int [] indegreeArr = new int [numCourses];

        for(int [] arr : prerequisites){
            LinkedList<Integer> curList = map.getOrDefault(arr[1], new LinkedList<Integer>());
            curList.add(arr[0]);
            map.put(arr[1], curList);
            indegreeArr[arr[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < indegreeArr.length; i++){
            if(indegreeArr[i] == 0)
                queue.add(i);
        }

        int [] res = new int [numCourses];
        int count = 0;
        while (!queue.isEmpty()){
            int pos = queue.remove();
            res[count++] = pos;
            if(map.containsKey(pos)){
                for(int item : map.get(pos)){
                    indegreeArr[item]--;
                    if(indegreeArr[item] == 0){
                        queue.add(item);
                    }
                }

            }

        }

        return count == numCourses ? res: new int[0];
    }
}
