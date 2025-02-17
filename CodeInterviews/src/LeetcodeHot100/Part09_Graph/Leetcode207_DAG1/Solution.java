package CodeInterviews.src.LeetcodeHot100.Part09_Graph.Leetcode207_DAG1;

import java.util.*;

public class Solution {

    public static void main(String [] args){
        int numCourses = 5;
        int [] [] prerequisites = new int [][] {{1,4},{2,4},{3,1},{3,2}};
        boolean res = canFinish(numCourses, prerequisites);
        System.out.println(res);
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //有向无环图的拓扑排序
        //从每个结点的入度入手，进行广度优先遍历BFS
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        int [] indegreeArr = new int [numCourses];
        for(int i = 0 ; i < prerequisites.length; i++){

            int [] cur = prerequisites[i];
            LinkedList<Integer> curList = map.getOrDefault(cur[1], new LinkedList<>());
            curList.add(cur[0]);
            map.put(cur[1],curList);
            indegreeArr[cur[0]]++;
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indegreeArr[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int pos = queue.remove();
            count++;
            if(map.containsKey(pos)){
                while(!map.get(pos).isEmpty()){
                    int curr = map.get(pos).poll();
                    indegreeArr[curr]--;
                    if(indegreeArr[curr] == 0)
                        queue.add(curr);
                }
            }
        }

        return count == numCourses;
    }
}
