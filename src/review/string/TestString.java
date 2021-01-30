package review.string;

import common.Printer;

import java.util.*;

/**
 * 1.反转
 * 2.单词反转
 * 3.回文
 * 4.同构
 * 5.异序
 * 6.最长回文子串
 * 7.字符串转数字
 * 8.旋转
 * 9,最长公共子串
 * 10,最长公共子序列
 * 11.字符串乘法
 * 12.判断是否为子序列
 * 13.判断是否是子串--KMP?
 * 14.判断括号的合法性
 *
 *
 */
public class TestString {
    public static void main(String[] args) {
//        String s1 = "zabcde";
//        String s2 = "a2c1d2e";//acez
//        System.out.println(lcs(s1,s2,s1.length() - 1, s2.length() - 1, new HashMap<>()));
        multiply("66","6");

    }

    /**
     * 最长公共子序列
     *
     */
    public static int lcs(String s1, String s2, int i, int j, Map<String,Integer> cache){
        if(i < 0 || j < 0){
            return 0;
        }
        String key = i + "_" + j;
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        if(s1.charAt(i) == s2.charAt(j)){
             int result = 1 + lcs(s1, s2, i - 1, j - 1, cache);
             cache.put(i+"_"+j, result);
             return result;
        }else{
            int r1 = lcs(s1, s2, i - 1, j, cache);
            int r2 = lcs(s1, s2, i, j - 1, cache);
            if(r1 >  r2){
                cache.put( i - 1 +"_" + j, r1);
                return r1;
            }else {
                cache.put( i +"_" + (j  -  1), r2);
                return r2;
            }
        }
    }

    /**
     *最长公共子串
     *
     */
    public static int lcs_02(String s1, String s2){
        int result =  0;
        Map<String, Integer> cache =  new HashMap<>();
        for(int i = 0;  i  < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                result = Math.max(result,lcs_02_helper(s1, s2, i, j, cache));
            }
        }
        return result;
    }

    public static int lcs_02_helper(String s1, String s2, int i, int j, Map<String, Integer> cache){
        if(i < 0  || j <  0){
            return 0;
        }
        String key =  i + "_" + j;
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        if(s1.charAt(i)  !=  s2.charAt(j)){
            cache.put(key, 0);
            return 0;
        }
        int result =  lcs_02_helper(s1, s2, i -  1, j - 1, cache)  +  1;
        cache.put(key, result);
        return result;
    }
    /**
     * 单词反转
     */
    public static String reverseWord(String s){
        char[] cs = s.toCharArray();
        Integer start = null;
        Integer end = 0;
        while (end < cs.length){
            char c = cs[end];
            if(c != ' '){
                if(null == start){
                    start = end;
                }
            }else{
                if(null != start){
                    int i = start;
                    int j = end - 1;
                    while (i < j){
                        char tmp = cs[i];
                        cs[i] = cs[j];
                        cs[j] = tmp;
                        i++;
                        j--;
                    }
                    start = null;
                }

            }
            end++;
        }
        if(null != start){
            int i = start;
            int j = end - 1;
            while (i < j){
                char tmp = cs[i];
                cs[i] = cs[j];
                cs[j] = tmp;
                i++;
                j--;
            }
            start = null;
        }
        return String.valueOf(cs);
    }

    /**
     *字符串乘法
     *
     */

    public static void multiply(String a, String b){
        Integer[] result = new Integer[a.length() + b.length()];
        Arrays.fill(result, 0);

        for(int i = a.length() -1; i >= 0; i--){
            for(int j = b.length() - 1; j >= 0; j--){
                int mul = (a.charAt(i) - '0') * (b.charAt(j) - '0');
                int p1 = i + j;
                int p2  = i + j + 1;
                int sum = mul + result[p2];
                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }
        Printer.print(result);
    }
}
