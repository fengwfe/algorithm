package c2;

import common.ArrayUtil;

import java.util.Stack;

public class NextGreaterNum {

    public static void main(String[] args) {
        int[] data = {2,0,5,6,0,7,22};
        ArrayUtil.print(nextGreaterNum(data));
    }

    /**
     * 给定一个无序数组，求每个元素后面最近的比当前元素大的元素的index
     */
    public static int[] nextGreaterNum(int[] data){
        if(null == data){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[data.length];
        int j = result.length - 1;
        for(int i = data.length - 1; i >=0; i--){
            while (!stack.isEmpty() && data[stack.peek()] <= data[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[j--] = -1;
            }else{
                result[j--] = stack.peek();
            }
            stack.push(i);
        }
        return result;
    }
}
