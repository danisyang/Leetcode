/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
 */
/**
 * 题意：在一串正整数中找最小的连续数组 其和大于等于给定值
 * 思路：两个指针 具体见代码。。
 *      时间复杂度O(n) 另外有O(nlgn)的解法，二分查找，可能存在的窗口大小，针对一个可能的窗口大小，用O(n)的时间滑动看是否存在这样的窗口。如果存在，就折半减小；不存在则增大窗口。
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(null==nums||nums.length==0)
            return 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(right<nums.length){
            sum += nums[right];
            right++;
            while(sum>=s){//这个while需要注意一下 
                min = (min>(right-left))?(right-left):min;
                sum -= nums[left];
                left++;
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}