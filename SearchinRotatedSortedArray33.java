import javax.lang.model.util.ElementScanner6;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
题意：有一个递增不重复的数组，按照某一个位置截断了，结果是重新拼接起来的数组。在这个数组里二分查找某个数，如果没有的话返回-1；有的话返回下标
思路：先找到最大的那个数，以这个数为分隔，在两边二分查找。
setp1：找最大的数，条件为： 左边的数，小于自己;右边的数要么没有，要么小于自己；
       找的时候，要么是最后一个，要么是前半截的最大的数
改了几次，终于通过了，不过速度比较慢，击败了1.8的用户
在discuss上看了另外一种方案。比较好，自己写一下。
*/
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] < nums[low])
                high = mid - 1;
            else if (nums[mid] > nums[low]) {
                if (mid + 1 <= high && nums[mid] > nums[mid + 1])
                    break;
                low = mid + 1;
            } else {
                // 说明是一个或者两个值，和后一个比较
                if (mid + 1 <= high && nums[mid] < nums[mid + 1])
                    mid++;
                break;
            }
        }
        int middle = nums[mid];
        int ans = 0;
        if (target >= nums[0] && target <= middle) {
            ans = binSearch(nums, target, 0, mid);
        } else {
            ans = binSearch(nums, target, mid + 1, nums.length - 1);
        }
        return ans;
    }
    public int binSearch(int[] nums,int target,int low1,int high1){
        int low = low1;
        int high = high1;
        while(low<=high){   
            int mid = low + (high - low)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                high = mid -1;
            else 
                low = mid + 1; 
        }
        return -1;
    }
}

//新的方案也是击败了1.98的用户
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid] >= nums[low]){
                if(target>=nums[low]&&target<nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            if(nums[mid]<=nums[high]){
                if(target>nums[mid]&&target<=nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}