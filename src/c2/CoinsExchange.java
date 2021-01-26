package c2;

import java.util.HashMap;
import java.util.Map;

public class CoinsExchange {
    public static void main(String[] args) {
        System.out.println(exchange(new int[]{2}, 3, new HashMap<>()));
    }
    public static int exchange(int[] coins, int target, Map<Integer, Integer> cache){
        //如果没有要换的金额了，就不需要换了
        if(target == 0){
            return 0;
        }
        //兑换不出来了
        if(target < 0){
            return -1;
        }
        //性能优化
        if(cache.containsKey(target)){
            return cache.get(target);
        }
        //列出所有可以兑换
        int minCount = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            int coin = coins[i];
            int count = exchange(coins,  target - coin, cache);
            //如果兑换不出来，继续下一个
            if(count  ==  -1){
                continue;
            }else {
                minCount = Math.min(minCount, count + 1);
            }
        }
        minCount = minCount == Integer.MAX_VALUE ? -1 : minCount;
        cache.put(target, minCount);
        return minCount;
    }

}
