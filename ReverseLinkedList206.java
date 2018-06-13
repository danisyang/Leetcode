/**
 * Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
题意：反转链表，能不能用递归和迭代两种方案
思路：迭代的话，就是头插法，新建一个头结点，然后遍历原来的链表，每次插在这边的头上，记得把第一个节点的next置为null
收获：考虑好边界，开链，闭链，击败了100
思路：递归的话，就把大问题切分成，root 和 reverse(root.next) 这两部分，然后把root插入带reverse最后，
      递归函数返回的是头结点，而链表要插入在最后一位，所以需要记录一下最后一个位置，而最后一个位置就是reverse(root.next)前的root.next
收获：考虑好边界case，退出递归的条件，然后递归 击败了30
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//iteratively
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return head;
        ListNode h = new ListNode(0);
        ListNode node = head;
        head = head.next;
        node.next = null;
        h.next = node;
        while(head!=null){
            node = head;
            head = head.next;
            node.next = h.next;
            h.next = node;
        }
        return h.next;
    }
}
//recursively
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next==null)
            return head;
        ListNode n = head.next;
        ListNode h = reverseList(head.next);
        head.next = null;
        n.next = head;
        return h;
    }
}