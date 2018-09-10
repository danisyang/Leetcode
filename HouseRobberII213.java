/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.
Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
 */
/**题意：rob一行商店，不能rob相邻的两个，且认为1和n是相邻的
 * 思路：和rob一行一样，立一个flag位置，标志是否包含第一个值 到了最后一位判断是否包含1来输出答案，但是这种方案有问题。。。64/73
 * 思路2：看了discuss后发现有一个思路很好，rob(0,len-2)和rob(1,len-1)算出最大值就是要求的值。。
 *      因为1和n相邻，最多只能有一个包含在内，或者都不包含，此时用rob一排的方法可以求解。
 * 
 */
class Solution {
    public int rob(int[] nums) {
        if(null==nums||nums.length==0){
            return 0;
        }
        if(nums.length==1)
        return nums[0];
        int len = nums.length;
        int[] has = new int[len];
        int[] nothas = new int[len];
        has[0] = nums[0];
        boolean[] flag_one = new boolean[len];
        boolean[] flag_two = new boolean[len];
        flag_one[0] = true;
        flag_two[0] = false;
        for(int i=1;i<len;i++){
            has[i] = nothas[i-1] + nums[i];
            flag_one[i] = flag_two[i-1];
            nothas[i] = Math.max(has[i-1], nothas[i-1]);
            if(has[i - 1] > nothas[i - 1])
            flag_two[i] = flag_one[i-1];
            else if(has[i - 1] < nothas[i - 1])
            flag_two[i] = flag_two[i-1];
            else {
                if(flag_one[i-1]&&flag_two[i-1])
                flag_two[i] = true;
                else flag_two[i] = false;
            }
        }
        if(has[len-1]>nothas[len-1]&&flag_one[len-1]==false){
            return has[len-1];
        }
        else return nothas[len-1];
    }
}

class Solution2 {
    public int rob(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1)
            return nums[0];
        int len = nums.length;
        return Math.max(rob(nums, 0, len-2),rob(nums,1,len-1));
    }
    public int rob(int[] nums,int low,int high){
        int has = 0;
        int hasnot = 0;
        for(int i=low;i<=high;i++){
            int tmphas = has;
            int tmphasnot = hasnot;
            has = tmphasnot + nums[i];
            hasnot = Math.max(tmphas, tmphasnot);
        }
        return Math.max(has, hasnot);
    }
}