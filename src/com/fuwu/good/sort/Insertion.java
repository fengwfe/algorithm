package com.fuwu.good.sort;

/**
 *插入排序
 * 1.从左到右处理整个数组，左侧子数组只有一个元素时，左侧子数组已经有序
 * 2.将index处的元素插入左侧子数组，保证左侧子数组有序
 * 3.所有元素都插入左侧子数组时，处理结束，整个数组有序
 *
 *
 */
public class Insertion {
    public static void main(String[] args) {

    }
    public static void sort(int[] data){
        for(int i = 1; i < data.length; i++){
            int j = i;
            while(j > 0 && data[j] < data[j - 1]){
                swap(data, j - 1, j);
                j--;
            }
        }
    }
    public static void swap(int[] data, int i, int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
