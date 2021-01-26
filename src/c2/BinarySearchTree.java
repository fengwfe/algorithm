package c2;

import common.TreeNode;

public class BinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(1);
        root.left = n1;
        root.right = n2;
        n2.left = n3;
        System.out.println(isBinarySearchTree(root, null, null));
    }

    /**
     * 判断二叉树是否是二叉搜索树
     *
     */
    public static boolean isBinarySearchTree(TreeNode root, Integer min, Integer max ){
        if(null == root){
            return true;
        }
        if(null != max && root.val >= max){
            return false;
        }
        if(null != min && root.val <= min){
            return false;
        }
        return isBinarySearchTree(root.left, min, root.val) && isBinarySearchTree(root.right, root.val, max);
    }
}
