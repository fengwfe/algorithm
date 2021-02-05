package com.fuwu.good.slidingWindow;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1.最长无重复子串
 * 2.至多包含 K 个不同字符的最长子串
 * 3.最大连续1的个数 ,给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。返回仅包含 1 的最长（连续）子数组的长度
 * 4.替换后的最长重复字符
 * 5.最小覆盖子串
 * 6.长度为 K 的无重复字符子串 的个数-- 定长窗口问题
 * 7.字符串的排列
 * 8.长度最小的子数组
 *
 */
public class HelloSlidingWindow {

  public static void main(String[] args) {
    //    System.out.println(longestNonDuplicate("123612034456"));
    //    System.out.println(longestSubstringKDistinct("113112221", 2));
    //    System.out.println(longestNumOf1(new int[]{1,1,0,1,0,0,0,1,1,1,1,0},2));
    //    System.out.println(longestDuplicateAfterReplace("AABABBA"  ,  3));
    //    System.out.println(minCover("aba","aa"));
    //    System.out.println(numOfKLengthNonDuplicate("heyfriendshowareyou",  5));

    //    System.out.println(containsPermutation("dcda","adc"));
    System.out.println(minLengthSum(new int[]{2,3,1,2,4,3}, 7));
  }

    /**
     * 1.最长无重复子串
     * Tag: 求最长
     * @param s
     * @return
     */
  public static String longestNonDuplicate(String s){
      Set<Character> window = new HashSet<>();
      int i = 0;
      String result = null;
      for(int j = 0; j < s.length(); j++){
//          char c = s.charAt(j);
//          if(!window.contains(c)){//窗口合法，更新结果
//              window.add(c);
//              if(result == null){
//                  result = s.substring(i, j + 1);
//              }else{
//                  result = result.length() > j - i + 1 ? result : s.substring(i, j + 1);
//              }
//          }else {//不合法，缩小窗口直到窗口合法
//              while (window.contains(c)){
//                  window.remove(s.charAt(i++));
//              }
//              window.add(c);
//          }
          char c = s.charAt(j);
          boolean nonDuplicated = window.add(c);
          if(nonDuplicated){
              if(null == result){
                  result = s.substring(i, j + 1);
              }else {
                  result = result.length() > j - i + 1 ? result : s.substring(i, j + 1);
              }
          }else{
              while (s.charAt(i) != c){
                  window.remove(s.charAt(i++));
              }
              i++;

          }
      }
      return result;
  }

    /**
     * 2.至多包含 K 个不同字符的最长子串
     * Tag: 求最长s
     * @param s
     * @param k
     * @return
     */
  public static int longestSubstringKDistinct(String s, int k){
      HashMap<Character, Integer> window = new HashMap();
      int i = 0;
      int result =  0;
      for(int j = 0; j < s.length(); j++){
          char c = s.charAt(j);
          window.put(c, window.getOrDefault(c, 0) + 1);
          if(window.keySet().size() <= k){
              result = Math.max(result, j - i + 1);
          }else{
              while (window.keySet().size() > k){
                  char c2 = s.charAt(i);
                  window.put(c2, window.get(c2) - 1);
                  if(window.get(c2) == 0){
                      window.remove(c2);
                  }
                  i++;
              }
          }
      }
      return result;
  }

    /**
     * 3.最大连续1的个数 ,给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。返回仅包含 1 的最长（连续）子数组的长度
     * @param nums
     * @param k
     * @return
     */
  public static int longestNumOf1(int[]nums, int k){
//      HashMap<Integer, Integer> window = new HashMap<>();
//      int i = 0;
//      int result =  0;
//      for(int j = 0; j < nums.length; j++){
//          int data = nums[j];
//          window.put(data, window.getOrDefault(data, 0) +  1);
//          if(window.getOrDefault(0,0) <=  k){
//              result = Math.max(result, j - i + 1);
//          }else{
//              while (nums[i] != 0){
//                  window.put(nums[i], window.get(nums[i]) - 1);
//                  i++;
//              }
//              window.put(0, window.get(0) - 1);
//              i++;
//          }
//      }
//      return result;

      int window = 0;
      int i = 0;
      int result =  0;
      for(int j = 0; j < nums.length; j++){
          int data = nums[j];
          if(data == 0){
              window++;
          }
          if(window <=  k){
              result = Math.max(result, j - i + 1);
          }else{
              while (window > k){
                  if(nums[i] == 0){
                      window--;
                  }
                  i++;
              }
          }
      }
      return result;
  }

    /**
     * 4.替换后的最长重复字符
     * @param s
     * @param k
     * @return
     */
  public static int longestDuplicateAfterReplace(String s, int k){
      Map<Character, Integer> map = new HashMap<>();
      int i = 0;
      int result = 0;
      for(int j = 0; j < s.length(); j ++){
          char c = s.charAt(j);
          map.put(c, map.getOrDefault(c, 0) + 1);
          if(isValid(map, k)){
              result = Math.max(result, j - i + 1);
          }else{
              while (!isValid(map, k)){
                  char c2 = s.charAt(i);
                  map.put(c2, map.get(c2) -  1);
                  i++;
              }
          }
      }
      return result;
  }

  public static boolean isValid(Map<Character, Integer> map, int k){
     int totalCount = 0;
     int max  =  0;
     Set<Character> keys = map.keySet();
     for(Character key : keys){
         int size = map.get(key);
         totalCount +=  size;
         max = Math.max(max, size);
     }
     if(totalCount - max <= k){
         return true;
     }
     return false;

  }

    /**
     * 5.最小覆盖子串
     * @param s
     * @param t
     * @return
     */

  public static String minCover(String s, String t){
      Map<Character, Integer> need = new HashMap<>();
      Map<Character, Integer> window = new HashMap<>();
      for(int i = 0; i < t.length();  i++){
          char c = t.charAt(i);
          need.put(c, need.getOrDefault(c, 0)  + 1);
      }
      int  i  =  0;
      int match = 0;
      String result = "";
      for(int j  = 0;  j < s.length(); j++){
          char c = s.charAt(j);
          window.put(c, window.getOrDefault(c, 0)  + 1);
          if(c == 'a' && window.get('a') ==371 ){
        System.out.println("");
          }
//          if(need.containsKey(c) && window.get(c) == need.get(c)){//不能这样比较，会不准确
          if(need.containsKey(c) && window.get(c).compareTo(need.get(c)) ==  0 ){
              match++;
          }
          while (match == need.keySet().size()){
              String newR = s.substring(i, j + 1);
              result = result.length() == 0 || result.length() > newR.length() ? newR : result;
              char c2 = s.charAt(i);
              window.put(c2,window.get(c2)  -  1);
              if(need.containsKey(c2) && window.get(c2)  < need.get(c2)){
                  match--;
              }
              i++;
          }
      }
      return result;
  }

    /**
     * 6.长度为 K 的无重复字符子串 的个数-- 定长窗口问题
     * @param s
     * @param k
     * @return
     */
  public static int numOfKLengthNonDuplicate(String s, int k){
      Set<Character> window = new HashSet<>();
      int i = 0;
      int result = 0;
      for(int  j = 0;  j < s.length(); j++){
          char c = s.charAt(j);
          boolean nonDuplicated = window.add(c);
          if(nonDuplicated){
              if(window.size()  ==  k){
                  result++;
                  window.remove(s.charAt(i));
                  i++;
              }
          }else{
              while (s.charAt(i) != c){
                  window.remove(s.charAt(i));
                  i++;
              }
              i++;
          }
      }
      return result;
  }

    /**
     * 7.字符串的排列
     * https://leetcode.com/problems/permutation-in-string/
     * @param s
     * @param t
     * @return
     */
  public static boolean containsPermutation(String s, String t){
      Map<Character, Integer> need = new HashMap<>();
      Map<Character, Integer> window = new HashMap<>();
      for(int i = 0; i < t.length(); i++){
          char c = t.charAt(i);
          need.put(c, need.getOrDefault(c, 0) + 1);
      }
      int i = 0;
      int match  = 0;
      for(int j  =  0;  j < s.length(); j++){
          char c = s.charAt(j);
          if(!need.containsKey(c)){//开新窗口
              i = j + 1;
              window = new HashMap<>();
              match = 0;
              continue;
          }
          window.put(c, window.getOrDefault(c, 0)  + 1);
          if(window.get(c).equals(need.get(c))){
              match++;
          }else if(window.get(c) - need.get(c) == 1){
              //match--; 把 c remove掉后c 就match了，所以不需要--
              while (s.charAt(i) != c){
                  char c2 = s.charAt(i);
                  window.put(c2, window.get(c2) - 1);
                  if(window.get(c2) == need.get(c2) - 1){
                      match--;
                  }
                  i++;
              }
              char c2 = s.charAt(i);
              window.put(c2, window.get(c2) - 1);
              i++;
          }
          if(j - i + 1 == t.length()){
              if(match == need.keySet().size()){
                  return true;
              }
          }

      }
      return false;
  }

    /**
     * 8.长度最小的子数组
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0
     * @param data
     * @param targetSum
     * @return
     */
  public static int minLengthSum(int[] data, int targetSum){
      int window = 0;
      int i = 0;
      int result = Integer.MAX_VALUE;
      for(int j = 0; j < data.length; j++){
          window += data[j];
          while (window >= targetSum){
              result = Math.min(j - i + 1, result);
              window -= data[i];
              i++;
          }
      }
      return result  == Integer.MAX_VALUE ? 0 : result;
  }

//  public static boolean aa(String s, String t){
//      int[] data = new int[]{2 ,3 ,5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 91, 97};
//      BigInteger b1  = new BigInteger("1");
//      BigInteger b2  = new BigInteger("1");
//      for(int i = 0; i < t.length(); i++){
//          b2 = b2.multiply(BigInteger.valueOf(data[t.charAt(i) - 'a']));
//      }
//      int i = 0;
//      int j = 0;
//      while (j < s.length()){
//          b1 = b1.multiply(BigInteger.valueOf(data[s.charAt(j) - 'a']));
//          if(j -i + 1 == t.length()){
//              if(b1.equals(b2)){
//                  return true;
//              }else{
//                  b1  = b1.divide(BigInteger.valueOf(data[s.charAt(i) - 'a']));
//                  i++;
//              }
//
//          }
//          j++;
//      }
//      return false;
//  }


}
