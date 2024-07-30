package CodeInterviews.src.Problem03;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public static void main(String [] args){
        int [] array = new int [] {2,3,1,0,2,5,3};
        int  targetNum = findDuplicationNumbs(array);
        System.out.println(targetNum);
    }

    public static int findDuplicationNumbs(int [] array) {
        /*
         考虑题目的特殊性， 数组中存放的数字和数组下标的关联，根据数据中的数据和下标的关系
         来确定重复数字， 时间复杂度为O(n), 空间复杂度为O(1)
         */
        if (array == null || array.length == 0) return -1;
        for (int i = 0 ; i < array.length; i ++){
            while(array[i] != i) {
                if (array[i] == array[array[i]]){
                    return array[i];
                }
                swap(i, array[i], array);
            }
        }

        return -1;

    }

    public static boolean swap (int i ,int j , int [] array ){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        return true;
    }
}
