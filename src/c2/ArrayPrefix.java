package c2;

public class ArrayPrefix {
    public static void main(String[] args) {

        int[] data = {1,2,2,1,3,0,3};
        System.out.println(numOfTargetSum(data, 3));

    }
    /**
     * 数组中有多少个子数组满足子数组的和为target
     *
     */

    public static int numOfTargetSum(int[] data, int target){
        int count = 0;
        int[] preSum = new int[data.length];//储存[0 - i]之间的元素的和
        for(int i = 0; i < data.length; i++){
            if(i == 0){
                preSum[i] = data[i];
            }else{
                preSum[i] = preSum[i - 1] + data[i];
            }
        }
        for(int i = 0; i < data.length; i++){
            for(int j = i; j < data.length; j++){
                int sum = 0;
                if(i == 0){
                    sum = preSum[j];
                }else {
                    sum = preSum[j] - preSum[i - 1];
                }
                if(sum == target){
                    count++;
                }
            }

        }
        return count;
    }


}
