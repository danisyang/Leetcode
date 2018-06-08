/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Example 1:
 * 
 * Input: [1,3,5,6], 5 Output: 2 Example 2:
 * 
 * Input: [1,3,5,6], 2 Output: 1 Example 3:
 * 
 * Input: [1,3,5,6], 7 Output: 4 Example 4:
 * 
 * Input: [1,3,5,6], 0 Output: 0
 * start:   14:10 pm
 * 
 * 有点像二分查找 如果查到了，那么返回这个index
 * 如果没有找到 返回 low +1 的那个位置
 * 分析一下 如果只有1个数1，tar=0 或者2 如何插入
 * 问题的最关键点在于 最后return什么，还有while的判断条件，确定了<= 之后 就是手写一下 返回low才是正确答案，一次AC
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null)
            return 0;
        int tar = target;
        int low =0;
        int high = nums.length-1;
        
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == tar){
                return mid;
            }
            else if(nums[mid]<tar){
                low = mid+1;
            }
            else 
                high = mid-1;
        }
            return low;
    }
}