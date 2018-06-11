/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
题意：除去abc字母和数字之外，其他字符不考虑。看是不是回文字符，且不考虑大小写
思路：就暴力做，一个指针从前往后，另一个从后往前，在找到第一个字母或者数字停下来比较，不一样false，一样的话，继续。
      left > right 是退出的标志
收获：提交的前两次都超时，debug之后发现是 left 和 right下标增量错误，没有考虑到相等之后，left++ 和 right--
    击败了96
 */
class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length()==0)
            return true;
        int left = 0;
        int right = s.length() - 1;
        while(left <= right){
            while((left<=right)&&!getValidChar(s.charAt(left))){
                left ++;
            }
            while((left<=right)&&!getValidChar(s.charAt(right))){
                right --;
            }
            if(left > right)
                return true;
            if(getLowerCase(s.charAt(left))!=getLowerCase(s.charAt(right))){
                return false;
            }else{
                left++;
                right--;
            }
            
        }
        return true;
    }
    public boolean getValidChar(char c){
        if((c >= '0'&& c <= '9')||(c>='a'&&c<='z')||(c>='A'&&c<='Z'))
        return true;
        return false;
    }
    public char getLowerCase(char c){
        if(c>='A'&&c<='Z'){
            return Character.toLowerCase(c);
        }
        return c;
    }
}