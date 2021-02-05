package com.fuwu.stack;

import java.util.*;

public class HelloStackV2 {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
//        allPopOrder(new int[]{1,2,3,4,5}, 0, new Stack<>(), new Stack<>(),result);
//        System.out.println(result.size());
//        System.out.println(result);

        permutation(new int[]{1,2,3},new ArrayList<>(),result, new HashSet<>());
        System.out.println(result);



    }

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
}
