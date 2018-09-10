/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
 */
/**
 * 题意：有一串数字，找出其中的最长的递增子串的长度
 * 思路：dp，以当前位置结束的字串的最大长度，取决于它以前的子串，即
 *      如果当前数是i，那么i以前的比i小的所有数都与当前结尾的字串最大长度有关，换言之，只要遍历所有比在i前面且比i小的数的，取得最大值，然后再+1赋予当前dp[i]
 *      O(n*2)的方法不难想出来
 *      O(n*lgn)？如何做
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(null==nums||nums.length==0)
            return 0;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        for(int i=1;i<len;i++){
            int max_pre = 0;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[j]>max_pre)
                    max_pre = dp[j];
                }
            }
            dp[i] = max_pre + 1;
        }
        int ans=dp[0];
        for(int i=0;i<len;i++){
            if(dp[i]>ans)
                ans = dp[i];
        }
        return ans;
    }
}
//在discuss上看到了O(n*lgn)的方法
//先说结论：1、时间和空间，不可能同时做完美，一般都是用空间换时间；2、设计到O(n)优化到O(lgn)的，难逃二分查找
//击败95.12%
//用tails数组存遍历到当前数字的，所有的之前的连续子序列的，长度为i的最小的尾巴,具体可以看一下discuss.
//用新的思路更改了我之前dp存以这个结尾的子序列的最大值的思路，让最终的tails可以单调增加，且可以用二分查找查找，改进效率
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (null == nums || nums.length == 0)
            return 0;
        int len = nums.length;
        int[] tails = new int[len];
        int size = 0;
        for (int i = 0; i < len; i++) {
            int low = 0; int high = size;
            while(low<high){
                int mid = low + (high-low)/2;
                if(tails[mid]<nums[i]){
                    low = mid + 1;
                }
                else{
                    high = mid;//注意理解为什么不是mid-1
                }
            }
            tails[low] = nums[i];
            if(low == size) size++;
        }
        return size;
    }
}