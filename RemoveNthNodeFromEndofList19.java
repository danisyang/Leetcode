import javax.lang.model.util.ElementScanner6;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Given a linked list, remove the n-th node from the end of list and return its
 * head.
 * 
 * Example:
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5. Note:
 * 
 * Given n will always be valid.
 * 
 * Follow up:
 * 
 * Could you do this in one pass?
 * 题意：删除倒数第n个节点
 * 思路：两个指针，第一个先走n个长度，第二个和第一个保证n的距离，当front到尾巴时候，删掉behind后面的一个节点。
 * 注意的地方：为空，n>长度的问题 合法性
 * 收获：有一个地方写错了，在while循环中，while(n>0&&front.next!=null) 写成了n>=0导致n的值和后面预想的不一样
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||n<=0)
        return head;
        ListNode front = head;
        ListNode behind = head;
        while(n>0&&front.next!=null){
            front = front.next;
            n--;
        }
        if(n==1){
            return head.next;
        }
        else if(n==0){
            while(front.next!=null){
                front = front.next;
                begind = begind.next;
            }
            behind.next = behind.next.next;
            return head;
        }
        else return head;
    }
}