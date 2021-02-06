package com.fuwu.good.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 1.搜索插入位置
 * 2.移除元素
 * 3.two sum问题
 * 4.three sum 问题
 * 5.merge two sorted array
 * 6.数组中有多少个子数组满足子数组的和为target
 * 7.删除数组里面的特定元素，返回新数组的长度
 * 8.将数组中的0移动到数组的末尾,这里要看需不需要保证非零元素的相对位置
 * 9.有序数组去除重复,要求in-place，返回新数组的长度
 * 10. 将字符串中的空格replace成20%
 * 11.给定一个无序数组，求每个元素后面最近的比当前元素大的元素的index
 * 12.有序数组中删除重复元素，返回新数组的长度
 * 13.twoSum,找出所有满足的twoSum组合
 */
public class HelloArray {
  public static void main(String[] args) {
//    System.out.println(twoSum(new int[]{3,1,4,6,8},4));
    System.out.println(threeSum(new int[]{3,1,4,6,8},11));
  }

    /**
     * 1.搜索插入位置
     * @param data
     * @param target
     * @return
     */
  public static int searchCorrectIndex(int[] data, int target){
      int l = 0;
      int h = data.length - 1;
      while (l <= h){
          int mid = l + (h - l) / 2;
          if(data[mid] == target){
              return mid;
          }else if(data[mid] > target){
              h = mid - 1;
          }else {
              l = mid + 1;
          }
      }
      return l;
  }

    /**
     *2.移除元素
     * @param data
     * @return
     */
  public static int removeDuplicate(int[] data, int target){
      int slow = 0;
      int fast = 0;
      while (fast < data.length){
          if(data[fast] != target){
              data[slow++] = data[fast];
          }
          fast++;
      }
      return slow;
  }

    /**
     * 3.two sum问题
     * @param data
     * @param sum
     * @return
     */
  public static boolean twoSum(int[] data, int sum){
        Arrays.sort(data);
        int l = 0;
        int h = data.length - 1;
        while (l < h){
            if(sum - data[l] == data[h]){
                return true;
            }else if(sum - data[l] > data[h]){
                l++;

            }else {
                h--;
            }
        }
        return false;
  }
    public static boolean twoSum(int[] data, int sum, int i, int j){
        Arrays.sort(data);
        int l = i;
        int h = j;
        while (l < h){
            if(sum - data[l] == data[h]){
                return true;
            }else if(sum - data[l] > data[h]){
                l++;

            }else {
                h--;
            }
        }
        return false;
    }

    /**
     * 4.three sum 问题
     * @param data
     * @param sum
     * @return
     */
    public static boolean threeSum(int[] data, int sum){
        Arrays.sort(data);
        for(int i = 0; i < data.length; i++){
            int target =sum - data[i];
            if(twoSum(data, target, i, data.length - 1)){
                return true;
            }
        }
        return false;
    }

    /**
     * 5.merge two sorted array
     * @param a1
     * @param a2
     * @return
     */
    public static int[] merge(int[] a1, int[] a2){
        if(null == a1){
            return a2;
        }
        if(null == a2){
            return a1;
        }
        int[] result = new int[a1.length + a2.length];
        int i1 = 0;
        int i2 = 0;
        for(int i = 0; i < result.length ; i++){
            if(i1 >= a1.length){
                result[i] = a2[i2++];
            }else if(i2 >= a2.length){
                result[i] = a1[i1++];
            }else if(a1[i1] < a2[i2]){
                result[i] = a1[i1++];
            }else {
                result[i] = a2[i2++];
            }
        }
        return result;
    }

    /**
     * 6.数组中有多少个子数组满足子数组的和为target
     * @param data
     * @param target
     * @return
     */
    public static int numOfTargetSum(int[] data, int target){
        int count = 0;
        int[] preSum = new int[data.length];//储存[0 - i]之间的元素的和
        for(int i = 0; i < data.length; i++){
            if(i == 0){
                preSum[i] = data[i];
            }else{
                preSum[i] = preSum[i - 1] + data[i];
            }
        }
        for(int i = 0; i < data.length; i++){
            for(int j = i; j < data.length; j++){
                int sum = 0;
                if(i == 0){
                    sum = preSum[j];
                }else {
                    sum = preSum[j] - preSum[i - 1];
                }
                if(sum == target){
                    count++;
                }
            }

        }
        return count;
    }



    /**
     * 7.删除数组里面的特定元素，返回新数组的长度
     * 思想:
     * 1. 双指针, slow的位置存放合法元素, fast用于在前面寻找合法的元素
     * 2. fast找到合法元素的时候跟新slow位置的值，同时slow++
     *
     */
    public static int remove(int[] data, int target){
        int slow = 0;//将要要放置元素的index
        int fast = 0;
        while (fast < data.length){
            if(data[fast] != target){
                data[slow] = data[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
    /**
     * 8.将数组中的0移动到数组的末尾,这里要看需不需要保证非零元素的相对位置
     * _1:保证相对顺序
     * _2:不保证相对顺序
     */
    public static void moveZero_1(int[] data){
        int slow = 0;
        int fast = 0;
        while (fast < data.length){
            if(data[fast] != 0){
                data[slow] = data[fast];
                slow++;
            }
            fast ++;
        }
        for(int i = slow; i < data.length; i++){
            data[i] = 0;
        }
    }
    public static void moveZero_2(int[] data){
        int l = 0;
        int h = data.length - 1;
        while (l < h){
            while (l < h && data[l] != 0){
                l++;
            }
            while (l < h && data[h] == 0){
                h--;
            }
            if(l < h){
                swap(data, l, h);
                l++;
                h--;
            }
        }
    }

    /**
     *9.有序数组去除重复,要求in-place，返回新数组的长度
     *
     */
    public static int removeDuplicate(int[] data){
        int slow = 0;//将要要放置元素的index
        int fast = 0;
        while (fast < data.length){
            if(fast == 0 || data[fast] != data[fast - 1]){
                data[slow] = data[fast];
                slow ++;
            }
            fast++;
        }
        return slow;
    }

    /**
     *10. 将字符串中的空格replace成20%
     *
     */
    public static String replaceWith(String s){
        char[] cs = s.toCharArray();
        int blankCount = 0;
        for(int i = 0; i < cs.length; i++){
            char c = cs[i];
            if(c == ' '){
                blankCount++;
            }
        }
        char[] newCs = new char[cs.length + blankCount * 2];
        int i = cs.length - 1;
        int j = newCs.length - 1;
        while (j >= 0){
            if(cs[i] == ' '){
                newCs[j--] = '%';
                newCs[j--] = '0';
                newCs[j--] = '2';
            }else{
                newCs[j--] = cs[i];
            }
            i--;
        }
        return String.valueOf(newCs);
    }

    /**
     * 11.给定一个无序数组，求每个元素后面最近的比当前元素大的元素的index
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
    public static void swap(int[] data, int i, int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
    /**
     * 12.有序数组中删除重复元素，返回新数组的长度
     */
    public static int removeDuplicates(int[] data){
        if(null == data || data.length == 0){
            return 0;
        }
        int slow = 0;
        int fast = 1;
        while (fast < data.length){
            if(data[fast] != data[slow]){
                data[++slow] = data[fast];
            }
            fast++;
        }
        return slow + 1;
    }
    /**
     * 13.twoSum,找出所有满足的twoSum组合
     */
    public static List<List<Integer>> twoSum_all(int[] data, int sum){
        if(null == data || data.length < 2){
            return null;
        }
        Arrays.sort(data);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < data.length; i++){
            int target = sum - data[i];
            int index = search(data, target);
            if(index > i){
                List<Integer> record = new ArrayList<>();
                record.add(data[i]);
                record.add(data[index]);
                result.add(record);
            }
        }
        return result;
    }

    public static int search(int[] data, int target){
        int l = 0;
        int h = data.length - 1;
        while(l <= h){
            int mid = l + (h - l) / 2;
            if(data[mid] == target){
                return mid;
            }else if(data[mid] > target){
                h = mid -1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }

}
