package com.fuwu.intune;

public class MissingNum {
    public static void main(String[] args) {
        System.out.println(missing(new int[]{0,1,3}));

    }

    /**
     * 0..n 中missing
     * @param data
     * @return
     */
    public static int missing(int[] data){
        int missing = data.length;
        for(int i = 0; i < data.length; i++){
            missing += i - data[i];
        }
        return missing;
    }
}
