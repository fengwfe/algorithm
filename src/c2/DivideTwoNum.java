package c2;

public class DivideTwoNum {
    public static void main(String[] args) {

        System.out.println(divide(10, 6));
    }

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
