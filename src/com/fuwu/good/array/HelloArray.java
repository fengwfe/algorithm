package com.fuwu.good.array;

import java.util.Arrays;

/**
 * 1.搜索插入位置
 * 2.移除元素
 * 3.two sum问题
 * 4.three sum 问题
 * 5.merge two sorted array
 * 6.数组中有多少个子数组满足子数组的和为target
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


}
