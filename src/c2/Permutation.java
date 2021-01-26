package c2;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};
        System.out.println(permutation(chars));
    }


    /**
     * 给定一个数组，数组元素不重复，求数组元素的全排列
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
}
