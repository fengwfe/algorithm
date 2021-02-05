package com.fuwu.good.math;

public class GCD {

    public static void main(String[] args) {
        System.out.println(getGCD(6,3));
    }
    public static int getGCD(Integer p,Integer q){
        if(q == 0){
            return p;
        }else{
            return getGCD(q,p%q);
        }
    }
}
