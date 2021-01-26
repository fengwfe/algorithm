package c2;

import common.ArrayUtil;

public class DuplicateElement {
    public static void main(String[] args) {
//        int[] data = {1,2,3,5,3,6,3,9};
//        int a =  remove(data, 3);
//        System.out.println(a);
//        ArrayUtil.print(data);

//        int[] data  =  {0,0,1,2,3,3,4,5,6,6};
//        System.out.println(removeDuplicate(data));
//        ArrayUtil.print(data);
        System.out.println(replaceWith(" Hello FUWU "));

    }

    /**
     * 删除数组里面的特定元素，返回新数组的长度
     * 思想:
     * 1. 双指针, slow的位置存放合法元素, fast用于在前面寻找合法的元素
     * 2. fast找到合法元素的时候跟新slow位置的值，同时slow++
     *
     */
    public static int remove(int[] data, int target){
        int slow = 0;//将要要放置元素的index
        int fast = 0;
        while (fast < data.length){
            if(data[fast] != target){
                data[slow] = data[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
    /**
     * 将数组中的0移动到数组的末尾,这里要看需不需要保证非零元素的相对位置
     * _1:保证相对顺序
     * _2:不保证相对顺序
     */
    public static void moveZero_1(int[] data){
        int slow = 0;
        int fast = 0;
        while (fast < data.length){
            if(data[fast] != 0){
                data[slow] = data[fast];
                slow++;
            }
            fast ++;
        }
        for(int i = slow; i < data.length; i++){
            data[i] = 0;
        }
    }
    public static void moveZero_2(int[] data){
        int l = 0;
        int h = data.length - 1;
        while (l < h){
            while (l < h && data[l] != 0){
                l++;
            }
            while (l < h && data[h] == 0){
                h--;
            }
            if(l < h){
                swap(data, l, h);
                l++;
                h--;
            }
        }
    }

    /**
     *有序数组去除重复,要求in-place，返回新数组的长度
     *
     */
    public static int removeDuplicate(int[] data){
        int slow = 0;//将要要放置元素的index
        int fast = 0;
        while (fast < data.length){
            if(fast == 0 || data[fast] != data[fast - 1]){
                data[slow] = data[fast];
                slow ++;
            }
            fast++;
        }
        return slow;
    }

    /**
     *将字符串中的空格replace成20%
     *
     */
    public static String replaceWith(String s){
        char[] cs = s.toCharArray();
        int blankCount = 0;
        for(int i = 0; i < cs.length; i++){
            char c = cs[i];
            if(c == ' '){
                blankCount++;
            }
        }
        char[] newCs = new char[cs.length + blankCount * 2];
        int i = cs.length - 1;
        int j = newCs.length - 1;
        while (j >= 0){
            if(cs[i] == ' '){
                newCs[j--] = '%';
                newCs[j--] = '0';
                newCs[j--] = '2';
            }else{
                newCs[j--] = cs[i];
            }
            i--;
        }
        return String.valueOf(newCs);
    }



    public static void swap(int[] data, int i, int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
