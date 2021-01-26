package c2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        gen(3,0, 0, "",result);
        System.out.println(result);
    }

    /**
     * 判断括号是否合法
     * @param s
     * @return
     */
    public static boolean isValid(String s){
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
     * 生成n对括号
     * @param n
     * @return
     */
    public static void gen(int n, int leftCount, int rightCount, String record, List<String> result){
        if(leftCount == n && rightCount == n){
            result.add(record);
            return ;
        }
        if(rightCount > leftCount || leftCount > n || rightCount > n){
            return;
        }
        gen(n , leftCount  +  1, rightCount, record  + "(", result);
        gen(n , leftCount , rightCount + 1, record  + ")", result);
    }
}
