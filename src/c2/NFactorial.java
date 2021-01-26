package c2;

public class NFactorial {

    public static void main(String[] args) {
//        System.out.println(tailZero(125));
        System.out.println(kZero(2));

    }

    /**
     * 计算N的阶乘末尾有几个零
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
     *有多少个N满足N的阶乘的值的末尾有k个0
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



}
