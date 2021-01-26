package search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7};
        System.out.println(search(data,4));

    }

    public static int search(int[] data, int target){
        int l = 0;
        int h = data.length - 1;
        while (l <= h){
            int mid = l + (h - l) / 2;
            if(data[mid] == target){
                return mid;
            }else if(data[mid] > target){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }
}
