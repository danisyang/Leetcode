import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
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
 * 题意：输出该数字所对应的所有的二叉查找树
 * 思路：自己想的时候倒是没有很明确的思路，看了discuss的解法想到可以dp求解
 *      当前数字i的二叉查找树与i-1,i-2,...0的查找树相关 这些都可以作为当前的左子树
 *      右子树除了数字外，形状与i-1..i-2..0一样
 *      在考虑右子树数字的时候，用copy方法递归复制一份
 *      击败91.31%
 */
public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> ans = new ArrayList<>();
        TreeNode node1 = new TreeNode(1);
        List<TreeNode> list1 = new ArrayList<TreeNode>();
        list1.add(node1);
        List<TreeNode> list0 = new ArrayList<TreeNode>();
        if(n<=0) return list0;
        list0.add(null);
        ans.add(list0);
        ans.add(list1);
        for(int i=2;i<=n;i++){
          List<TreeNode> nodes = new ArrayList<>();
          for(int j=0;j<i;j++){
              //node 左边有j个节点，右边有 i-j-1个节点 因为node也算一个节点
              for(TreeNode leftNode:ans.get(j)){
                for(TreeNode rightNode:ans.get(i-j-1)){
                  TreeNode node = new TreeNode(j+1);
                  node.left = leftNode;
                  node.right = copyNodes(j+1, rightNode);
                  nodes.add(node);
                }
              }
          }
          ans.add(nodes);
        }
        return ans.get(n);
    }
    public TreeNode copyNodes(int offset,TreeNode fromNode){
        if(fromNode==null) return null;
        TreeNode headNode = new TreeNode(fromNode.val+offset);
        headNode.left = copyNodes(offset, fromNode.left);
        headNode.right = copyNodes(offset, fromNode.right);
        return headNode;
    }
}