import javax.lang.model.util.ElementScanner6;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
Example 1:
Input: [1,3,4,2,2]
Output: 2
Example 2:
Input: [3,1,3,4,2]
Output: 3
Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
 */
//注意 重复的数字，可能出现多于两次 
/**
 * 有两种思路：1、二分查找，先从头到尾搜索mid，小于等于mid的个数，如果是mid，则low=mid+1；如果小于mid，则low=mid+1；如果大于mid；则high=mid
 *            2、disscuss上有环检测 O(n)的解法。。没看明白。。
 * @param nums
 * @return
 */
//O(nlgn) 二分查找的 退出条件，还是要仔细观察，< 或者是<= 确定清楚
class Solution {
    public int findDuplicate(int[] nums) {
        if(null==nums||nums.length==0)  return 0;
        int len = nums.length;
        int low = 1;
        int high = len - 1;
        while(low<high){
            int mid = low + (high - low) / 2;
            if(getCount(nums, mid)==mid){
                low = mid + 1;
            }else if(getCount(nums, mid)>mid){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    public int getCount(int[] nums,int n){
        int ans = 0;
        for(int x :nums){
            if(x<=n){
                ans++;
            }
        }
        return ans;
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        if (null == nums || nums.length == 0)
            return 0;
        int len = nums.length;
        int sum = (len - 1) * (len) / 2;
        for (int i = 0; i < len; i++) {
            sum -= nums[i];
        }
        return -sum;
    }
}