package com.fuwu.good.dynamicProgramming;

import java.util.Map;

/**
 * 1.换零钱
 * 2. 最长公共子序列
 * 3. 最长公共子序列的长度
 * 4. 最长公共子串的长度
 */
public class HelloDynamicProgramming {

    public static int coninsExchange(int[] coins, int target, Map<Integer, Integer> cache){
        //如果没有要换的金额了，就不需要换了
        if(target == 0){
            return 0;
        }
        //兑换不出来了
        if(target < 0){
            return -1;
        }
        //性能优化
        if(cache.containsKey(target)){
            return cache.get(target);
        }
        //列出所有可以兑换
        int minCount = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            int coin = coins[i];
            int count = coninsExchange(coins,  target - coin, cache);
            //如果兑换不出来，继续下一个
            if(count  ==  -1){
                continue;
            }else {
                minCount = Math.min(minCount, count + 1);
            }
        }
        minCount = minCount == Integer.MAX_VALUE ? -1 : minCount;
        cache.put(target, minCount);
        return minCount;
    }
    /**
     * 2. 最长公共子序列
     * @param s1
     * @param s2
     * @return
     */
    public static String lcs(String s1, String s2){
        String result = null;
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                String r =  lcs_helper(s1, s2, i, j);
                if(null == result){
                    result = r;
                }else {
                    if(null != result && null != r){
                        result = result.length() > r.length() ? result : r;
                    }
                }
            }
        }
        return result;
    }
    //计算[0...i]和[0...j]的最长公共子序列
    public static String lcs_helper(String s1, String s2, int i, int j){
        if(i < 0 || j < 0){
            return null;
        }
        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);
        if(c1 == c2){
            StringBuffer bf = new StringBuffer();
            String r = lcs_helper(s1,  s2,  i - 1,  j  -  1);
            if(null != r){
                bf.append(r);
            }
            return bf.append(c1).toString();
        }else{
            String r1 = lcs_helper(s1, s2, i - 1, j);
            String r2 = lcs_helper(s1, s2, i, j - 1);
            if(null == r1){
                return r2;
            }
            if(null == r2){
                return r1;
            }
            String result = r1.length() > r2.length() ? r1 : r2;
            return result;
        }
    }

    /**
     * 3. 最长公共子序列的长度
     * @param s1
     * @param s2
     * @return
     */
    public static int lcs_02(String s1, String s2){
        if(null == s1 || null == s2){
            return 0;
        }
        int result = 0;
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                result = Math.max(result, lcs_02_helper(s1, s2, i, j));
            }

        }
        return result;
    }
    public static int lcs_02_helper(String s1, String s2, int i, int j){
        if(i < 0 || j < 0){
            return 0;
        }
        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);
        if(c1 == c2){
            return 1 + lcs_02_helper(s1, s2, i - 1, j - 1);
        }else {
            int r1 = lcs_02_helper(s1, s2, i  -  1, j);
            int r2 = lcs_02_helper(s1, s2, i , j - 1);
            return r1 > r2 ? r1 :  r2;
        }
    }

    /**
     * 4. 最长公共子串的长度
     * @param s1
     * @param s2
     * @return
     */
    public static int lcSubStr(String s1, String s2){
        if(null == s1 || null == s2){
            return 0;
        }
        int result = 0;
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j ++){
                result = Math.max(result, lcSubStr_helper(s1, s2, i, j));
            }
        }
        return result;
    }
    //返回以i,j结尾的公共子串长度
    public static int lcSubStr_helper(String s1, String s2, int i, int j){
        if(i < 0 || j < 0){
            return 0;
        }
        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);
        if(c1 == c2){
            return 1 + lcSubStr_helper(s1, s2, i - 1, j - 1);
        }else {
            return 0;
        }

    }
}
