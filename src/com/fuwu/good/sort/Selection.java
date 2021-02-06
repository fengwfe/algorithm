package com.fuwu.good.sort;

/**
 * 选择排序
 * 1.选出数组中的最大元素，并把该元素放到适当的位置
 * 2.选出数组中次大的元素，并把该元素放置到适当位置
 * 3.一直重复该过程，直到所有元素都放置到适当位置
 */
public class Selection {
    public static void main(String[] args) {
    }
    public static void sort(int[] data){
        for(int i = 0; i < data.length; i++){
            for(int j =1 ; j < data.length - i; j++){
                if(data[j] < data[j - 1]){
                    swap(data,j -1, j);
                }
            }
        }
    }
    public static void swap(int[] data, int i, int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

}
