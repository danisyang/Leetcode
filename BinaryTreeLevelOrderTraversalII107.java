import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
题意：就是把一颗二叉树，自底向上，自左往右遍历
思路：bfs 自顶向下 把每一行的存下来，最后反转一下最外部的列表,或者在插入的时候直接插入到表头就ok
收获：写while循环的时候，一定不要忘记增量条件，size-- 出错，size>0判断出错(之前写成了>= 有空指针异常)
优化的空间就是 list把线性表换成链表 不知道提升如何 
5ms 击败了18
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null)
            return ans; // return null will Wrong Answer
        List<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();// size of this line
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                list.add(node.val);
                size--;
            }
            ans.add(0, new ArrayList(list));
            list.clear();
        }
        return ans;
    }
}