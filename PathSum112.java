import java.util.Stack;

import javax.swing.tree.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.
Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
题意：给一棵二叉树，给一个sum，看是否有一条根到叶的路径节点之和为sum
思路：有递归recursive 和 iterative 两种解法
收获：递归要把一个大问题转换成子问题去解决
     如果根节点root 且root.val = x ，sum
     那么可以转换为  hasPathSum(root.left sum-x) || hasPathSum(root.right sum-x) 这两个子问题
     迭代主要是用dfs去搜索一下，看有没有符合条件的case 需要借助栈
     get dfs
     */
//递归 这个版本击败了99
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null && root.val == sum)
            return true;
        return hasPathSum(root.left, sum - root.val)||hasPathSum(root.right, sum - root.val);
    }
}

//这个迭代的版本击败了4.25
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> sumStack = new Stack<Integer>();
        nodeStack.push(root);
        sumStack.push(sum); // path Sum
        while(!nodeStack.isEmpty()){
            TreeNode tmp = nodeStack.pop();
            int res = sumStack.pop();
            if(tmp.left == null && tmp.right == null && tmp.val == res) return true;//find one correct path
            if(tmp.left != null){
                nodeStack.push(tmp.left);
                sumStack.push(res - tmp.val);
            }
            if(tmp.right != null){
                nodeStack.push(tmp.right);
                sumStack.push(res - tmp.val);
            }
        }
        return false;
    }
}