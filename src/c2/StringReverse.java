package c2;

public class StringReverse {
    public static void main(String[] args) {
        String s = " hello fuwu";
        System.out.println(reverse2(s));
    }

    /**
     * 直接反转
     * @param s
     * @return
     */
    public static String reverse(String s){
        if(null == s || s.length() == 0){
            return s;
        }
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while(i < j){
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }

    /**
     * 单词反转，分隔符为空格
     * @param s
     * @return
     */
    public static String reverse2(String s){
        if(null == s || s.length() == 0){
            return s;
        }
        char[] chars = s.toCharArray();
        Integer start = null;
        Integer end = null;
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(c != ' '){
                if(null == start){
                    start = i;
                    end = i;
                }else{
                    end = i;
                }
            }else{
                if(null != start && null != end){
                    reverse(chars, start, end);
                    start = null;
                    end = null;
                }
            }
        }
        if(null != start && null != end){
            reverse(chars, start, end);
        }
        return String.valueOf(chars);
    }


    public static void reverse(char[] chars, int l, int h){
        int i = l;
        int j = h;
        while (i < j){
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
    }
}
