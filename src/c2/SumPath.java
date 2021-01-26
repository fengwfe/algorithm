package c2;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumPath {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode r2 = new TreeNode(11);
        TreeNode r3 = new TreeNode(5);
        TreeNode r4 = new TreeNode(6);
        TreeNode r5 = new TreeNode(3);
        TreeNode r6 = new TreeNode(2);
        root.left = r1;
        root.right = r2;
        r1.left = r3;
        r1.right = r4;
        r3.left = r5;
        r4.left = r6;
//        System.out.println(hasPath(root, 2));

        List<List<Integer>> result =new ArrayList<>();
        hasPath2(root, 13, new ArrayList<>(), result);
        System.out.println(result);
    }
    /**
     * 是否存在root节点到叶子节点的path 满足节点的和为target sum
     *
     */
    public static boolean hasPath(TreeNode root, int sum){
        if(null == root){
            return false;
        }
        if(null == root.left && null == root.right){
            if(sum == root.val){
                return true;
            }else{
                return false;
            }
        }
        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
    }
    public static void hasPath2(TreeNode root, int sum, List<Integer> record, List<List<Integer>> result){
        if(null == root){
            return;
        }
        if(null == root.left && null == root.right){
            if(sum == root.val){
                record.add(root.val);
                result.add(new ArrayList<>(record));
            }
            return;
        }
        record.add(root.val);
//        hasPath2(root.left, sum - root.val, new ArrayList<>(record), result);
//        hasPath2(root.right, sum - root.val, new ArrayList<>(record), result);

        int size =record.size();
        hasPath2(root.left, sum - root.val,record, result);
        int newSize = record.size();
        while (newSize > size){
            record.remove(record.size() - 1);
            newSize--;
        }
        hasPath2(root.right, sum - root.val, record, result);
        newSize = record.size();
        while (newSize > size){
            record.remove(record.size() - 1);
            newSize--;
        }
    }

}
