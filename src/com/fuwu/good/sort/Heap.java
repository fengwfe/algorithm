package com.fuwu.good.sort;

import common.ArrayUtil;

public class Heap {
    public static void main(String[] args) {
        int[] data = {10, 0, 2, 6, 1 , 8};
        sort(data);
        ArrayUtil.print(data);

    }

    /**
     * heap sort
     * @param data
     */
    public static void sort(int[] data){
        int size = data.length;
        for(int i = data.length / 2 -  1; i >= 0; i--){//构建最大堆
            heapify(data, size, i);
        }
        while (size > 0){
            swap(data, 0, size - 1);
            size--;
            heapify(data, size, 0);
        }
    }

    /**
     * 左右子树都是maxHeap时，怎么让整棵树满足maxHeap的要求
     * @param data
     * @param heapSize
     * @param i
     */
    public static void heapify(int[] data, int heapSize, int i){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if(left < heapSize && data[left] > data[largest]){
            largest = left;
        }
        if(right < heapSize && data[right] > data[largest]){
            largest = right;
        }
        if(largest != i){
            swap(data, largest, i);
            heapify(data, heapSize, largest);
        }

    }

    public static void swap(int[] data, int i, int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

}
