package CodeInterviews.src.RecursiveAndDP.KnapsackProblem;

public class Solution01 {
    public static void main(String [] array){
            int [] weight = new int [] {1,2,3};
            int [] value = new int [] {6,10,12};
            int c = 5;
            int maxValue = knapsackProblem(weight, value, c);
            System.out.println(maxValue);
    }

    public static int knapsackProblem(int [] weight, int [] value, int c){
        return knapsackProblemHelper(weight, value, c, weight.length-1);
    }

    public static int knapsackProblemHelper(int [] weight, int [] value, int c, int index){
        if(c <= 0 || index < 0)
            return 0;
        int maxValue = knapsackProblemHelper(weight, value, c-weight[index], index-1);

        if( c >= weight[index]){
            maxValue = Math.max(maxValue, value[index] + knapsackProblemHelper(weight, value, c-weight[index], index-1));
        }
        return maxValue;
    }
}
