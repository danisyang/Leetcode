/**
 * Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
题意：给一个链表，判断是否有个环
思路：快慢指针，一个走的快，一个走的慢，然后当他们俩相遇的那一刻，说明有环。如果没有相遇的话，没有环，那么一定会退出的。
收获：写bugfree的代码还是不容易啊。front 走两步，只需要判断front的next 是不是null就可以了
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode front = head.next;
        ListNode behind = head;
        while(front!=null && behind!=null){
            if(front == behind)
                return true;
            if(front.next==null||front.next.next==null){
                return false;
            }
            front = front.next.next;
            behind = behind.next;
        }
        return false;
    }
}