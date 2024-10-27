package Leetcode;

import java.util.Arrays;

public class Leetcode860 {


    public static void main(String [] args) {
        int [] bills = new int [] {5,5,5,10,20};
        boolean res = new Leetcode860().lemonadeChange(bills);
        System.out.println(res);
    }

    public boolean lemonadeChange(int[] bills) {
        int [] money = new int [5];
        int sumMoney = 0;
        for(int i = 0; i < bills.length; i++){
            if(bills[i] - 5 > sumMoney) return false;

            money[bills[i] / 5] +=1;
            int curMoney = bills[i] - 5;
            while(curMoney >= 20 && money[4] > 0) {
                curMoney-=20;
                money[4]--;
            }

            while(curMoney >= 10 && money[2] > 0) {
                curMoney-=10;
                money[2]--;
            }

            while(curMoney >= 5 && money[1] > 0) {
                curMoney-=5;
                money[1]--;
            }

            sumMoney = money[1] * 5 + money[2] * 10 + money[4] * 20;
            if(curMoney > 0) return false;
        }
        return true;

    }
}