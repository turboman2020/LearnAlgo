package CodeInterviews.src.RecursiveAndDP.KnapsackProblem01.Package01;

import java.util.Arrays;

public class Solution02 {
    static int [] [] memo;
    public static void main(String [] array){

        int [] weight = new int [] {6,5,6,6,3,7};
        int [] value = new int [] {5,6,4,6,5,2};
        int c = 15;

//        int [] weight = new int [] {1,2,3};
//        int [] value = new int [] {6,10,12};
//        int c = 5;
        int maxValue = knapsackProblem(weight, value, c);
        System.out.println(maxValue);
    }

    public static int knapsackProblem(int [] weight, int [] value, int c){
        if(weight == null || weight.length == 0) return 0;
        // DP方法， memo[i][j]表示遍历到第i个物品容量为j时的最大价值
        memo = new int[weight.length][c+1];

        for(int j = 0; j <= c; j++){
            memo[0][j] = j >= weight[0] ? value[0]: 0;
        }

        System.out.println(Arrays.toString(memo[0]));
        for(int i = 1 ;i < weight.length; i++){
            // 不能从 j = weight[i]开始遍历， 因为memo[i][j< weight[i]]的数据含义不再正确
            for(int j = 0; j <= c; j++){
                memo[i][j] = memo[i-1][j]; //将上一层的状态传递到下一层，不可缺少
                if(j >= weight[i])
                    memo[i][j] = Math.max(memo[i-1][j], value[i] + memo[i-1][j-weight[i]]);
            }
            System.out.println(Arrays.toString(memo[i]));
        }
        return memo[weight.length-1][c];

    }

    public static int knapsackProblem02(int [] weight, int [] value, int c){
        if(weight == null || weight.length == 0) return 0;
        // DP方法，空间优化, 从行上来看，每次循环只与第（i-1） 和 i 有关
        memo = new int[2][c+1];
        for(int j = 0; j <= c; j++){
            memo[0][j] = j >= weight[0] ? value[0]: 0;
        }

        for(int i = 1 ;i < weight.length; i++){

            for(int j = 0; j <= c; j++){
                memo[i%2][j] = memo[(i-1)%2][j];
                if(j >= weight[i])
                    memo[i%2][j] = Math.max(memo[(i-1)%2][j], value[i] + memo[(i-1)%2][j-weight[i]]);
            }
            System.out.println(Arrays.toString(memo[i%2]));
        }
        return memo[(weight.length-1)%2][c];

    }

    public static int knapsackProblem03(int [] weight, int [] value, int c){
        if(weight == null || weight.length == 0) return 0;
        // DP方法，空间优化：
        // 从行上来看，每次循环只与第（i-1） 和 i 有关；
        // 从列上来看，后面列的计算会用到前面的列，因此内层循环j可以从c开始递减至weight[i],这样就只需要一个一维数组
        int [] memo = new int[c+1];

        for(int i = 0 ;i < weight.length; i++){
            // 从 j = c  倒序遍历至 weight[i], 不用遍历至0， 因为memo数组是滚动更新的
//            for(int j = weight[i]; j <= c; j++){ 错误的数组表展示
           for(int j = c; j >= weight[i]; j--){
                memo[j] = Math.max(memo[j], value[i] + memo[j-weight[i]]);
           }
            System.out.println(Arrays.toString(memo));
        }
        return memo[c];

    }

}
