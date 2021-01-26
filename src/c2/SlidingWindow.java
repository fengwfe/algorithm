package c2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SlidingWindow {

    public static void main(String[] args) {
//        String s = "abc1234456789011";
//        System.out.println(p1(s));
        System.out.println(p2("abcca02da", "ad33"));
    }

    /**
     * 给定字符串中最长不含重复字符的子串
     */

    public static String p1(String s){
        if(null == s || s.length() <= 1){
            return s;
        }
        int left = 0;
        int right = 0;
        int start = 0;
        int max = 0;
        Set<Character> window = new HashSet<>();
        while( right < s.length()){
            char c = s.charAt(right);
            boolean added = window.add(c);
            right++;
            while(!added){
                if(right - left - 1 > max){
                    max = right - left - 1;
                    start = left;
                }
                char c2 = s.charAt(left);
                window.remove(c2);
                left++;
                added = window.add(c);
            }
        }
        if(window.size() > max){
            start = left;
            max = window.size();
        }
        return s.substring(start, start + max);
    }

    /**
     * 最小覆盖子串,给定字符串S, T,找出S的最小子串满足：子串中包含T中所有字符
     *
     */

    public static String p2(String s, String t){
        int left = 0;
        int right = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int matchCount = 0;
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        while (right < s.length()){
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            right++;
            if(window.get(c) == need.get(c)){
                matchCount++;
            }
            while (matchCount == need.keySet().size()){
                if(right - left < min){
                    min = right - left;
                    start = left;
                }
                char c2 = s.charAt(left);
                window.put(c2, window.get(c2) - 1);
                if(need.containsKey(c2) && window.get(c2) < need.get(c2)){
                    matchCount--;
                }
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }

}
