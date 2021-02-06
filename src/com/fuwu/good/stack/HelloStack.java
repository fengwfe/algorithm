package com.fuwu.good.stack;

import java.util.List;
import java.util.Stack;

/**
 * 1.判断括号是否合法
 * 2.生成n对括号
 * 3.给定stack的push顺序，判断pop顺序是否合法
 *
 */

public class HelloStack {
  public static void main(String[] args) {
  }
    /**
     * 1.判断括号是否合法
     * @param s
     * @return
     */
    public static boolean isValidParentheses(String s){
        if(null == s || s.length() == 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if('(' == c){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    /**
     * 2.生成n对括号
     * @param n
     * @return
     */
    public static void genParentheses(int n, int leftCount, int rightCount, String record, List<String> result){
        if(leftCount == n && rightCount == n){
            result.add(record);
            return ;
        }
        if(rightCount > leftCount || leftCount > n || rightCount > n){
            return;
        }
        genParentheses(n , leftCount  +  1, rightCount, record  + "(", result);
        genParentheses(n , leftCount , rightCount + 1, record  + ")", result);
    }

    /**
     * 3.给定stack的push顺序，判断pop顺序是否合法
     * @param inOrder
     * @param outOrder
     * @return
     */
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
}
