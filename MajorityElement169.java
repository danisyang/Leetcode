/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
题意：寻找主要元素，就是出现次数超过一半的元素，且假设nums非空且主要元素一定存在
思路：如果这个值一定存在的话，那么排完序后，当n/2下标处的那个元素(从0开始)，就是要求的那个数字，
可以画一个图分别分析奇数偶数，这个数是大的，还是小的 就自己写一个partition排序吧
收获：手写partition和二分查找get 唯一一个bug是partition if(low>=high) return low 中的if 判别式写错了
打败了0 速度虽然慢，但是目的达到了 O(nlgn)

//discuss中有一种做法，拿出第一个座位major 然后给一个count 数，如果这个数和major相等，count++，否则--，当count==0时，重置major 因为major出现次数>一半 所以最后留下来的就是major O(n)
*/
class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null)
            return 0;
        int len = nums.length;
        int low = 0;
        int high = len-1;
        int mid = low + (high - low)/2;
        while(low < high){
            int m = partition(nums, low, high);
            if (m == mid){
                return nums[mid];
            }
            else if(m < mid){
                low = m + 1;
            }
            else {
                high = m - 1;
            }
        }
        return nums[mid];
    }
    
    public int partition(int[] nums,int low,int high){
        if(low<=high)
            return low;
        int num = nums[low];
        while(low<high){
            while(low<high&&nums[high]>=num){
                high--;
            }
            nums[low] = nums[high];
            while(low<high&&nums[low]<num){
                low++;
            }
            nums[high] = nums[low];

        }
        nums[low] = num;
        return low;
    }
}