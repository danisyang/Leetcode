/**
 * Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
  题意 就是实现一个indexOf函数，如果找到了返回第一个index，没有找到的话，返回-1
    分析 字符串的查找，O(mn)的做法还是很好实现的
  */
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || "".equals(needle))
            return 0;
        int lenS = haystack.length();
        int lenN = needle.length();
        for(int i=0;i<lenS-lenN+1;i++){
            boolean flag = true;
            for(int j=0;j<lenN;j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if (flag==true)
            return i;
            
        }
        return -1;
    }
}