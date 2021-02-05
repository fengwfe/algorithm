package com.fuwu.good.stack;

import java.util.ArrayList;
import java.util.List;

public class HelloStack {
  public static void main(String[] args) {
    //
      List<String> result = new ArrayList<>();
      gen(3,0,0,"",result);
    System.out.println(result);
  }

  public static void gen(int n, int left, int right, String path, List<String> result){
      if(left > n || right > n){
          return;
      }
      if(left < right){
          return;
      }
      if(left ==n && right == n){
          result.add(path);
          return;
      }
      gen(n, left + 1, right, path + "(", result);
      gen(n, left, right + 1, path + ")", result);

  }
}
