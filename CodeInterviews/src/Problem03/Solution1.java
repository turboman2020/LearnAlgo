package CodeInterviews.src.Problem03;

import java.util.Arrays;

public class Solution1 {
    public static void main(String [] args){
        int [] array = new int [] {2,3,1,0,2,5,3};
        int  targetNum = findDuplicationNumbs(array);
        System.out.println(targetNum);
    }

    public static int findDuplicationNumbs(int [] array) {
        /*
        使用到数据排序方法， 时间复杂度为O(n * logN)
         */
        if (array == null || array.length == 0) return -1;
        Arrays.sort(array);
        for (int i = 1 ; i < array.length; i ++){
            if (array[i-1] == array[i])
                return array[i];
        }

        return -1;

    }
}
