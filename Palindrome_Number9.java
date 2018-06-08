/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?

问题：栈和队列
收获：队列是一个接口，而并不是一个被实现了的数据结构。LinkedList是实现了Queue的数据结构
写程序时，安全性提高了，我在判断前做了<0,==0，的判断，最后也有>0的判断，力保安全。
*/
import java.util.*;
class Solution {
    public boolean isPalindrome(int x) {
        if (x<0)
            return false;
        if(x==0)
            return true;
        Stack<Integer> stack = new Stack<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        while(x>0){
            int cur = x%10;
            stack.add(cur);
            queue.add(cur);
            x /= 10;
        }
        while(!stack.isEmpty()&&!queue.isEmpty()){
            if(stack.pop()!=queue.poll())
                return false;
        }
        return true;
    }
}