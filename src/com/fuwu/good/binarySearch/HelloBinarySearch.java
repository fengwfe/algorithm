package com.fuwu.good.binarySearch;

public class HelloBinarySearch {

    /**
     * 二分查找变形,对旋转排序数组进行查找: {7, 8, 9, 0, 1},数组中没有重复数字
     */

    public static int search(int[] data, int target) {
        int l = 0;
        int h = data.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if(data[mid] == target){
                return mid;
            }
            if(data[mid] > data[data.length - 1]){//mid左侧单调有序
                if(target >= data[l] && target < data[mid]){
                    h = mid - 1;
                }else{
                    l = mid + 1;
                }

            }else{//mid右侧单调有序
                if(target > data[mid] && target <= data[h]){
                    l = mid + 1;
                }else{
                    h = mid - 1;
                }

            }
        }
        return -1;
    }


    /**
     * 二分查找变形，对旋转数组进行查找:{7,7,8,8,9,5,6,7},数组中包含重复数字
     *
     */
    public static int search2(int[] data, int target){
        int l = 0;
        int h = data.length - 1;
        while (l <= h){
            int mid = l + (h - l) / 2;
            if(data[mid] == target){
                return mid;
            }
            if(data[mid] < data[h]){//右侧单调有序
                if(target > data[mid] && target <= data[h]){
                    l = mid + 1;
                }else{
                    h =  mid - 1;
                }
            }else if(data[mid] > data[h]){//左侧单调有序
                if(target >= data[l] && target < data[mid]){
                    h = mid - 1;
                }else{
                    l = mid + 1;
                }

            }else{//处理重复元素的case
                h = h - 1;
            }
        }
        return -1;
    }
    /**
     * 二分查找变形，寻找旋转数组的最大元素(分界元素),数组没有重复元素
     *
     */
    public static int search3(int[] data){
        int l = 0;
        int h = data.length - 1;
        while(l <= h){
            if(l == h){
                return l;
            }
            if(h - l == 1){
                return data[h] > data[l] ? h : l;
            }
            int mid = l + (h - l) / 2;
            if(data[mid] < data[h]){//右侧单调有序
                if(data[h] > data[l]){
                    return h;
                }else{
                    h = mid;
                }
            }else{//左侧单调有序
                l = mid;
            }
        }
        return -1;
    }
}
