package CodeInterviews.src.RecursiveAndDP.KnapsackProblem;

public class Solution01 {
    static int res = 0;
    public static void main(String [] array){

        int [] weight = new int [] {6,5,6,6,3,7};
        int [] value = new int [] {5,6,4,6,5,2};
        int c = 15;
        int maxValue = knapsackProblem(weight, value, c);
        System.out.println(maxValue);
    }

    public static int knapsackProblem(int [] weight, int [] value, int c){
        // 方法一
       return knapsackProblemHelper(weight, value, c, weight.length -1);
       //方法二
//        knapsackProblemHelper2(weight, value, c, 0, 0);
//        return res;
    }

    //递归法
    public static int knapsackProblemHelper(int [] weight, int [] value, int c, int index){
        if(c <= 0 || index < 0)
            return 0;
        int maxValue = knapsackProblemHelper(weight, value, c, index-1);

        if( c >= weight[index]){
            maxValue = Math.max(maxValue, value[index] + knapsackProblemHelper(weight, value, c-weight[index], index-1));
        }
        return maxValue;
    }

    //回溯法
    public static int knapsackProblemHelper2(int [] weight, int [] value, int c, int index, int curRes){
        if(c <= 0   || index  >= weight.length || c < weight[index]) {
            res = curRes > res ? curRes : res;
            return res;
        }
        for(int i = index; i < weight.length; i++){
            curRes += value[i];
            knapsackProblemHelper2(weight, value, c- weight[i], i + 1, curRes);
            curRes -= value[i];
        }

        return res;
    }
}
