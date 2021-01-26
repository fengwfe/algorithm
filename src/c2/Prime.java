package c2;

import common.TreeNode;

import java.util.*;

public class Prime {
    public static void main(String[] args) {
        System.out.println(countPrimes(16));
////        Random random  = new Random();
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(1,1);
//        map.put(2,2);
//        map.put(3,3);
//        map.put(4,4);
//        map.put(5,5);
//        map.put(6,6);
//        map.put(7,7);
//        map.put(11,11);
//        map.put(22,22);
//        map.put(33,33);
//        map.put(44,44);
//        map.put(55,55);
//        map.put(66,66);
//        map.put(77,77);
//        Set<Integer> keys = map.keySet();
//        StringBuffer bf = new StringBuffer();
//        for(Integer key: keys){
//           bf.append(",").append(key);
//        }
//        System.out.println(bf);


    }

    /**
     *判断是否为素数
     */
    public static boolean isPrime(int n){
        if(n < 2){
            return false;
        }
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 求n以内有多少个素数，不包括n
     * @param n
     * @return
     */
    public static int countPrimes(int n){
        int count = 0;
        boolean[] flags = new boolean[n];
        Arrays.fill(flags, true);
        for(int i = 2; i * i < n; i++){
            if(flags[i]){
                for(int j = i * i; j < n; j += i){
                    flags[j] =false;
                }

            }
        }
        for(int i = 2; i < n; i++){
            if(flags[i]){
                System.out.println(i);
                count++;
            }
        }
        return count;
    }
}
