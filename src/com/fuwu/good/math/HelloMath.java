package com.fuwu.good.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1.判断是否为丑数
 * 2.生成第K个丑数
 * 3.计算N的阶乘末尾有几个零
 * 4.有多少个N满足N的阶乘的值的末尾有k个0
 * 5.给定一个数组，数组元素不重复，求数组元素的全排列
 * 6.求幂运算
 * 7.判断是否为素数
 * 8.求n以内有多少个素数，不包括n
 * 9.不用除法运算实现除法
 */
public class HelloMath {

    /**
     * 1.判断是否为丑数
     */
    public static boolean isUglyNum(int num){
        if(num <= 0){
            return false;
        }
        while (num % 2 ==0){
            num = num / 2;
        }
        while (num % 3 ==0){
            num  = num / 3;
        }
        while (num % 5 == 0){
            num = num / 5;
        }
        return num == 1;
    }

    /**
     * 2.生成第K个丑数
     */
    public static int kthUglyNum(int k){
        int[] uglyNums = new int[k];
        uglyNums[0] = 1;
        int i = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while (i < k){
            int nextUglyNum = 2 * uglyNums[p2];
            nextUglyNum = Math.min(nextUglyNum, 3 * uglyNums[p3]);
            nextUglyNum = Math.min(nextUglyNum, 5 * uglyNums[p5]);
            uglyNums[i] = nextUglyNum;
            while (2 * uglyNums[p2] <= nextUglyNum ){
                p2++;
            }
            while (3 * uglyNums[p3] <= nextUglyNum ){
                p3++;
            }
            while (5 * uglyNums[p5] <= nextUglyNum ){
                p5++;
            }

            i++;
        }
        return uglyNums[k - 1];
    }
    /**
     * 3.计算N的阶乘末尾有几个零
     * @param n
     * @return
     */
    public static int tailZero(long n){
        long divisor = 5;
        int result = 0;
        while ( divisor <= n ){
            result += n / divisor;
            divisor *= 5;
        }
        return result;
    }
    /**
     * 4.有多少个N满足N的阶乘的值的末尾有k个0
     *
     */
    public static int kZero(int k){
        long n = 1;
        int result = 0;
        while (true){
            if(tailZero(n) == k){
                System.out.println(n);
                result ++;
                n++;
            }else if(tailZero(n) > k){
                break;
            }else{
                n++;
            }
        }
        return result;
    }
    /**
     * 5.给定一个数组，数组元素不重复，求数组元素的全排列
     *
     * 使用插入法
     */
    public static List<List<Character>> permutation(char[] chars){
        List<List<Character>> result = new ArrayList<>();
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            List<List<Character>> newResult = new ArrayList<>();
            if(result.size() > 0){
                for(List<Character> record: result){
                    for(int j = 0;  j <= record.size(); j++){
                        List<Character> newRecord = new ArrayList<>(record);
                        newRecord.add(j,c);
                        newResult.add(newRecord);
                    }
                }
            }else{
                List<Character> newRecord = new ArrayList<>();
                newRecord.add(c);
                newResult.add(newRecord);
            }
            result = newResult;
        }
        return result;
    }
    /**
     * 6.求幂运算
     * @param a
     * @param k
     * @return
     */
    public static long pow(int a, int k){
        if(k == 0){
            return 1;
        }
        if(k % 2 == 1){
            return a * pow(a, k - 1);
        }else{
            long half = pow(a, k / 2);
            return half * half;
        }
    }

    /**
     * 7.判断是否为素数
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
     * 8.求n以内有多少个素数，不包括n
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

    /**
     * 9.不用除法运算实现除法
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        if(dividend == Integer.MAX_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
            sign = -1;
        }
        int dd = dividend > 0 ? dividend : 0 - dividend;
        int ds = divisor > 0 ? divisor : 0 -divisor;
        int result = 0;
        while (dd >= ds){
            int power = 1;
            while (ds << 1 < dd){
                ds  = ds  << 1;
                power =  power  <<  1;
            }
            dd = dd -ds;
            ds = divisor;
            result += power;

        }
        return result * sign;
    }
}
