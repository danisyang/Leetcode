import java.util.ArrayList;
import java.util.Stack;

import javax.swing.tree.TreeNode;
import javax.xml.namespace.QName;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotation;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.SimpleType;
import com.sun.xml.internal.txw2.Document;
import com.sun.xml.internal.txw2.TypedXmlWriter;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]

题意：就是把从根到叶子的路径加起来等于sum的路径找出来
思路：dfs 遍历 存符合条件的
        dfs 实现有两种方法 递归或者使用栈迭代
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
//写一个遍历的版本
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        List<Ingeter> list = new ArrayList();
        Stack<TreeNode> stackNode = new Stack<TreeNode>();
        Stack<Integer> stackSum = new Stack<Integer>();
        stackNode.push(root);
        stackSum.push(sum);
        while(!stackNode.isEmpty()){
            
        }

    }
}