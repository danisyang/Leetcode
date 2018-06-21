/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"
题意：就是按着excel列的顺序，给一个数字，返回他的列名，Z的后一个是AA
思路：和进制还不一样，这个是没有0的，每一位的数，分两部分解决，进位的和这一位的。
给一个n n/26 这部分拿去高位处理了 n%26这部分留下来这一位处理，处理的时候 如果n本身是0 那么错误，不是0 那么n%26==0对应的是 z，1对应A

*/
class Solution {
    public String convertToTitle(int n) {
        String ans = "";
        if(n==0)
            return "";
        char[] charArray = {'A','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        while(n!=0){
            int now = n%26;
            n /= 26;
            if(now==0){
                ans = "Z" + ans;
                n--;
            }
            else{
                ans = Character.toString(charArray[now]) + ans;
            }
        }
        return ans;
    }
}

//下面这个解法是做了171之后想明白的，之前搞错了一个问题AAA 是26*26+26*1+1*1 而不是26*26+1 
//n-- 之后 n/26 只会影响边界情况
//--的意义在于 保证边界情况(即余数为0，n能被26整除)时候，进位数是对的(也就是进位要比真正n/26少一位)
class Solution {
    public String convertToTitle(int n) {
        String ans = "";
        if (n == 0)
            return "";
        char[] charArray = {'Z' , 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
                'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        while(n>0){
            int dig = n%26;
            char ch = charArray[dig];
            ans = ch + ans;
            n--;
            n/=26;
        }
        return ans;
    }
}