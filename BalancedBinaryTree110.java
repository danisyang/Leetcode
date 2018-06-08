import javax.swing.tree.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
问题：判断是否是平衡二叉树
思路：想清楚条件是什么。左子树平衡，右子树平衡，且 左右子树高度差不超过1
      那么就可以用分治法了，递归，边界条件
      需要记录一下高度，用getDepth获得
收获：一次AC 但是打败了1.3的人，时间效率太低下
必须优化：
    也就是说，在找左子树，右子树，和平衡的这个环节
    和递归，找左子树高度，右子树高度，总体高度
    这两个过程的分治法，极其相似，在找高度的那个里面，加一个全局的flag，找到高度后，先判断，是否高度差>1 如果是就flag=flase
判断一定要注意，别写成赋值

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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int dl = getDepth(root.left);
        int dr = getDepth(root.right);
        int sub = Math.abs(dl - dr);
        return isBalanced(root.left)&&isBalanced(root.right)&&(sub <= 1);
        
    }
    public int getDepth(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(getDepth(root.left),getDepth(root.right)) + 1;
    }
}

//discuss 的思路，自己写了一个 击败了85
class Solution {
    public boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) //可以删掉
            return true;
        getDepth(root);
        
        return flag;

    }

    public int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        if(flag == false)       //big mistakes flag == false  写成了 flag = false 
            return 0;
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        int sub = Math.abs(l - r);
        if(sub > 1)
            flag = false;
        return Math.max(l,r) + 1;
    }
}