package com.fuwu.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 字符串反转
 * 2. 单词反转
 * 3. 一个字符串是否可以通过旋转得到另一个字符串
 * 4. 将字符串中的空格replace成20%
 * 5. 判断字符串是否是回文
 * 6. 求最长回文子串
 * 7. 异序词
 * 8. 字符串乘法
 * 9. 字符串加法
 * 9. add binary
 * 10. Longest substring without repeating characters
 * 11.Longest consecutive sequence
 * 12.最长公共前缀
 *
 */
public class HelloString {
    public static void main(String[] args) {
//        System.out.println(differOrder("123","213"));
//        System.out.println(multiply("66",  "66"));
        System.out.println(add("99999", "999"));
    }
    /**
     *  1. 字符串反转
     * @param s
     * @return
     */
    public static String reverse(String s){
        if(null == s){
            return s;
        }
        int i = 0;
        int j = s.length() - 1;
        char[] cs = s.toCharArray();
        while (i < j){
            swap(cs, i, j);
            i++;
            j--;
        }
        return String.valueOf(cs);
    }

    /**
     *  2. 单词反转
     * @param s
     * @return
     */
    public static String reverseWord(String s){
        if(null == s){
            return s;
        }
        char[] cs = s.toCharArray();
        Integer start = null;
        Integer end = 0;
        while (end < cs.length){
            char c = cs[end];
            if(c == ' '){
                if(null != start){
                    int i = start;
                    int j = end - 1;
                    while (i < j){
                        swap(cs, i, j);
                        i++;
                        j--;
                    }
                    start = null;
                }

            }else{
                if(null == start){
                    start = end;
                }
            }
            end++;
        }
        if(null != start){
            int i = start;
            int j = end - 1;
            while (i < j){
                swap(cs, i, j);
                i++;
                j--;
            }
        }
        return String.valueOf(cs);
    }

    /**
     * 3.一个字符串是否可以通过旋转得到另一个字符串
     * @param s
     * @param t
     * @return
     */
    public static boolean canRotateTo(String s, String t){
        if(null == s || null == t){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        return (s+s).contains(t);
    }

    /**
     * 4. 将字符串中的空格replace成20%
     * @param s
     * @return
     */
    public static String replace(String s){
        if(null  == s){
            return s;
        }
        char[] cs  = s.toCharArray();
        int count = 0;
        for(int i = 0; i < cs.length; i++){
            char c = cs[i];
            if(c == ' '){
                count++;
            }
        }
        char[] newCs = new char[cs.length + count * 2];
        int i =  cs.length - 1;
        int j =  newCs.length - 1;
        while (j >= 0){
            char c = cs[i];
            if(c == ' '){
                newCs[j--] = '%';
                newCs[j--] = '0';
                newCs[j--] = '2';
            }else {
                newCs[j--] = c;
            }
            i--;
        }
        return String.valueOf(newCs);
    }

    /**
     * 5. 判断字符串是否是回文
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s){
        if(null == s){
            return false;
        }
        int i =  0;
        int j  = s.length() - 1;
        while (i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 求最长回文子串
     * @param s
     * @return
     */
    public static String maxSubPalindrome(String s){
        String result = "";
        for(int i  = 0;  i < s.length(); i++){
            String s1 = expand(s, i, i);
            String s2 = expand(s, i, i + 1);
            result = result.length() > s1.length() ? result : s1;
            result = result.length() > s2.length() ? result : s2;
        }
        return result;
    }

    /**
     * 7. 异序词
     * @param s
     * @param t
     * @return
     */
    public static boolean differOrder(String s, String t){
        if(null == s || null == t || s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> counts = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!counts.containsKey(c)){
                return false;
            }else {
                if(counts.get(c) <= 0){
                    return false;
                }
                counts.put(c, counts.get(c) - 1);
            }
        }
        return true;
    }

    /**
     * 12.最长公共前缀
     * @param data
     * @return
     */
    public static String lcPrefix(String[] data){
        if(null == data || data.length < 1){
            return null;
        }
        StringBuffer bf = new StringBuffer();
        String result = data[0];
        for(int i = 1; i < data.length; i++){
            String s = data[i];
            bf = new StringBuffer();
            int j = 0;
            while (j < result.length() && j < s.length()){
                char c1 = s.charAt(j);
                char c2 = result.charAt(j);
                if(c1 == c2){
                    bf.append(c1);
                }else{
                    break;
                }
                j++;
            }
            result = bf.toString();
        }
        return result;
    }

    /**
     * 8. 字符串乘法
     * @param s1
     * @param s2
     * @return
     */
    public static String multiply(String s1, String s2){
        int[] data = new int[s1.length() + s2.length()];
       for(int i = s1.length() - 1; i >= 0; i--){
           for(int j = s2.length() - 1; j >= 0; j--){
               char c1 = s1.charAt(i);
               char c2 = s2.charAt(j);
               int p1 = i + j;
               int p2 = i + j + 1;
               int multiply = (c1 - '0') * (c2 - '0');
               int sum = multiply + data[p2];
               data[p2] = sum % 10;
               data[p1]+= sum / 10;
           }
       }
       StringBuffer bf = new StringBuffer();
       for(int d: data){
           bf.append(d);
       }
       return bf.toString();
    }

    public static String add(String s1, String s2){
        int[] data = new int[Math.max(s1.length() ,s2.length()) + 1];
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int k = data.length - 1;
        int carry = 0;
        while (i  >= 0  && j  >=  0){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            int sum = (c1 - '0') + (c2 -  '0') + carry;
            data[k] = sum % 10;
            carry =  sum / 10;
            i--;
            j--;
            k--;
        }
        while (i >= 0){
            char c1 = s1.charAt(i);
            int sum = (c1 - '0') + carry;
            data[k] = sum % 10;
            carry =  sum / 10;
            i--;
            k--;
        }
        while (j >= 0){
            char c2 = s2.charAt(j);
            int sum = (c2 - '0') + carry;
            data[k] = sum % 10;
            carry =  sum / 10;
            j--;
            k--;
        }
        StringBuffer bf = new StringBuffer();
        if(carry > 0){
            data[k] = carry;
        }
        for(int d : data){
            bf.append(d);
        }
        return bf.toString();
    }


    public static String expand(String s, int i, int j){
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

    public static void swap(char[] cs, int i, int j){
        char c = cs[i];
        cs[i] = cs[j];
        cs[j] = c;
    }


}
