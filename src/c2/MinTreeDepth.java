package c2;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinTreeDepth {
    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node2.left = node4;
        node4.right = node5;
        System.out.println(minDepth(node));

    }

    public static int minDepth(TreeNode root){
        if(null == root){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (! queue.isEmpty()){
            depth++;
            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.poll();
                if(null == node.left && null == node.right){
                    return depth;
                }
                if(null != node.left){
                    queue.offer(node.left);
                }
                if(null != node.right){
                    queue.offer(node.right);
                }
                size--;
            }
        }
        return depth;
    }
}
