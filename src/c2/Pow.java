package c2;

public class Pow {
    public static void main(String[] args) {
        System.out.println(pow(-2, 4));

    }

    /**
     * 求幂运算
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
}
