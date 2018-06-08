import java.util.HashMap;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order. Note that an empty string is also considered
 * valid.
 * 
 * Example 1:
 * 
 * Input: "()" Output: true Example 2:
 * 
 * Input: "()[]{}" Output: true Example 3:
 * 
 * Input: "(]" Output: false Example 4:
 * 
 * Input: "([)]" Output: false Example 5:
 * 
 * Input: "{[]}" Output: true
 */
import java.util.*;
class Solution {
    public boolean isValid(String s) {
        if(s==null)
            return false;
        HashMap<Character,Character> dic = new HashMap<Character,Character>();
        Stack<Character> stack = new Stack<Character>();
        dic.put(']', '[');
        dic.put(')', '(');
        dic.put('}', '{');
        for(int i=0;i<s.length();i++){
            if(dic.containsKey(s.charAt(i))){
                if(!stack.empty()&&stack.peek()==dic.get(s.charAt(i)))
                stack.pop();
                else stack.push(s.charAt(i));
            }
            else
                stack.push(s.charAt(i));
            
        }
        if (stack.isEmpty())
        return true;
        else
        return false;
    }
}