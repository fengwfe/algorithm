package com.fuwu.good.backtrack;

/**
 * 1.背包问题
 */
public class HelloBacktrack {

    /**
     *  1.背包问题
     * @param ws
     * @param vs
     * @param capacity
     * @param i
     * @return
     */
    public static int maxProfit(int[] ws, int[] vs, int capacity, int  i){
        if(i  < 0){
            return 0;
        }
        if(i == 0){
            if(ws[i] <= capacity){
                return vs[i];
            }else {
                return 0;
            }
        }
        if(capacity < ws[i]){//选不了
            return maxProfit(ws,vs,capacity, i - 1);
        }else{//可以选
            int r1 = maxProfit(ws,vs,capacity, i - 1);//不选当前
            int r2 =vs[i] + maxProfit(ws, vs, capacity - ws[i],  i - 1);//选当前
            return Math.max(r1, r2);
        }
    }
}
