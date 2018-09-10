/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
/**
 * 题意：解码数字to字母，数字1-26能解码成为A-Z，请问一串数字能有多少种解码方案12能解码为AB和L两种 答案为2
 * 思路：dp，当前的位置i的解码数量与i-1，i-2两个位置的解码数量相关，典型动态规划，
 *      如果当前位置和上一位的两个数能组合成为一个字母，那么当前的数量要加上dp[i-2]
 *      如果当前位置自己能组合成一个字母(非0)，那么当前的数量要加上dp[i-1]
 *      初始化的时候需要仔细分析好各种情况，第一位好分析，只需要非0就可以dp[0]=1;第二位需要仔细分析
 * 收获：1、在写dp的时候，不一定非要用一个dp转换公式把所有的都列出来，dp[i-2],dp[i-1]可以分开分析，单独累加
 *      2、考虑好边界case
 *      3、击败了31.50%
 */
class Solution {
    public int numDecodings(String s) {
        if (null == s || s.length() == 0)
            return 0;
        int len = s.length();
        int[] dp = new int[len];
        if (s.charAt(0) != '0')
            dp[0] = 1;
        else
            return 0;
        if (len >= 2) {
            if (Integer.parseInt(s.substring(0, 2)) <= 26 && Integer.parseInt(s.substring(0, 2)) >= 10)
                dp[1] = s.substring(1, 2).equals("0") ? 1 : 2;//1 或 2种
            else if(s.charAt(1)=='0'){// 两位中>=27的情况 需要判断第二位是否为0
                return 0;}
            else //大于26的
                dp[1] =dp[0];
        }
        for (int i = 2; i < len; i++) {
            int tmp = Integer.parseInt(s.substring(i, i + 1));
            int two = Integer.parseInt(s.substring(i - 1, i + 1));
            if (two <= 26 && two >= 10) {
                dp[i] += dp[i - 2];
            } 
            if (s.charAt(i)!='0') {
                dp[i] += dp[i - 1];
            }
            }
        return dp[len - 1];
    }
}