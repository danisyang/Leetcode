import java.util.HashMap;
import java.util.Map;

import javax.lang.model.util.ElementScanner6;

/**
 * Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
题意：两个字符串是否样式相同
思路：用hashmap，如果没有遇s[i],t[i]就存入，如果遇见了，对照
如果和hashmap里的一样，那么就接着比对，不一样，返回false
收获：这里主要有一点需要想清楚，就是当不包含s[i]的时候，要放入s[i],t[i]前
要加一个判断，看t[i]是否在值域里，如果在，返回false 打败45
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int lens = s.length();
        int lent = t.length();
        Map<Character,Character> map = new HashMap<Character,Character>();
        for(int i=0;i<lens;i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))==t.charAt(i))
                    continue;
                else
                    return false;
            }
            else if(map.containsValue(t.charAt(i)))
                return false;
            else{
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
}