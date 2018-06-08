import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/*
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 */
/**
 * Definition for singly-linked list. 
 * public class ListNode { 
 *  int val; 
 *  ListNode next; 
 *  ListNode(int x) { val = x; }
 *  }
 * 出现了两个大问题：1,节点next指到了自己，死循环
 *                 2，大小关系搞错了，最后的剩下不为空处理错了
 * 优点：判断为空这边，健壮性还可以
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 ==null)
            return null;
        if(l1 == null || l2 ==null)
            return (l1 == null)?l2:l1;
        ListNode head = (l1.val>l2.val)?l1:l2;//最大的头结点出现了两次
        ListNode cur = head;//当前的节点
        ListNode first = l1;
        ListNode second = l2;
        while((first!=null)&&(second!=null)){
            if(first.val>second.val){
                cur.next = first;
                cur = cur.next;
                first = first.next;
            }
            else{
                cur.next = second;
                cur = cur.next;
                second = second.next;
            }
        }
        if(first!=null)
            cur.next = second;
        if(second != null)
            cur.next = first;

        return head.next;
    }
}