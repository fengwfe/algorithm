package com.fuwu.good.sort;

/**
 *快速排序
 *1.在数组中选择一个元素作为基准值(pivot),处理数组将数组分为左右2个子数组，使得左边子数组里面的元素都小于等于pivot,右边子数组都大于等于pivot
 *2.递归sort左边子数组，右边子数组
 *
 */
public class Quick {
    public static void main(String[] args) {

    }
    public static void sort(int[] data, int l, int h){
        if(l >= h){
          return;
        }
        int index = partition(data, l, h);
        sort(data, l, index - 1);
        sort(data, index + 1, h);
    }
    public static int partition(int[] data, int l, int h){
        int pivot = data[l];
        int left = l;
        int right = h;
        while (left <= right){
            while(left <= right && data[left] <= pivot){
                left++;
            }
            while (left <= right && data[right] >= pivot){
                right--;
            }
            /**
             * 到这里了有两种可能
             * 1.left < right，需要交换数组位置
             * 2.left > right, 结束循环
             *
             * 不会出现left = right的情况
             *
             */
            if(left < right){
                /**
                 * 交换完可能出现
                 * 1.left > right，但是新的left 和right的位置没有越界,因为只是交换了位置，此时right所在位置的元素<= pivot,left所在位置
                 * 的元素>=pivot
                 * 2.left = right，还得继续循环判断出相遇点和pivot的大小关系
                 * 3.left < right，不是临界点，不需要关心
                 */
                swap(data, left, right);
                left++;
                right--;
            }
        }
       swap(data,l, right);
        return right;
    }
    public static void swap(int[] data, int i, int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
