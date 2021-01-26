package c2;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(11);
        TreeNode n6 = new TreeNode(31);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
//        levelPrint(root);
        print2(root);

    }

    /**
     * 前序遍历
     *
     */
    public static void print(TreeNode root){
        if(null == root){
            return;
        }
        System.out.println(root.val);
        print(root.left);
        print(root.right);
    }

    /**
     * 中序遍历
     * 特点: 二叉搜索树的话，遍历的结果是从小到大排序
     *
     */
    public static void print2(TreeNode root){
        if(null == root){
            return;
        }
        print2(root.left);
        System.out.println(root.val);
        print2(root.right);
    }
    /**
     * 后续遍历
     */
    public static void print3(TreeNode root){
        if(null == root){
            return;
        }
        print3(root.left);
        print3(root.right);
        System.out.println(root.val);
    }
    /**
     * 按层级遍历,BFS
     */
    public static void levelPrint(TreeNode root){
        if(null == root){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            System.out.println(node.val);
            if(null != left) queue.offer(left);
            if(null != right) queue.offer(right);
        }

    }

}
