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
        
    }
}