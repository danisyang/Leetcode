/**
 * Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

题意：两个字符串2进制 相加 求和
思路：其实就是大数相加的题，都是字符串，只不过进制不一样，其他的思路，如参考66题的思路，目前没想到
收获：md 手下的错误太多了，把tmp和ans写错，导致了结果字符串链接在原来的字符串上了
打败了37的用户，不知道如何优化
 */
class Solution {
    public String addBinary(String a, String b) {
        if((a==null && b==null))
            return "";
        if(a==null||a.length()==0)
            return b;
        if(b==null||b.length()==0)
            return a;
        String tmp = a;
        String ans = "";
        if(a.length() < b.length()){ //a  -ge  b  len(a)>=len(b)
            a = b;
            b = tmp;
        }
        int lenOfLong = a.length();
        int lenOfShort = b.length();
        int carry = 0;
        int digit = 0;
        for(int i=lenOfShort-1; i>= 0 ; i--){
            digit = (a.charAt(i+(lenOfLong-lenOfShort))-'0') + (b.charAt(i) -'0') + carry;
            carry = digit / 2;
            ans = (digit % 2) + ans;
        }
        for(int i=lenOfLong-lenOfShort-1; i>= 0 ;i--){
            digit = (a.charAt(i)- '0') + carry;
            carry = digit / 2;
            ans = (digit % 2) + ans;
        }
        if(carry == 1)
            ans = 1+ans;

        return ans;
    }
}