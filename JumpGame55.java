/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
 */
/**
 * 题意：非负数组表示每一步能够跳到的最大步数，求问是否能到最后一个台阶
 * 思路：直接遍历，统计到当前台阶后的能够到达的最大台阶。最后看最大台阶是否是大于等于最后个台阶高度。
 * 收获：1.理解贪心，即直接考虑最大的情况，台阶数量是可以分割的，每一次想跳几个只要在最大值范围内就行
 *      2.击败39.37%
 */
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length==0)
            return false;
        int fareast = 0;//当前能到的最远距离
        for(int i=0;i<nums.length;i++){
            if(i>fareast)
                return false;
            else{
                fareast = Math.max(fareast, i+nums[i]);
            }
        }
        return true;
    }
}