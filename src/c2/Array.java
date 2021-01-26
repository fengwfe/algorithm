package c2;

import common.ArrayUtil;

public class Array {
    public static void main(String[] args) {
        int[] a1 = {1, 3, 5, 7};
        int[] a2 = {6};
        ArrayUtil.print(merge(a1, a2));

    }
    public static int[] merge(int[] a1, int[] a2){
        if(null == a1){
            return a2;
        }
        if(null == a2){
            return a1;
        }
        int[] result = new int[a1.length + a2.length];
        int i = 0;
        int j = 0;
        for(int k = 0; k < result.length ; k++){
            if(i >= a1.length){
                result[k] = a2[j++];
            }else if(j >= a2.length){
                result[k] = a1[i++];
            }else if(a1[i] < a2[j]){
                result[k] = a1[i++];
            }else {
                result[k] = a2[j++];
            }
        }
        return result;
    }
}
