package c3.linkedList;

import com.fuwu.good.common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SameSubTree {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(0);
//        TreeNode left = new TreeNode(1);
//        left.left = new TreeNode(2);
//        left.right = new TreeNode(3);
//        TreeNode right = new TreeNode(1);
//        right.right = new TreeNode(3);
//        right.right.right = new TreeNode(2);
//        root.left = left;
//        root.right = right;
//        List<TreeNode> list =findDuplicateSubtrees(root);
//        System.out.println(list);
//        System.out.println("================");
//        postOrder(left);
//        System.out.println("================");
//        postOrder(right);

        String a = "1,2,3,4,";
        String[] b = a.split(",");
        System.out.println(b.length);
    }

    // 记录所有子树以及出现的次数
    static HashMap<String, Integer> memo = new HashMap<>();
    // 记录重复的子树根节点
    static LinkedList<TreeNode> res = new LinkedList<>();

    /* 主函数 */
    static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    /* 辅助函数 */
   static String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "," + right+ "," + root.val;

        int freq = memo.getOrDefault(subTree, 0);
        // 多次重复也只会被加入结果集一次
        if (freq == 1) {
            res.add(root);
        }
        // 给子树对应的出现次数加一
        memo.put(subTree, freq + 1);
        return subTree;
    }

    public static void postOrder(TreeNode root){
       if(null == root){
           System.out.println("#");
           return;
       }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);

    }
}
