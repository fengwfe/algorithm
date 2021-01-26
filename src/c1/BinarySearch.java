package c1;

import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] data = new int[]{1,3,7,8,11,89};
        System.out.println(binarySearch(70, data));
        List<Integer> list = null;
        for(int a : list){
            System.out.println(a);
        }

    }
    public static int binarySearch(int key, int[] data){
        int l = 0;
        int h = data.length -1;
        while(l <= h){
            int mid = l + (h - l) / 2;
            if(data[mid] == key){
                return mid;
            }else if(data[mid] > key){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }
}
