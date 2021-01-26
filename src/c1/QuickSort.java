package c1;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
//        int[] array = new int[]{3,  2, 2,1, 3,3};
//        sort(array, 0, array.length - 1);
//        for(int a: array){
//            System.out.println(a);
//        }


    }

    public static void sort(int[] data, int start, int end){
        if(start >= end){
            return;
        }
        int i = start;
        int j = end;
        while(i != j){
            while (j > i && data[j] >= data[i]){
                j--;
            }
            swap(data, i, j);
            while (i < j && data[i] <= data[j]){
                j--;
            }
            swap(data, i, j);
        }
        System.out.println(i+"=========="+data[i]);
        sort(data, start, i-1);
        sort(data, j + 1, end);
    }

    public static void swap(int[] data, int i, int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] =tmp;
    }
}
