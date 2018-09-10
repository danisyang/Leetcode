/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?



An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
 */
/**
 * 题意：在棋盘中有障碍，障碍是1，从左上走到右下，只能右或者下，问走到最右下一共有多少种走法
 * 思路：还是dp，在dp的时候以前是直接加结果，现在要分析一下该位置的左边和上面是不是有障碍，如果有障碍的话就不加
 * 收获：击败36.01%
 *      遇到了这种例子[[1,0]] 初始化那边需要修改 之前初始化的时 给dp默认全部为1 明显没有考虑到第一行就有可能有障碍的情况
 *      return 的判断是为了防止 [[1]]这种极端输入的，因为初始化没有考虑障碍
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;//初始化
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                int left=0;
                int up=0;
                if(j>=1&&obstacleGrid[i][j-1]==0)
                    left = dp[j-1];
                if(j==0){//在初始化dp在最外面的情况下，这个可以和left up合并了
                    if(i>=1)
                    dp[j]=obstacleGrid[i-1][j]==0?dp[j]:0;
                    continue;
                }
                if(i>=1&&obstacleGrid[i-1][j]==0)
                    up = dp[j];
                if(i==0){//这里等于在是初始化原始dp了
                    if(j>=1){
                        dp[j]=obstacleGrid[i][j-1]==0?dp[j-1]:0;
                        continue;
                    }
                }
                dp[j] = left + up;
            }
        return obstacleGrid[m-1][n-1]==1?0:dp[n-1];
    }
}
/**
 * 让代码整洁了...
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;// 初始化
        for(int j=1;j<n;j++) 
            dp[j] = obstacleGrid[0][j - 1] == 0 ? dp[j - 1] : 0;
        for (int i = 1; i < m; i++)
            for (int j = 0; j < n; j++) {
                int left = 0;
                int up = 0;
                if (j >= 1 && obstacleGrid[i][j - 1] == 0)
                    left = dp[j - 1];
                if (i >= 1 && obstacleGrid[i - 1][j] == 0)
                    up = dp[j];
                dp[j] = left + up;
            }
        return obstacleGrid[m - 1][n - 1] == 1 ? 0 : dp[n - 1];
    }
}