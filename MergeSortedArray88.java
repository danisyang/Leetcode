/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
题意：把第二个数组插入到第一个数组中，假设数组的空间是够的
思路：从后面往前面插入就行了
问题：这种题，插入的，以后每次都用while循环 链表那种方式去做，判断两个子数字都没空，
然后一边为空了，把剩下的接着插入
我后来改写了第二版，看了discuss里面，有一个收获就是，既然是插在nums1里的，那么nums1的tar1空了，我要把nums2里面剩下的移动过来
但是如果是nums2的tar2空了，那么nums1就不用动了，因为本身就是自己
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0||nums1 == null){
            nums1 = nums2;
            return ;
        }
        if(nums2 == null || n==0)
            return ;
        int len1 = m;
        int len2 = n;
        int len3 = m+n;
        int tar1 = m-1;
        int tar2 = n-1;
        for(int i=len3-1;i>=0 && tar1>=0 && tar2>=0;i--){
            if(nums1[tar1]>nums2[tar2]){
                nums1[i] = nums1[tar1];
                tar1--;
            }else{
                nums1[i] = nums2[tar2];
                tar2--;
            }
        }
    }
}
//前两个为空的情况需要重新处理一下 nums1 = nums2 貌似不能满足平台执行的要求。
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n == 0)
            return;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }
        int len1 = m;
        int len2 = n;
        int len3 = m + n;
        int tar1 = m - 1;
        int tar2 = n - 1;
        int tar3 = len3 - 1;
        while (tar1 >= 0 && tar2 >= 0) {
            nums1[tar3] = (nums1[tar1] > nums2[tar2]) ? nums1[tar1--] : nums2[tar2--];
            tar3--;
        }
        // 出来的话 说明tar1 或者tar2 有一边 <0 了
        if (tar1 < 0) {
            while (tar2 >= 0 && tar3 >= 0) {
                nums1[tar3] = nums2[tar2--];
                tar3--;
            }
        } else {
            while (tar1 >= 0 && tar3 >= 0) {
                nums1[tar3] = nums1[tar1--];
                tar3--;
            }
        }
    }
}