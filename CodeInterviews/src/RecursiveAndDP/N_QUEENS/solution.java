package CodeInterviews.src.RecursiveAndDP.N_QUEENS;

import java.util.LinkedList;
import java.util.List;

public class solution {

    static List<List<String>> res = new LinkedList<>();
    static LinkedList<int []> tmpRes = new LinkedList<>();
    public static void main(String [] args){
        solveNQueens(4);
        System.out.println(res);
    }
    public static List<List<String>> solveNQueens(int n) {
        solveNQHelper(n, 0);
        return res;
    }
    public static void solveNQHelper(int n, int index){
        if(index == n) {
            res.add(genRes(tmpRes));
            return;
        }
        int [] curRow = new int[n];

        for(int i = 0 ;  i < n; i ++){
            if(isValid(tmpRes, index, i, n)){
                tmpRes.add(curRow);
                curRow[i] = 1;
                solveNQHelper(n, index + 1);
                curRow[i] = 0;
                tmpRes.removeLast();
            }
        }

    }
    public static boolean isValid(List<int []> curRes, int row, int pos, int n){
        //判断列
        for(int i = row-1;  i >=0; i--){
            if(curRes.get(i)[pos] == 1)
                return false;
        }

        //判断 / 对角线
        for(int i = row-1,j = pos+1; i >=0 && j < n; i--, j++) {
            if(curRes.get(i)[j] == 1)
                return false;
        }

        //判断 \ 对角线
        for(int i = row-1,j = pos-1; i >=0 && j >= 0; i--, j--) {
            if(curRes.get(i)[j] == 1)
                return false;
        }

        return true;

    }

    public static List<String> genRes(List<int []> tmpRes){
        List<String> tmp = new LinkedList<>();
        for(int [] ele: tmpRes){
            StringBuffer str = new StringBuffer();
            for (int i : ele){
                String ch = i == 1 ? "Q":".";
                str.append(ch);
            }
            tmp.add(str.toString());

        }

        return tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
