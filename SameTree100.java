/**
 * Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
 */

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
/**
 * 这道题貌似太水了，感觉没有什么可以讲的，做的答案基本上就是最正确的答案，也应该是最简洁的答案了，
 * 考虑好 递归退出的边界条件 和递归的公式就好了。
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q ==null)
            return true;
        if (p == null || q == null)
            return false;
        return isSameTree(p.left, q.left)&&(p.val==q.val)&&isSameTree(p.right, q.right);
    }
}