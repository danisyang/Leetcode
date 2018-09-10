/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */
//一次二分 一次线性 时间击败25%
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };
        if (null == nums || nums.length == 0)
            return ans;
        int low = 0;
        int high = nums.length - 1;
        int first = -1;
        int last = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                if (mid == 0 || nums[mid] > nums[mid - 1]) {
                    first = mid;
                    break;
                } else {
                    high = mid - 1;
                }
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        last = first;
        while (last != -1 && last + 1 < nums.length && nums[last] == nums[last + 1]) {
            last++;
        }

        ans[0] = first;
        ans[1] = last;
        return ans;
    }
}
//用两次二分查找 时间击败50%
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (null == nums || nums.length == 0)
            return 0;
        int low = 0;
        int high = nums.length - 1;
        int first = -1;
        int last = -1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                if (mid == 0 || nums[mid] > nums[mid - 1]) {
                    first = mid;
                    break;
                } else {
                    high = mid - 1;
                }
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            last = first;
            int low_new = first;
            int high_new = nums.length - 1;
            while(low_new!=-1&&low_new<=high_new){
                int mid_new = low_new + (high_new - low_new) / 2;
                if(nums[mid_new]>target){
                    high_new = mid_new - 1;
                }else{//  ==
                    if(mid_new==nums.length-1||nums[mid_new]<nums[mid_new+1]){
                        last=mid_new; break;
                    }else{
                        low_new = mid_new + 1;
                    }
                }
            }
            int[] ans = new int[2];
            ans[0] = first;
            ans[1] = last;
            return ans;
        }

    }
}