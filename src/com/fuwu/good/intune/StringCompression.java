package com.fuwu.good.intune;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compress_2("abbbbbbbbbbbcc".toCharArray()));
        System.out.println(compress_3("abbbbbbbbbbbcc".toCharArray()));

    }
    public static String compress_1(char[] cs){
        if(null == cs){
            return null;
        }
        if(cs.length <2){
            return String.valueOf(cs);
        }
        StringBuffer bf = new StringBuffer();
        int count = 1;
        char cur = cs[0];
        for(int i = 1; i < cs.length; i++){
            char c = cs[i];
            if(c == cur){
                count++;
            }else{
                bf.append(cur).append(count);
                cur = c;
                count = 1;
            }
        }
        bf.append(cur).append(count);
        return bf.toString();
    }


    public static int compress_2(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        System.out.println(String.valueOf(chars));
        return write;
    }

    public static int compress_3(char[] cs){
        if(null == cs ){
            return 0;
        }
        if(cs.length ==  1){
            return 1;
        }
        int blockStartIndex = 0;
        int writeIndex = 0;
        char writeC = cs[0];
        int result = 0;
        for(int i = 1; i < cs.length; i++){
            char c = cs[i];
            if(c != writeC){
                int count = i - blockStartIndex;
                char[] writeCs = count == 1 ? (String.valueOf(writeC)).toCharArray() : (String.valueOf(writeC)+count).toCharArray();
                result += writeCs.length;
                for(int j = 0; j < writeCs.length; j++){
                    cs[writeIndex++] =writeCs[j];
                }
                writeC = c;
                blockStartIndex = i;
            }
        }

        int count = cs.length - blockStartIndex;
        char[] writeCs = count == 1 ? (String.valueOf(writeC)).toCharArray() : (String.valueOf(writeC)+count).toCharArray();
        result += writeCs.length;
        for(int j = 0; j < writeCs.length; j++){
            cs[writeIndex++] =writeCs[j];
        }
        System.out.println(String.valueOf(cs));
        return result;
    }
}
