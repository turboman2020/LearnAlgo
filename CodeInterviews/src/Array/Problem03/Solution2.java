package CodeInterviews.src.Array.Problem03;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static void main(String [] args){
        int [] array = new int [] {2,3,1,0,2,5,3};
        int  targetNum = findDuplicationNumbs(array);
        System.out.println(targetNum);
    }

    public static int findDuplicationNumbs(int [] array) {
        /*
         使用一个set来存放数组中出现过的数据，然后遍历数组：
         空间复杂度为 O（n）， 时间复杂度为 O(n)
         */
        if (array == null || array.length == 0) return -1;
        Set<Integer> tempSet = new HashSet<>();
        for (int i = 0 ; i < array.length; i ++){
            if (tempSet.contains(array[i]))
                return array[i];
            else
                tempSet.add(array[i]);
        }

        return -1;

    }
}
