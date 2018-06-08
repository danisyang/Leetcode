/*
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * Input: ["flower","flow","flight"] Output: "fl" Example 2:
 * 
 * Input: ["dog","racecar","car"] Output: "" Explanation: There is no common
 * prefix among the input strings. Note:
 * 
 * All given inputs are in lowercase letters a-z.
 学到了：java中for循环可以加label，有了label后，break会变得很方便，break + label-name；就可以break到想跳出的循环
 如果不这么做的话，需要加一个变量，flag 外层去判断这个flag的状态再跳出
 
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int len = strs.length;
        int minlen = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (strs[i].length() < minlen) {
                minlen = strs[i].length();
            }
        }
        int sublen = 0;
        String tmp = strs[0];
        first: for (; sublen < minlen; sublen++) {
            second: for (int i = 0; i < strs.length; i++) {
                if (strs[i].charAt(sublen) != tmp.charAt(sublen))
                    break first;
            }
        }
        return tmp.substring(0, sublen);
    }
}
//对比优秀代码
//这个代码思路很清奇，我是一个个找，他用了indexOf(pre),直接在后面的字符串里找pre，如果没有则pre删掉自己结尾的字符。
//indexOf() 这个方法，匹配"" 和找到位置0 都返回的是0，pre从右边开始删，保证不会再找到之前变""
public class solution{
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }
}