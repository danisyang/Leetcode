/**
 * Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6

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
/**
 * 思路：统计向右节点出发的个数，然后向左边的个数。。刚开始 每往右走一次，2^0 2^1 2^2 个节点，主要是确定最后一行的个数。
 * 难点在于确定最后一行的个数
 * 这道题的一个关键点在于：如果一直找最左边的子节点的深度等于最右边的节点的深度。那么一定是完全二叉树。。那么这种情况直接返回就可以了。
 * 如果不是的话，肯定是左边子树的深度是右边+1,这种情况下，就是要递归解决。
 */
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null)
        return 0;
        if(get_left_dep(root)==get_right_dep(root)){
            return (1<<(get_left_dep(root))+1)-1;
        }else{
            return countNodes(root.left)+countNodes(root.right)+1;
        }
    }
    public int get_left_dep(TreeNode rNode){
        int dep = 0;
        while(rNode.left!=null){
            dep++;
            rNode=rNode.left;
        }
        return dep;
    }
    public int get_right_dep(TreeNode rNode){
        int dep = 0;
        while(rNode.right!=null){
            dep++;
            rNode=rNode.right;
        }
        return dep;
    }
}