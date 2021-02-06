package com.fuwu.good.intune;

public class OddEvenPatition {
    public static void main(String[] args) {
        Integer[] data = new Integer[]{1,2,3,4,5,6,7};
        oddEvenPatition(data);
        Printer.print(data);

    }
    public static void oddEvenPatition(Integer[] data){
        if(null == data || data.length == 1){
            return;
        }
        int i = 0;
        int j = data.length - 1;
        while (i < j){
            while (i <j && data[i] % 2 != 0){
                i++;
            }
            while (i < j  && data[j] % 2 == 0){
                j--;
            }
            if(i < j){
                swap(data, i, j);
                i++;
                j--;
            }
        }

    }

    public static void swap(Integer[] data, int i, int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
