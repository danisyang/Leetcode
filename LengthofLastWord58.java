/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5
题意：给出一个字符串，得到字符串里最后一个单词的长度。如果没有，返回0
思路：就是从后开始遍历，遇到第一个不为' '的位置开始计数，遇到下一个 空格 位置 计算这个个数；
收获：写的时候，for 里面++ 还是-- 看清楚，然后 看好自己的start，over记录的是什么，是空字符还是非空字符。判断一下每种情况的边界case，最好能bugfree
打败了99
*/
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() ==0)
            return 0;
        int start = -1;
        int over = -1;
        int i = s.length();
        for(i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                start = i;
                break;
            }
        }
        if(start < 0)
            return 0;
        for(i = start -1;i>=0;i--){
            if(s.charAt(i)==' '){
                over = i;
                break;
            }
        }
        if(over<0)
            return start+1;
        else{
            return start -over ;
        }
    }
}