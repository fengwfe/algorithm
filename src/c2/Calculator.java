package c2;

import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {
        System.out.println(calc_04("2147483647"));

    }

    /**
     * 处理加减乘除，不处理空格和括号
     * @return
     */
    public static int calc_02(String s){
        int num = 0;
        char sign = '+';
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (isDigit(c)){
                num = num * 10 + (c - '0');
            }
            if(!isDigit(c) || i == s.length() - 1){
                if(sign == '*'){
                    int top = stack.pop();
                    num = top * num;

                }else if(sign == '/'){
                    int top = stack.pop();
                    num = top / num;

                }else{
                    num = sign == '+' ? num : -num;
                }
                stack.push(num);
                num = 0;
                sign = c;
            }
        }
        while (!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }

    /**
     * 处理加减乘除，空格
     *
     */
    public static int calc_03(String s) {
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!isDigit(c) || i == s.length() - 1) {
                if (sign == '*') {
                    num = stack.pop() * num;
                } else if (sign == '/') {
                    num = stack.pop() / num;
                } else {
                    num = sign == '+' ? num : -num;
                }
                stack.push(num);
                num = 0;
                sign = c;
            }
        }
        while (!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }

    /**
     *处理加减乘除，空格，括号
     *
     * 表达式 = 数字 + 操作符 + 表达式, 表达式是递归的
     *
     */
    public static int calc_04(String s){
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int result = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }else if(c == '('){//遇到子表达式的时候
                //截取sub 表达式，递归
                Integer start = null;
                int end = i + 1;
                int left = 1;
                int right = 0;
                while (left != right){
                    char c2 = s.charAt(end);
                    if(c2  ==  '('){
                        left++;
                    }else if(c2 == ')'){
                        right++;
                    }else {
                        if(null == start){
                            start = end;
                        }
                    }
                    end++;
                }
                String subExpression = s.substring(start, end - 1);
                num = calc_04(subExpression);
                System.out.println("Sub Expression:  "+  subExpression +" = " + num);
                i = end;
            }else if(isDigit(c)){
                num = num * 10 + (c - '0');
                i++;
            }else if(!isDigit(c) && c != '('){//当遇到操作符的时候,operator
                if (sign == '*') {
                    num = stack.pop() * num;
                } else if (sign == '/') {
                    num = stack.pop() / num;
                } else {
                    num = sign == '+' ? num : -num;
                }
                stack.push(num);
                num = 0;
                sign = c;
                i++;
            }
        }
        if (sign == '*') {
            num = stack.pop() * num;
        } else if (sign == '/') {
            num = stack.pop() / num;
        } else {
            num = sign == '+' ? num : -num;
        }
        stack.push(num);
        while (!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
    public static boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }


}
