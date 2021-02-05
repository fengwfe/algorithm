package com.fuwu.good.math;

/**
 * 1.判断是否为丑数
 * 2.生成第K个丑数
 */
public class HelloMath {

    /**
     * 1.判断是否为丑数
     */
    public static boolean isUglyNum(int num){
        if(num <= 0){
            return false;
        }
        while (num % 2 ==0){
            num = num / 2;
        }
        while (num % 3 ==0){
            num  = num / 3;
        }
        while (num % 5 == 0){
            num = num / 5;
        }
        return num == 1;
    }

    /**
     * 2.生成第K个丑数
     */
    public static int kthUglyNum(int k){
        int[] uglyNums = new int[k];
        uglyNums[0] = 1;
        int i = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while (i < k){
            int nextUglyNum = 2 * uglyNums[p2];
            nextUglyNum = Math.min(nextUglyNum, 3 * uglyNums[p3]);
            nextUglyNum = Math.min(nextUglyNum, 5 * uglyNums[p5]);
            uglyNums[i] = nextUglyNum;
            while (2 * uglyNums[p2] <= nextUglyNum ){
                p2++;
            }
            while (3 * uglyNums[p3] <= nextUglyNum ){
                p3++;
            }
            while (5 * uglyNums[p5] <= nextUglyNum ){
                p5++;
            }

            i++;
        }
        return uglyNums[k - 1];
    }
}
