package c2;

import common.TreeNode;

public class BuildTree {
    public static void main(String[] args) {

        int[] inOrder = {1,5,3,10,11,15,20};
        int[] preOrder = {10,5,1,3,15,11,20};
        TreeNode root = build(inOrder, 0, inOrder.length - 1, preOrder, 0, preOrder.length - 1);
        System.out.println(root);
    }

    /**
     *数组中没有重复元素
     * @param inOrder
     * @param l1
     * @param h1
     * @param preOrder
     * @param l2
     * @param h2
     * @return
     */

    public static TreeNode build(int[] inOrder, int l1, int h1, int[] preOrder, int l2, int h2){
        if(l1 > h1){
            return null;
        }
        int rootVal = preOrder[l2];
        TreeNode root = new TreeNode(rootVal);
        int i = l1;
        while (inOrder[i] != rootVal){
            i++;
        }
        int leftSize = i - l1;
        TreeNode left = build(inOrder, l1, i -1, preOrder, l2 + 1, l2 + leftSize - 1);
        TreeNode right = build(inOrder, i + 1, h1, preOrder, l2 + leftSize + 1, h2);
        root.left = left;
        root.right = right;
        return root;
    }

}
