package CodeInterviews.src.RecursiveAndDP.KnapsackProblem;

public class Solution01 {
    static int res = 0;
    static int [] [] memo;
    public static void main(String [] array){

        int [] weight = new int [] {6,5,6,6,3,7};
        int [] value = new int [] {5,6,4,6,5,2};
        int c = 15;
        int maxValue = knapsackProblem(weight, value, c);
        System.out.println(maxValue);
    }

    public static int knapsackProblem(int [] weight, int [] value, int c){
        // 方法一
//        knapsackProblemHelper1(weight, value, c, 0, 0);
//        return res;

        //方法二
//        return knapsackProblemHelper2(weight, value, c, weight.length -1);


        // 方法三
        memo = new int[weight.length][c+1];
        for(int i = 0 ;i < weight.length; i++){
            for(int j = c; j >= 0; j--){
                    memo[i][j] = -1;
            }
        }
        return knapsackProblemHelper3(weight, value, c, weight.length -1);

    }

    //回溯法 res为全局变量
    public static void knapsackProblemHelper1(int [] weight, int [] value, int c, int index, int curRes){
        if(c <= 0   || index  >= weight.length || c < weight[index]) {
            res = curRes > res ? curRes : res;
            return ;
        }
        for(int i = index; i < weight.length; i++){
            curRes += value[i];
            knapsackProblemHelper1(weight, value, c- weight[i], i + 1, curRes);
            curRes -= value[i];
        }
    }

    //递归法
    public static int knapsackProblemHelper2(int [] weight, int [] value, int c, int index){
        if(c <= 0 || index < 0)
            return 0;
        int maxValue = knapsackProblemHelper2(weight, value, c, index-1);

        if( c >= weight[index]){
            maxValue = Math.max(maxValue, value[index] + knapsackProblemHelper2(weight, value, c-weight[index], index-1));
        }
        return maxValue;
    }


    //记忆化搜索， memo 在全局定义，在调用函数中初始化
    public static int knapsackProblemHelper3(int [] weight, int [] value, int c, int index){
        if(c <= 0 || index < 0) {
            return 0;
        }

        if(memo[index][c]  != -1) {
            return memo[index][c];
        }  else {
            int maxValue = knapsackProblemHelper3(weight, value, c, index-1);

            if( c >= weight[index]){
                maxValue = Math.max(maxValue, value[index] + knapsackProblemHelper3(weight, value, c-weight[index], index-1));
            }
            memo[index][c] = maxValue;
        }

        return memo[index][c];


    }

}
