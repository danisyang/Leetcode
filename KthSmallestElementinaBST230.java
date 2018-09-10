/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
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
 * 题意：求二叉查找树中的第n小的数
 * 思路：第n小的就是中序遍历第n个，写个中序遍历就ok了吧
 * 收获：打败58.50%
 */
class Solution {
    public int num = 0;
    public int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        pre(root, k);
        return ans;
    }
    public void pre(TreeNode root,int k){
        if(root==null) return;
        pre(root.left, k);
        num++;
        if(num==k){ans = root.val;}
        pre(root.right, k);
        return;
    }
}

//discuss上的另外一个二分查找的解法
class Solution{
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k - 1 - count); // 1 is counted as current node
        }
        return root.val;
    }
    public int countNodes(TreeNode n) {
        if (n == null) return 0;
        
        return 1 + countNodes(n.left) + countNodes(n.right);
    }
}