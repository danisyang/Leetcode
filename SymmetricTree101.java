/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
题意：就是判断一颗二叉树是不是镜像对称的
思路：分治法，先写一个判断二叉树相等的
    一颗二叉树是镜面对称的，那么就是左节点等于右节点，l.val == r.val 
    乱了，先写边界条件，
    左子树 和右子树为空的话 那么true
    一边为空 false
    根为空 true

    两边都不为空：
    那么 左右两个节点的值至少相等

    用两个队列，然后去广度优先 一层层遍历这个 树 
    第一个队列 每层从做往右 第二个队列 每层从右往左，最后两个队列如果相等 那么就说明 对称了
    问题来了，广度遍历怎么做来着。

    看了一下 Solution 写一下吧，主要是当时考虑问题的时候，没搞清楚什么是 两个树对称，什么是自己对称
    两棵树镜面对称
    1.两个均为null true
    2.一个为空，一个非空，false
    3.两个节点值相等&&left的左子树，和right的右子树对称；&& left的右子树，和right的左子树对称
    
收获：想的太少了，思路不清晰，把两个树对称和一棵树自己镜面对称这两个概念区分开来，就已经解题了。
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isMirror(root , root);
    }
    public boolean isMirror(TreeNode left , TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        return (left.val==right.val)&&isMirror(left.right, right.left)&&isMirror(left.left, right.right);
    }
}