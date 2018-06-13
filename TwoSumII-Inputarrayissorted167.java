import javax.lang.model.util.ElementScanner6;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:
题意：给一个递增数组，每个值只出现一次，给一个target，求两个数的下标，这两个数的和是target
思路：用hash表，把前面出现的值存下来，遇见了hash(tar-nums[i])存在的话，那么就返回这两个下标
     不用hash表的话，用两个指针从两端开始查找，如果大了，那么右边调小，如果小了，左边调大，等相遇找不到说明没有
收获：用第二种方法击败了51
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null)
            return null;
        int len = numbers.length;
        int low = 0;
        int high = len - 1;
        int[] ans = new int[2];
        while(low < high){
            if(numbers[low] + numbers[high] == target){
                ans[0] = low+1;
                ans[1] = high + 1;
                return ans;
            }
            else if(numbers[low] + numbers[high] < target){
                low ++;
            }
            else{
                high --;
            }
        }
        return null;
    }
}