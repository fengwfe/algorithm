package com.fuwu.intune;

public class ReverseStrirng {
    public static void main(String[] args) {
        System.out.println(reverse_1("the sky is blue.".toCharArray()));

    }

    /**
     * 字符串反转变种,字符串头尾没空格,单词之间只有一个空格
     * https://www.programcreek.com/2014/05/leetcode-reverse-words-in-a-string-ii-java/
     * "the sky is blue."=>"blue. is sky the"
     *
     * solution: 先反转所有单词, 然后再对整个字符串反转
     * @param cs
     * @return
     */
    public static String reverse_1(char[] cs){
        int i = 0;
        for(int j = 0; j < cs.length; j++){
            char c = cs[j];
            if(c == ' '){
                reverse(cs, i, j - 1);
                i = j + 1;
            }
        }
        reverse(cs, i, cs.length - 1);
        reverse(cs, 0, cs.length - 1);
        return String.valueOf(cs);
    }


    public static void reverse(char[] cs, int start, int end){
        int i = start;
        int j = end;
        while (i < j){
            char tmp = cs[i];
            cs[i] = cs[j];
            cs[j] = tmp;
            i++;
            j--;
        }
    }
}
