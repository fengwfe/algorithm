package com.fuwu.good.tree;

import com.fuwu.good.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 中序遍历
 * 特点: 二叉搜索树的话，遍历的结果是从小到大排序
 *
 */

/**
 * 1.判断二叉树是否是二叉搜索树
 * 2.构建二叉树
 * 3.树的所有路径
 * 4.树的所有路径的和
 * 5.树的最小深度
 * 6.是否存在root节点到叶子节点的path 满足节点的和为target sum
 * 7.按层级遍历,BFS
 *
 */
public class HelloTree {


    /**
     * 1.判断二叉树是否是二叉搜索树
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

    /**
     * 2.构建二叉树
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
    /**
     * 3.树的所有路径
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
     * 4.树的所有路径的和
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

    /**
     * 5.树的最小深度
     * @param root
     * @return
     */
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
    /**
     * 6.是否存在root节点到叶子节点的path 满足节点的和为target sum
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
    /**
     * 7.按层级遍历,BFS
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
