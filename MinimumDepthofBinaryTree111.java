import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import sun.reflect.generics.tree.Tree;

/**
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
题意：找最小的深度
思路：就是bfs找出最优解就行，边界条件是，一个节点左右子节点都为空
收获：把mindep的位置放错了，改成后ac，击败99+ bfs的编写应当熟练
*/
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int mindep = 1;
        queue.add(root);
        int size = queue.size();
        a: while(!queue.isEmpty()){
            size = queue.size(); //record the num of last line .
            while(size > 0){
            TreeNode del = queue.poll();
            if(del.left == null && del.right == null){
                break a;
                }
            if(del.left!=null)
                queue.add(del.left);
            if(del.right!=null)
                queue.add(del.right);
            size --;
            }
            mindep++;
        }

        return mindep;
    }
}