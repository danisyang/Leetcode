/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
/**
 *题意：就是连续的数字的最大积是多少
  思路：dp求解，不知道是脑子坏了还是怎么了，哎。考虑的有点复杂。早点睡吧
 */
class Solution {
    public int maxProduct(int[] nums) {
        if (null == nums || nums.length == 0)
            return 0;
        int len = nums.length;
        int[] pos = new int[len];
        int[] neg = new int[len];
        int max = nums[0];
        pos[0] = nums[0];
        neg[0] = nums[0];
        for (int n = 1; n < len; n++) {
            pos[n] = Math.max(Math.max(pos[n - 1] * nums[n], neg[n - 1] * nums[n]), nums[n]);
            neg[n] = Math.min(Math.min(pos[n - 1] * nums[n], neg[n - 1] * nums[n]), nums[n]);
        }
        for (int i = 0; i < len; i++) {
            if (pos[i] > max)
                max = pos[i];
        }
        return max;
    }
}