/**
 * Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
题意：删掉所有的和val的值相等的元素
思路：就是顺序查一遍啊，删掉就行了，不知道坑在哪里,其实坑还挺多的
收获：问题还不少，比如，有连续的删除节点，头节点是删除节点，指针为空的分析。打败了0，7ms，大部分在2.5ms左右
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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        while (head!=null && head.val == val){
            head=head.next;
        }
        ListNode tmp = head;
        while(tmp!=null&&tmp.next!=null){
            while(tmp.next!=null&&tmp.next.val == val){
                tmp.next = tmp.next.next;
            }
            tmp = tmp.next;
        }
        return head;
    }
}