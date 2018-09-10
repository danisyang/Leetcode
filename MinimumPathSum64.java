import java.util.Arrays;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
/**
 * 题意：和走路线一样，只是把每一步的代价换成了数组而不是1.
 * 思路：dp记录到目前这一行到这个位置的代价的最小值，dp[j-1]是左边的，dp[j]是上边的，边界是最开始的位置单独分析，初始值明确后不难
 * 收获：1、击败了16.63%
 *      2、The least space is O(min(m, n))！这句话很有启发性，行和列其实都是一样的，最小的空间就是行和列的min值
 *      3、时间复杂度O(n*m)没办法再减小了
 */
class Solution {
    public int minPathSum(int[][] grid) {
        if(null==grid||grid.length==0)
            return 0;
        int len = grid[0].length;
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int row = grid.length;
        dp[0]=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<len;j++){
                if(j>0){
                dp[j] = Math.min(dp[j-1], dp[j]);
                }
                dp[j] += grid[i][j];
            }
        }
        return dp[len-1];
    }
}