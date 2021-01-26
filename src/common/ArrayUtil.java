package common;

public class ArrayUtil {
    public static void print(int[] data){
        StringBuffer bf = new StringBuffer();
        for(int d: data){
            bf.append(",").append(d);
        }
        System.out.println(bf);
    }
}
