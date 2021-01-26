package c2;

public class Bag {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2,1,3}, new int[]{4,2,3}, 4, 2));

    }

    public static int maxProfit(int[] ws, int[] vs, int capacity, int  i){
        if(i  < 0){
            return 0;
        }
        if(i == 0){
            if(ws[i] <= capacity){
                return vs[i];
            }else {
                return 0;
            }
        }
        if(capacity < ws[i]){//选不了
            return maxProfit(ws,vs,capacity, i - 1);
        }else{//可以选
            int r1 = maxProfit(ws,vs,capacity, i - 1);//不选当前
            int r2 =vs[i] + maxProfit(ws, vs, capacity - ws[i],  i - 1);//选当前
            return Math.max(r1, r2);
        }
    }
}
