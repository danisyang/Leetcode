/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
 */
//题意：查找一个被旋转的增数组(无重复)的最小数
//思路：其实是要查找一个 小于它前面的数且小于它后面的数的一个数字。
//      和最后一位比很重要，如果大于最后一位 说明在左边旋转部分 肯定不是最小值，如果小于最后一位，说明在递增数组里，可能是最小值
//      此时需要和前一位比较，如果小于前一位那么说明就是最小值，如果大于，说明要在左边查找
//收获：1、有 1 2 3 4 5 顺序的可能性
//      2、击败了100%
class Solution {
    public int findMin(int[] nums) {
        if(null==nums||nums.length==0)
            return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return nums[0]>nums[1]?nums[1]:nums[0];
        int low = 0;
        int high = nums.length - 1;
        while(low<high){
            int mid = low + (high - low) / 2;
            if(nums[mid]>nums[high]){
                low = mid + 1;
            }else if(nums[mid]<nums[high]){
                if(mid>0&&nums[mid-1]>nums[mid])
                    return nums[mid];
                else
                    high = mid -1;
            }
            else{
                return nums[high];
            }
        }
        return nums[low];
    }
}