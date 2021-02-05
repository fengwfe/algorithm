package com.fuwu.good.sort;

import common.ArrayUtil;

public class Merge {
    public static void main(String[] args) {
        int[] data = {0,0,13,2,9,6,33,1};
        sort(data, 0, data.length  - 1);
        ArrayUtil.print(data);
    }
    public static void sort(int[] data, int l, int h){
        if(l >= h){
            return;
        }
        int mid = l + (h - l) / 2;
        sort(data, l, mid);
        sort(data, mid + 1, h);
        merge(data, l, mid, h);
    }
    public static void merge(int[] data, int l, int mid, int h){
        int[] right = new int[h - mid];
        int index = 0;
        for(int i = mid + 1; i <= h; i++){
            right[index++] = data[i];
        }
        int leftIndex = mid;
        int rightIndex = right.length - 1;
        for(int i = h; i >= l; i--){
            if(leftIndex < l){
                data[i] = right[rightIndex--];
            }else if(rightIndex < 0){
                data[i] = data[leftIndex--];
            }else if(data[leftIndex] > right[rightIndex]){
                data[i] = data[leftIndex--];
            }else{
                data[i] = right[rightIndex--];
            }
        }
    }
}
