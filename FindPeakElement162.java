/**
 * A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity.
 */
/**
 * 有个隐藏条件，就是后一个不等于前一个，那个确定一个数之后，要么在peak，要么左边或者右边一定有一个peak。那么二分就可以了
 * 收获：击败了4.15% 速度慢可能是访问太多次getNum函数了。。二分的逻辑是没有错的
 */
class Solution {
    public int findPeakElement(int[] nums) {
        if(null==nums||nums.length==0)  return -1;
        if(nums.length==1) return 0;
        int low = 0;
        int high = nums.length - 1;
        if(nums[0]>nums[1]) return 0;
        if(nums[high]>nums[high-1]) return high;
        while(low<=high){
            int mid = low + (high - low) / 2;
            if(getNum(nums, mid)>getNum(nums, mid-1)&&(getNum(nums,mid)>getNum(nums, mid+1))){
                return mid;
            }else if(getNum(nums, mid)>getNum(nums, mid-1)&&(getNum(nums,mid)<getNum(nums, mid+1))){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low ;
    }
    public int getNum(int[] nums,int k){
        if(k==-1||k==nums.length)
        return Integer.MIN_VALUE;
        return nums[k];
    }
}
