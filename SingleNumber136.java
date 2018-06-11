/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:
题意：非空的数组，除了某一个元素出现一次之外，其他都出现两次，找出这个元素
思路：异或操作 a xor a = 0  0 xor x = x   所以遍历每个数，异或操作，结果就是那个数
收获：击败了100，熟悉^操作
Input: [4,1,2,1,2]
Output: 4
 */
class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans ^= nums[i];
        }
        return ans;
    }
}