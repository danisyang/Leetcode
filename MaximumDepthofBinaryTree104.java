/**
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.

题意：就是树的高度
思路：为空的话，深度0，否则深度是左子树和右子树深度最大值+1
    很简单的分治法，用递归实现
收获：

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
    public int maxDepth(TreeNode root) {
        if(root == null)
        return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
//discuss bfs解法
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int depth = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            depth++;
            while (size-- > 0) {
                TreeNode node = nodes.poll();
                if (node.left != null)
                    nodes.offer(node.left);
                if (node.right != null)
                    nodes.offer(node.right);
            }
        }
        return depth;
    }
}