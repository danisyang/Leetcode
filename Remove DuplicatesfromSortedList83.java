/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
题意：给一个链表，返回新的链表，这个新的链表里，每个元素只出现一次
思路：就是记录当前节点，当下一个值等于本节点的值，那么删除下一个，只有当下一个值不等于本节点的时候，移动当前节点。
收获：一次AC，没有测试。bugfree！ beat 100!
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode cur = head;
        ListNode h = head;
        while(cur.next != null){
            if(cur.next.val == cur.val){
                cur.next = cur.next.next;//delete the next node;
            }
            else{
                cur = cur.next; // move to next node;
            }
        }
        return h;
    }
}