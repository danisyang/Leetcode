/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
题意：给一个连续数组，不能选取连续的两个，问如何使得选取的值最大化
思路：看了discuss,是dp的题，用m[i]来标记到下标i时的最大收益，因为涉及到两种状态，i这个拿了或者没拿
m[i][1] 是当前下标数字被rob的最大收益，m[i][0]是当前下标数字没rob的最大收益
状态转换式：    m[i+1][0] = max{m[i][0],m[i][1]}//也就是说 如果没选这个点，那么最大值就是 上一个状态的两种情况的最大值
               m[i+1][1] = m[i][0]+nums[i]
优化的话：不用申请二维数组，直接用两个变量来存这两个数
收获：熟练dp,状态转换与优化，击败1.28 改变了大小判断的方法 不知道时间瓶颈在哪里...
*/
class Solution {
    public int rob(int[] nums) {
        int notrob = 0;
        int rob = 0;
        for(int i = 0;i < nums.length; i++){
            int nowrob = notrob+nums[i];
            int nownotrob = (notrob>rob)?notrob:rob;
            notrob = nownotrob;
            rob = nowrob;
        }
        return (notrob>rob)?notrob:rob;
    }
}