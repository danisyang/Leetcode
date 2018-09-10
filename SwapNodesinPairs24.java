/**
 * Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * 题意：swap相邻的两个节点，返回头指针
 * 收获：1、list表熟悉
 *      2、边界case分析
 *      击败了5%
 *      node1  node2 node3 node4    node1     node3     node2   node4
 *      pre --> p --> r --> node4 => node1 --> node3--> pre -->  p
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
        return head;
        ListNode h = null;
        ListNode p = head;
        ListNode pre = null;
        while(p!=null&&p.next!=null&&p.next.next!=null){
            if(p.next!=null){
                ListNode r = p.next;
                p.next=p.next.next;
                if(pre==null){
                    r.next = p;
                    h = r;
                    pre = r;
                }else{
                    r.next = p;
                    pre.next = r;
                    pre = r;
                }
            }
            p = p.next;
            pre = pre.next;
        }//剩下的情况是剩不到3个节点的情况,要么是上一种情况处理到最后1个或者两个(1个不用再处理了)，要么是本身就是1或2个节点(需要处理)
        //判断方法是pre==null
        if(pre == null){
            if(p.next!=null){
                h = p.next;
                h.next = p;
                p.next = null;
            }else{
                h = p ;
            }
        }else{//有pre的
            if(p.next!=null){
                pre.next=p.next;
                pre.next.next = p;
                p.next = null;
            }
        }
        return h;
    }
}