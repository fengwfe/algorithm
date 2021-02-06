package com.fuwu.good.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 1.背包问题
 * 2.全排列
 * 3.给定入栈顺序，求所有可能的出栈顺序
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

    /**
     * 2.全排列
     * @param nums
     * @param path
     * @param result
     * @param visited
     */
    public static void permutation(int[] nums, List<Integer> path, List<List<Integer>> result, Set<Integer> visited){
        if(path.size()  == nums.length){
            List<Integer> record = new ArrayList<>(path);
            result.add(record);
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited.contains(i)){
                continue;
            }
            path.add(nums[i]);
            visited.add(i);
            permutation(nums, path, result, visited);
            path.remove(path.size() - 1);
            visited.remove(i);
        }
    }

    /**
     * 3.给定入栈顺序，求所有可能的出栈顺序
     * @param nums
     * @param i
     * @param inPath
     * @param outPath
     * @param result
     */
    public static void allPopOrder(int[] nums, int i, Stack<Integer> inPath, Stack<Integer> outPath, List<List<Integer>> result){
        if(outPath.size() == nums.length){
            List<Integer> record = new ArrayList<>(outPath);
            result.add(record);
            return;
        }
        if(i < nums.length){
            inPath.push(nums[i]);
            allPopOrder(nums, i +  1, inPath, outPath, result);
            inPath.pop();//回溯
        }
        if(!inPath.isEmpty()){
            int data  =  inPath.pop();
            outPath.push(data);
            allPopOrder(nums, i, inPath, outPath, result);
            inPath.push(data);//回溯
            outPath.pop();//回溯
        }
    }

}
