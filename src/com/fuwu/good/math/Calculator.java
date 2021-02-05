package com.fuwu.good.math;

import java.util.Stack;

public class Calculator {
  public static void main(String[] args) {
    System.out.println(calc("1 + 2*(3 -9)"));
  }
  public static Integer calc(String expression){
      Stack<Integer> operandStack = new Stack<>();//操作数栈
      Stack<Character> operatorStack = new Stack<>();//操作符栈，里面同时包含了左括号
      int num = 0;
      for(int i = 0; i < expression.length(); i++){
          char c = expression.charAt(i);
          if(c == ' '){//处理空格
              continue;
          }else if(c == '('){//左括号
              operatorStack.push(c);
          }else if(isDigit(c)){//数字
              num = num * 10 + (c - '0');
              if(i == expression.length() - 1 || !isDigit(expression.charAt(i + 1))){
                  operandStack.push(num);
                  num = 0;
              }
          }else if(isOperator(c)){//操作符
              while (!operatorStack.isEmpty() && operatorStack.peek() != '(' && getOperatorPriority(operatorStack.peek()) >= getOperatorPriority(c)){
                  popAndcalc(operandStack, operatorStack);
              }
              operatorStack.push(c);
          }else{//右括号
              while (operatorStack.peek() != '('){
                  popAndcalc(operandStack, operatorStack);
              }
              operatorStack.pop();
          }
      }
      while (!operatorStack.isEmpty()){
          popAndcalc(operandStack, operatorStack);
      }
      return operandStack.pop();
  }

  public static boolean isOperator(char c){
      return c == '+' || c == '-' || c == '*' || c == '/';
  }
  public static boolean isDigit(char c){
      return c >= '0' && c <= '9';
  }
  public static int getOperatorPriority(char c){
      switch (c){
          case '+':
              return 1;
          case '-':
              return 1;
          case '*':
              return 2;
          case '/':
              return 2;
          default:
              return -1;
      }
  }
    public static void popAndcalc(Stack<Integer> operandStack, Stack<Character> operatorStack){
        char operator = operatorStack.pop();
        int operand2 = operandStack.pop();
        int operand1 = operandStack.pop();
        int subResult = calc(operand1, operand2, operator);
        operandStack.push(subResult);
    }
  public static int calc(int operand1, int operand2, char operator){
      switch (operator){
          case '+':
              return operand1 + operand2;
          case '-':
              return operand1 - operand2;
          case '*':
              return operand1 * operand2;
          case '/':
              return operand1 / operand2;
          default:
              return  -1;
      }
  }
}
