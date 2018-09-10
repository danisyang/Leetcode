/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */

/** 
 * 题意：给一个正整数n，求出正整数最小能由几个完美数求和得到。完美数就是1,4,9,16这种平方和
 * 思路：dp求解，数组保存当前数的最小值，dp[i] 可以由它的之前的dp数组得到，最后得到答案
 * 收获：1、初始化的时候先给所有数最大值，其次给每个完美数赋值1，因为其本身就是最优解
 * 2、遍历每一个元素，如果值是1，直接最优解跳过，非1的话，选取和本数距离为完美数的数取值，得到最小值，最后+1赋值给本数最优解
 * 3、返回dp[n] 
 * 4、击败24.28% Time Complexity: n * sqrt(n) Space: O(n)y
*/ 
class Solution {
    public int numSquares(int n) {
        if (n <= 0)
            return 0;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++)
            dp[i] = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++)
            dp[i * i] = 1;
        for (int i = 1; i <= n; i++) {
            if (dp[i] != 1) {
                for (int j = 1; i - j * j >= 0; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j]);
                }
                dp[i]++;
            }
        }
        return dp[n];
    }
}