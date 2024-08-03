package CodeInterviews.src.Problem04;

import java.util.Arrays;

public class Solution1 {
    public static void main(String [] args){
        int [][] array = new int [][] {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        for (int i = 0; i < array.length; i++)
            System.out.println(Arrays.toString(array[i]));
        int target = 9;
        System.out.println(findNuminArray(array, 0, array[0].length-1, target));
        System.out.println(findNuminArray(array, target));
    }

    public static boolean findNuminArray(int [][] arrays, int row, int col, int target) {
        //递归方法
        if (arrays == null || row == arrays.length || col < 0 ) return false;
        if (arrays[row][col] == target) return true;
        if (arrays[row][col] > target)
            return findNuminArray(arrays, row, --col, target);
        if (arrays[row][col] < target)
            return findNuminArray(arrays, ++row, col, target);
        return false;
    }

    public static boolean findNuminArray(int [][] arrays, int target) {
        if (arrays == null) return false;
        int curRow = 0, curCol = arrays[0].length - 1;
        boolean result = false;
        while (!result || (curCol < 0 || curRow == arrays.length)){
            if (arrays[curRow][curCol] == target){
                result = true; break;
            }

            if (arrays[curRow][curCol] < target){
                curRow ++; break;
            }
            if (arrays[curRow][curCol] > target) {
                curCol --; break;
            }
        }
        return result;
    }
}
