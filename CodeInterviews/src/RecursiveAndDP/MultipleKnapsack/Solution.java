package CodeInterviews.src.RecursiveAndDP.MultipleKnapsack;

public class Solution {
    public static void main(String[] args) {
        // 背包容量
        int capacity = 10;

        // 物品列表：{体积, 价值, 数量}
        int[][] items = {
                {2, 3, 4}, // 物品1：重量2，价值3，数量4
                {3, 4, 2}, // 物品2：重量3，价值4，数量2
                {5, 6, 1}  // 物品3：重量5，价值6，数量1
        };

        // 求解
        int maxValue = multipleKnapsackBin(capacity, items);
        System.out.println("背包的最大价值是: " + maxValue); // 输出：15
    }

    public static int multipleKnapsack(int capacity, int[][] items) {
        // 初始化 DP 数组
        int[] dp = new int[capacity + 1];

        // 遍历每种物品
        for (int[] item : items) {
            int weight = item[0]; // 重量
            int value = item[1];  // 价值
            int count = item[2];  // 数量限制

            // 遍历背包容量，从后向前
            for (int j = capacity; j >= weight; j--) {
                // 枚举当前物品的选择数量
                for (int k = 1; k <= count && k * weight <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * weight] + k * value);
                }
            }
        }
        return dp[capacity];
    }

    public static int multipleKnapsackBin(int capacity, int[][] items) {
        // 初始化 DP 数组
        int[] dp = new int[capacity + 1];

        // 遍历每件物品
        for (int[] item : items) {
            int weight = item[0]; // 体积
            int value = item[1];  // 价值
            int count = item[2];  // 数量限制

            // 二进制拆分优化
            for (int k = 1; k <= count; count -= k, k *= 2) {
                int currentWeight = k * weight;
                int currentValue = k * value;

                // 从后向前遍历更新 DP 数组
                for (int j = capacity; j >= currentWeight; j--) {
                    dp[j] = Math.max(dp[j], dp[j - currentWeight] + currentValue);
                }
            }
            // 剩余部分不足二进制段
            if (count > 0) {
                int currentweight = count * weight;
                int currentValue = count * value;

                for (int j = capacity; j >= currentweight; j--) {
                    dp[j] = Math.max(dp[j], dp[j - currentweight] + currentValue);
                }
            }
        }
        return dp[capacity];
    }
    
}
