import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */
 //Definition for a binary tree node.
 //给出二叉树的中序遍历，递归的话很简单，题目需要给出迭代的解。
 //递归解如下  打败100%
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
class Solution {
    public List<Integer> list = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        traverl(root);
        return list;
    }
    public void traverl(TreeNode root){
        if(root==null){
            return ;
        }
        traverl(root.left);
        list.add(root.val);
        traverl(root.right);
        return ;
    }
}

//迭代解很巧妙，打败3.71%
class Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while(null!=curNode||!stack.empty()){
            while(curNode!=null){
                stack.add(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            list.add(curNode.val);
            curNode = curNode.right;
        }
        return list;
    }
}
