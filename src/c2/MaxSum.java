package c2;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaxSum {

    static int maxSum = Integer.MIN_VALUE;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(6);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(8);
        TreeNode t8 = new TreeNode(9);
        root.left = t1;
        root.right =  t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        t3.left = t7;
        t3.right = t8;
//        List<List<Integer>> result = new ArrayList<>();
//        allPath(root, new ArrayList<>(), result);
//        System.out.println(result);
        List<Integer> result = new ArrayList<>();
        allPath(root, 0, result);
        System.out.println(result);

    }

    /**
     * 树的所有路径
     */
    public static void allPath(TreeNode root, List<Integer> path, List<List<Integer>> result){
        if(null == root){
            return;
        }
        path.add(root.val);
        if(null == root.left  && null  == root.right){
            result.add(new ArrayList<>(path));
            return;
        }
        allPath(root.left, new ArrayList<>(path), result);
        allPath(root.right, new ArrayList<>(path), result);
    }
    /**
     * 树的所有路径的和
     */
    public static void allPath(TreeNode root, int sum, List<Integer> result){
        if(null == root){
            return;
        }
        if(null == root.left  && null  == root.right){
            sum += root.val;
            result.add(sum);
            return;
        }
        allPath(root.left, sum + root.val, result);
        allPath(root.right, sum + root.val , result);
    }
}
