package CodeInterviews.src.LeetcodeHot100.Part09_Graph.BaseAlgo;

import java.util.*;

public class graphTraverse {
    public static void main(String [] args){
        //构建图，图创建使用邻接表表示 ： Map<String, List<String>>
        //或者二维的邻接矩阵表示
//        graph = {
//                'A': ['B', 'C'],
//        'B': ['A', 'D', 'E'],
//        'C': ['A', 'F'],
//        'D': ['B'],
//        'E': ['B', 'F'],
//        'F': ['C', 'E']
        //输入边集合构建图
        String [] [] edgeArr = new String [] []{
                {"A", "B"}, {"A", "C"},
                {"B", "A"}, {"B", "D"}, {"B", "E"},
                {"C", "A"}, {"C", "F"},
                {"D", "B"},
                {"E", "B"}, {"E", "F"},
                {"F", "C"}, {"F", "E"}
        };
        Map<String, Set<String>> graph = new HashMap<>();

        for(String [] edges : edgeArr){
            graph.putIfAbsent(edges[0], new HashSet<>());
            graph.get(edges[0]).add(edges[1]);
            //如果是无向图，还需要添加 (edges[1], egdes[0]) 这条边

        }

        //DFS
        Set<String> visited = new HashSet<>();
        List<String> res = new ArrayList<>();
//        for(String node : graph.keySet()){
                DFS(graph, "A", visited, res);
//        }
        System.out.println( Arrays.toString(res.toArray()));

        res.clear();
        //BFS
        BFS(graph, "A", res);
        System.out.println( Arrays.toString(res.toArray()));

    }

    public static void DFS(Map<String, Set<String>> graph, String node,
                           Set<String> visited, List<String> res){
        if(!visited.contains(node)){
            visited.add(node);
            res.add(node);
            for(String key : graph.getOrDefault(node, new HashSet<String>())) {
                if(!visited.contains(key)){
                    DFS(graph, key, visited, res);

                }

            }
        }

    }

    public static void BFS(Map<String, Set<String>> graph, String node,
                            List<String> res){

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(node);
        visited.add(node);
        while (!queue.isEmpty()){
            String curNode = queue.poll();
            res.add(curNode);

            for(String curEdges : graph.getOrDefault(curNode, new HashSet<>())){
                if(!visited.contains(curEdges)){
                    visited.add(curEdges);
                    queue.add(curEdges);
                }

            }
        }
    }

}
