import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
Credits:
Special thanks to @stellari for adding this problem and creating all test cases.
题意：求两个链表的第一个交点，如果不存在，返回null
思路：既然是相交，那么从交点开始的后面的节点都是重合的，那么，如果长度不同，则让长的先走几个节点，从两个剩余长度一样的点开始遍历
同时遍历a，和b，当相等的时候就返回node，遍历结束没有相等，返回null
收获：while(i>0)这里没想好，写成了i>=0 如果是0的话，说明长度相同，不能先走 击败96
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        int lenL = 0;
        int lenS = 0;
        ListNode tA = headA;
        ListNode tB = headB;
        while(tA!=null){
            tA = tA.next;
            lenL++;
        }
        while(tB!=null){
            tB = tB.next;
            lenS++;
        }
        ListNode tmp = headB;
        if(lenL<lenS){
            tmp = headB;
            headB = headA;
            headA = tmp;
            int t = lenS;
            lenS = lenL;
            lenL = t;
        }
        int i = lenL - lenS;
        while(i>0){
            headA = headA.next;
            i--;
        }
        while(headA!=null&&headB!=null){
            if(headA==headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}