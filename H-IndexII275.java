/**
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

Example:

Input: citations = [0,1,3,5,6]
Output: 3 
Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had 
             received 0, 1, 3, 5, 6 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.
Note:

If there are several possible values for h, the maximum one is taken as the h-index.

Follow up:

This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
Could you solve it in logarithmic time complexity?
 */
/**
 * 题意：在h-指数的基础上，给了排序的输入，要求lgn时间复杂度，则必用二分查找，处理好下标应该就可以了
 */
class Solution {
    public int hIndex(int[] citations) {
        if(null==citations||citations.length==0)
            return 0;
        int len = citations.length;
        int left = 0;
        int right = citations.length - 1;
        while(left<=right){
            int mid = left + (right - left) / 2;
            if(citations[mid]>=(len-mid)){
                right = mid - 1;
            }else
                left = mid;
        }
        return len-left;
    }
}