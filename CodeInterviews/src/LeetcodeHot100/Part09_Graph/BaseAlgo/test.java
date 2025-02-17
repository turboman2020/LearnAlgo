package CodeInterviews.src.LeetcodeHot100.Part09_Graph.BaseAlgo;

import java.util.*;

public class test {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // 示例边，确保边的数据有效
        int[] edges1 = {1, 2};
        int[] edges2 = {1, 3};
        int[] edges3 = {2, 3};

        // 添加边
        addEdge(graph, edges1);
        addEdge(graph, edges2);
        addEdge(graph, edges3);

        // 打印图的邻接表
        System.out.println("Graph after adding edges: " + graph);
    }

    public static void addEdge(Map<Integer, List<Integer>> graph, int[] edges) {
        // 检查边的数据有效性，避免 null 值
        if (edges == null || edges.length < 2) {
            throw new IllegalArgumentException("Invalid edge data");
        }

        // 调试打印
        System.out.println("Adding edge: " + Arrays.toString(edges));

        // 调试：打印当前的图
        System.out.println("Graph before insert: " + graph);

        // 使用 putIfAbsent 确保每个节点都有一个邻接节点列表
        List<Integer> list1 = graph.putIfAbsent(edges[0], new LinkedList<>());
        if (list1 == null) {
            System.out.println("Created new list for node " + edges[0]);
        } else {
            System.out.println("Node " + edges[0] + " already exists with neighbors: " + list1);
        }

        List<Integer> list2 = graph.putIfAbsent(edges[1], new LinkedList<>());
        if (list2 == null) {
            System.out.println("Created new list for node " + edges[1]);
        } else {
            System.out.println("Node " + edges[1] + " already exists with neighbors: " + list2);
        }

        // 将边加入到邻接表中
        graph.get(edges[0]).add(edges[1]);
        graph.get(edges[1]).add(edges[0]);
    }
}