/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 7 x 3 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28
 */
/**
 * 题意：有向右向下两种走法，在一个m*n的grid里，从左上到右下一共有多少种方案
 * 思路：每个格子的状态都是左边＋上面的状态，迭代出结果。输出最后一个格子的结果。
 * 收获：击败100%
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (j >= 1) {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
        return dp[n - 1];
    }
}