package com.fuwu.stack;

import common.Printer;

import java.util.*;

public class HelloStack {
    public static void main(String[] args) {
//        test(Arrays.asList(new Integer[]{1,2,3,4,5}), new Stack<Integer>(), new Stack<Integer>());
//        System.out.println(isValidOrder(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
//        System.out.println(isValidOrder(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2}));
        Printer.print(medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));

    }

    public static boolean isValidOrder(int[] inOrder, int[] outOrder){
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < inOrder.length; i++) {
            int data = inOrder[i];
            stack.push(data);
            while (!stack.isEmpty() && stack.peek() == outOrder[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();

    }

//打印所有pop的可能

    public static void  test(List<Integer> inOrder, Stack<Integer> inS, Stack<Integer> outS){
        if(outS.size() == inOrder.size()){
            System.out.println(outS);
            return;
        }
        //push
        if(inS.size() + outS.size() < inOrder.size()){
            Stack<Integer> copyIn = copy(inS);
            copyIn.push(inOrder.get(inS.size() + outS.size()));
            test(inOrder, copyIn, outS);
        }

        //pop
        if(!inS.isEmpty()){
            Stack<Integer> copyIn = copy(inS);
            Stack<Integer> copyOut = copy(outS);
            copyOut.push(copyIn.pop());
            test(inOrder, copyIn,copyOut);
        }
    }

    public static Stack<Integer> copy(Stack<Integer> stack){
        List<Integer> list = new ArrayList<>(stack);
        Stack<Integer> copy = new Stack<>();
        for(Integer d : list){
          copy.push(d);
        }
       return copy;
    }

    public static Double[] medianSlidingWindow(int[] nums, int k) {
        Double[] result = new Double[nums.length - k + 1];
        int m  =  0;
        PriorityQueue<Integer> left =new PriorityQueue<>((a,b)->{return b -  a;});
        PriorityQueue<Integer> right =new PriorityQueue<>((a,b)->{return a -  b;});
        int[] tmp = Arrays.copyOf(nums, k);
        Arrays.sort(tmp);
        for(int i = 0; i < tmp.length; i++){
            if(i <= tmp.length / 2){
                left.offer(tmp[i]);
            }else{
                right.offer(tmp[i]);
            }
        }
        result[m++] = getMedian3(left,right);
        for(int i = k; i  < nums.length; i++){
            if(left.contains(nums[i - k])){
                left.remove(nums[i - k]);
            }else if(right.contains(nums[i - k])){
                right.remove(nums[i - k]);
            }
            left.offer(nums[i]);
            balance(left, right);
            result[m++] = getMedian3(left,right);
        }
        return result;

    }

    public static void balance(PriorityQueue<Integer> left, PriorityQueue<Integer> right){

    }

    public static double getMedian3(PriorityQueue<Integer> left, PriorityQueue<Integer> right){
        return 1d;
    }


    public static double getMedian2(PriorityQueue<Integer> window){
        PriorityQueue<Integer> copy = new PriorityQueue<>(window);
        int[] sortedData =  new int[copy.size()];
        int i = 0;
        while (!copy.isEmpty()){
            sortedData[i++] = copy.poll();
        }
        return getMedian(sortedData);

    }
    public static double getMedian(int[] sortedData){
        int size = sortedData.length;
        double result = 0;
        if(size % 2 == 0){
            int index1 = size / 2;
            int index2 = size / 2 - 1;
            result += sortedData[index1];
            result += sortedData[index2];
            result = result / 2;
        }else{
            result = sortedData[size / 2];
        }
        return result;
    }


}
