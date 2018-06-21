/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
题意：就是给个数组，然后给一个k，让你右循环k次，返回这个数组 想尽可能多的方法，现在已知至少有3种，能尽量原地返回，只用o(1)的空间吗
思路：原地实现的话，[1,2,3...n,n+1...n+k] 有n个数据，循环k次 先反转1-n  [n,...1]
    再反转 n+1..n+k,得到[n+k,..n+1],得到[n,...1,n+k,...n+1] 总体反转 得到[n+1,...n+k,1,...n]
    时间O(n)空间O(1)
    2、每次循环一位，调用k次，O(nk) 空间O(1)
收获：有一个坑，就是k的值，可以超过数组的长度，这个时候，k要用k%len来代替 然后加一个判断，k==0的时候，就直接返回
     否则revers第二个下标会越界，因为涉及这个方法的时候，就是假设k>0了 必须保证 len-k <= len-1
     打败了98
 */
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || k ==0)
            return ;
        int len = nums.length;
        k = k % len;
        if(k==0)
            return ;//need not to rotate
        reverse(nums, 0, len-k-1);
        reverse(nums, len-k, len-1);
        reverse(nums, 0, len-1);
        return ;
    }
    public void reverse(int[] nums,int low,int high){
        while(low<high){
            int tmp = nums[low];
            nums[low] = nums[high];
            nums[high] = tmp;
            low++;
            high--;
        }
    }
}