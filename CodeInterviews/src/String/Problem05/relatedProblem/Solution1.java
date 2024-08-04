package CodeInterviews.src.String.Problem05.relatedProblem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    public static void main(String [] args){
        List<Integer> array1 = new LinkedList<>(Arrays.asList(1, 2, 8, 9, 12, 13, 15));
        List<Integer> array2 = new LinkedList<>(Arrays.asList(3, 4, 6, 7, 9, 10, 16, 19));

        System.out.println(Arrays.toString(array1.toArray()));
        System.out.println(Arrays.toString(array2.toArray()));
        List<Integer> res = mergeSortedList(array1, array2);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public static List<Integer> mergeSortedList(List<Integer> array1, List<Integer> array2) {

        List<Integer> res = new LinkedList<>();
        int i = 0, j = 0;
        while ( i < array1.size() && j < array2.size()){

            if (array1.get(i) <= array2.get(j)) {
                res.add(array1.get(i));
                i++;
            }
            else if (array1.get(i) > array2.get(j)) {
                res.add(array2.get(j));
                j++;
            }
        }
        while (i < array1.size()){
            res.add(array1.get(i++));
        }

        while (j < array2.size()){
            res.add(array2.get(j++));
        }

        return res;

    }

}
