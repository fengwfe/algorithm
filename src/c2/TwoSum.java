package c2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {
    public static void main(String[] args) {
        int[] data= {1, 5, 2, 10, 8, 0};
        System.out.println(hasTwoSum(data, 14));
        System.out.println(twoSum(data,  10));
    }

    public static boolean hasTwoSum(int[] data, int sum){
        if(null == data || data.length < 2){
            return false;
        }
        Arrays.sort(data);
        int i = 0;
        int j = data.length - 1;
        while(i < j){
            int tmp = sum - data[i];
            if(tmp == data[j]){
                return true;
            }else if(tmp > data[j]){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }

    public static List<List<Integer>> twoSum(int[] data, int sum){
        if(null == data || data.length < 2){
            return null;
        }
        Arrays.sort(data);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < data.length; i++){
            int target = sum - data[i];
            int index = search(data, target);
            if(index > i){
                List<Integer> record = new ArrayList<>();
                record.add(data[i]);
                record.add(data[index]);
                result.add(record);
            }
        }
        return result;
    }

    public static int search(int[] data, int target){
        int l = 0;
        int h = data.length - 1;
        while(l <= h){
            int mid = l + (h - l) / 2;
            if(data[mid] == target){
                return mid;
            }else if(data[mid] > target){
                h = mid -1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }

}
