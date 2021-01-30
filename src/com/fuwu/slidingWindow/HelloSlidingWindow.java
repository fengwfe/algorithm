package com.fuwu.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 最小覆盖子串,(S中的最小子串满足：该子串包含T中的所有字符,字符数量满足)
 *
 */

public class HelloSlidingWindow {
    public static void main(String[] args) {
        System.out.println(minCoverStr("1234456",  "24445"));

    }

    /**
     * 1. 最小覆盖子串,(S中的最小子串满足：该子串包含T中的所有字符)
     *
     * @param s
     * @param t
     * @return
     */
    public static String minCoverStr(String s, String t){
        Map<Character, Integer> counts = new HashMap<>();
        String result = null;
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        int i = 0;
        int j = 0;
        int matched = 0;
        Map<Character, Integer> window = new HashMap<>();
        while (j < s.length()){
            char c = s.charAt(j);
            j++;
            if(counts.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c) == counts.get(c)){
                    matched++;
                }
            }
            while (matched == counts.keySet().size()){
                //更新结果
                String r = s.substring(i, j);
                if(null == result){
                    result = r;
                }else{
                   result = result.length() < r.length() ? result : r;
                }
                //缩小窗口
                char c1 = s.charAt(i);
                if(window.containsKey(c1)){
                    window.put(c1, window.get(c1) - 1);
                    if(window.get(c1) < counts.get(c1)){
                        matched--;
                    }
                }
                i++;
            }
        }
        return result;
    }

}
