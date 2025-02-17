package CodeInterviews.src.LeetcodeHot100.Part09_Graph.Leetcode210_DAG2;

import java.util.*;

public class Solution2 {
    static int [] visited ;
    static int [] res;
    static int index;
    static boolean valid = true;

    static Map<Integer, LinkedList<Integer>> map;
    public static void main(String [] args){
        int numCourses = 2;
        int [] [] prerequisites = new int [][] {{1,0}};
        int [] res = findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(res));
    }

    //DFS
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        map = new HashMap<>();
        index = numCourses-1;
        for(int [] arr : prerequisites){
            LinkedList<Integer> curList = map.getOrDefault(arr[1], new LinkedList<Integer>());
            curList.add(arr[0]);
            map.put(arr[1], curList);
        }
        res = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0)
                dfs(i);
        }

        if(!valid)
            return new int[0];
        return res;
    }

    public static void dfs(int v){
        visited[v] = 1;
        for(int u : map.getOrDefault(v, new LinkedList<>())){
            if(visited[u] == 0){
                dfs(u);
                if(!valid)
                    return;
            } else if(visited[u] == 1){
                valid = false;
                return ;
            }
        }
        visited[v] = 2;
        res[index--] = v;


    }
}
