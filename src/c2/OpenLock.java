package c2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenLock {
    public static void main(String[] args) {
        System.out.println(openLock("1190",new String[]{"0010","1010"}));
    }

    /**
     * 开锁，有四个转轮,每个转轮的值为 0 - 9，遇到deadEnds会死锁
     * @param target
     * @param deadEnds
     * @return
     */
    public static int openLock(String target, String[] deadEnds){
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> dead = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        for(String s: deadEnds){
            dead.add(s);
        }
        int steps = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                String p = queue.poll();
                if(dead.contains(p)){
                    continue;
                }
                if(p.equals(target)){
                    return steps;
                }
                for(int i = 0; i < 4; i++){
                    String upStr = up(p, i);
                    String downStr = down(p, i);
                    if(!visited.contains(upStr)){
                        queue.offer(upStr);
                        visited.add(upStr);
                    }
                    if(!visited.contains(downStr)){
                        queue.offer(downStr);
                        visited.add(downStr);
                    }
                }
                size--;
            }
            steps++;
        }
        return -1;
    }
    public static String up(String s, int i){
        char[] array = s.toCharArray();
        char c = array[i];
        if(c == '0'){
           array[i] = '9';
        }else {
            array[i] = (char)(c  - 1);
        }
        return String.valueOf(array);
    }
    public static String down(String s, int i){
        char[] array = s.toCharArray();
        char c = array[i];
        if(c == '9'){
            array[i] = '0';
        }else{
            array[i] = (char)(c + 1);
        }
        return String.valueOf(array);
    }
}
