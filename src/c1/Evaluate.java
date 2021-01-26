package c1;

import java.util.Stack;

public class Evaluate {

    public static double evaluate(String expression){
        String[] array = expression.split(" ");
        Stack<Double> values = new Stack<>();
        Stack<String> ops = new Stack<>();
        for(String data: array){
            if(data.equals("(")){

            }else if(data.equals(")")){
                String op = ops.pop();
                double v1 = values.pop();
                double v2 = values.pop();
                double result = 0;
                if(op.equals("+")){
                    result = v2 + v1;
                }else if(op.equals("-")){
                    result = v2 - v1;
                }else if(op.equals("*")){
                    result = v2 * v1;
                }else if(op.equals("/")){
                    result = v2 / v1;
                }
                values.push(result);
            }else if(data.equals("+")){
                ops.push(data);
            }else if(data.equals("-")){
                ops.push(data);
            }else if(data.equals("*")){
                ops.push(data);
            }else if(data.equals("/")){
                ops.push(data);
            }else{
                values.push(Double.valueOf(data));
            }
        }
        return values.pop();
    }

    public static void main(String[] args) {
        String expression = "( ( 1 + 2 ) - ( 3 * 2 ) )";
        System.out.println(evaluate(expression));
    }
}
