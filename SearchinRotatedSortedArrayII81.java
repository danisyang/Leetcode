/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?
 */
class Solution {
    public boolean search(int[] nums, int target) {
        if(null==nums||nums.length==0)
            return false;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high - low) / 2;
            if(nums[mid]==target)
                return true;
            if(nums[mid]>nums[low]||nums[mid]>nums[high]){//左边有序 或者 右边无序
                if(target>=nums[low]&&target<nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }else if(nums[mid]<nums[high]||nums[mid]<nums[low]){//左边无序 or 右边有序
                if(target>nums[mid]&&target<=nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            else{
                low++;
            }
        }
        return false;
    }
}
//discuss上看到的
class Solution1{
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        // check each num so we will check start == end
        // We always get a sorted part and a half part
        // we can check sorted part to decide where to go next
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return true;
            // if left part is sorted
            if (nums[start] < nums[mid]) {
                if (target < nums[start] || target > nums[mid]) {
                    // target is in rotated part
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (nums[start] > nums[mid]) {
                // right part is rotated
                // target is in rotated part
                if (target < nums[mid] || target > nums[end]) {//和第一位比 就可以保证 右边的是有序的
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // duplicates, we know nums[mid] != target, so nums[start] != target
                // based on current information, we can only move left pointer to skip one cell
                // thus in the worest case, we would have target: 2, and array like 11111111,
                // then
                // the running time would be O(n)
                start++;
            }
        }
        return false;
    }
}