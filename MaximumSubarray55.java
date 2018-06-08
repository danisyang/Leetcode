/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

题意：找数组中的子数组的最大和，返回这个和 用O(n)和分治法两种都试试
思路：分治法，m[i]是以i为结尾的子数组的最大值，最后遍历一遍所有的，拿出最大值就是答案
             转换方程m[i+1]=max{a[i],a[i]+m[i]}
            m[0]=a[0]
收获：我想的方法应该是dp，也就是动态规划，看了discuss后发现有优化的空间，不需要用数组保存每一个点的最大值，直接用一个变量记录当前最大值，另一个记录历史最大值就好了。
*/
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null)
            return 0;
        int len = nums.length;
        int[] m = new int[len];
        m[0] = nums[0];
        for(int i=1;i<len;i++){
            if(m[i-1]>=0){
                m[i] = m[i-1]+nums[i];
            }
            else{
                m[i] = nums[i];
            }
        }
        int max=m[0];
        for(int i=0;i<len;i++){
            max = (max>m[i])? max:m[i];
        }
        return max;
    }
}
//discuss 优秀的dp代码
class Solution {
    // public int maxSubArray(int[] nums) {
    // int[] dp = new int[nums.length];
    // dp[0] = nums[0];
    // int res = dp[0];
    // for (int i = 1; i < nums.length; i++){
    // dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
    // res = Math.max(res, dp[i]);
    // }
    // return res;
    // }

    public int maxSubArray(int[] nums) {
        int cur = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            res = Math.max(res, cur);
        }
        return res;
    }
}

//网上找到一份分治法的解题方法
//主要看的是corss那边的逻辑
//分治法的话，就是递归，还是要看最底层的递归边界是怎么样的，考虑只有1个和2个长度的时候，就很清楚能理解Subarray了，也能理解crossSub了，
//长度为2的时候的crossSub就是两个的和
//不为2的时候怎么解释，我再想想吧
public class Solution {// divdie and conquer
    public int maxSubArray(int[] nums) {
        return Subarray(nums, 0, nums.length - 1);
    }

    public int Subarray(int[] A, int left, int right) {
        if (left == right) {
            return A[left];
        }
        int mid = left + (right - left) / 2;
        int leftSum = Subarray(A, left, mid);// left part
        int rightSum = Subarray(A, mid + 1, right);// right part
        int crossSum = crossSubarray(A, left, right);// cross part
        if (leftSum >= rightSum && leftSum >= crossSum) {// left part is max
            return leftSum;
        }
        if (rightSum >= leftSum && rightSum >= crossSum) {// right part is max
            return rightSum;
        }
        return crossSum; // cross part is max
    }

    public int crossSubarray(int[] A, int left, int right) {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        int mid = left + (right - left) / 2;
        for (int i = mid; i >= left; i--) {
            sum = sum + A[i];
            if (leftSum < sum) {
                leftSum = sum;
            }
        }
        sum = 0;
        for (int j = mid + 1; j <= right; j++) {
            sum = sum + A[j];
            if (rightSum < sum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }
}