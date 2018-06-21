/**
 *Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701
题意：就是给一个excel的列号，返回数字
思路：如代码，比较简单，可以理解成进制问题吧。ps：这道题做了以后，对于168好像有了一点新的理解
收获：打败了63
 */
class Solution {
    public int titleToNumber(String s) {
        if(s == null||s.length()==0)
            return 0;
        int len = s.length();
        int base=1;
        int ans = 0;
        for(int i=len-1;i>=0;i--){
            int digit = (s.charAt(i)-'A')+1;
            ans += digit*base;  
            base *= 26;
        }
        return ans;
    }
}