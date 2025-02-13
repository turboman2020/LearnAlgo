package CodeInterviews.src.LeetcodeHot100.Part09_Graph.Leetcode207_DAG1;

import java.util.*;

public class Solution2 {

    static int [] visited;
    static boolean valid = true;
    static Map<Integer, LinkedList<Integer>> map = new HashMap<>();
    public static void main(String [] args){
        int numCourses = 5;
        int [] [] prerequisites = new int [][] {{1,4},{2,4},{3,1},{3,2}};
        boolean res = canFinish(numCourses, prerequisites);
        System.out.println(res);
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //有向无环图的拓扑排序
        //从每个结点的出度入手，进行深度优先遍历DFS

        visited = new int[numCourses];
        for(int i = 0 ; i < prerequisites.length; i++){

            int [] cur = prerequisites[i];
            LinkedList<Integer> curList = map.getOrDefault(cur[1], new LinkedList());
            curList.add(cur[0]);
            map.put(cur[1],curList);

        }

        for(int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0)
                dfs(i);
        }

        return valid;
    }

    public static void dfs(int u){
        visited[u] = 1;

        LinkedList<Integer> curr = map.get(u);
        for(int v : curr){
            if(visited[v] == 0){
                dfs(v);
                if(!valid)
                    return ;
            } else if(visited[v] == 1){
                valid = false;
                return;
            }
        }
        visited[u] = 2;

    }
}
