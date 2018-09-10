/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
/**
 * 题意：三角形每个位置都有一个cost,要找出从第一个到最后一行cost和最小的值，用dp来记录每一个位置的总cost;
 * 思路：分析可以知道，每一个位置的cost，在于它肩膀上两个位置cost的min值加上自己的cost, 即:min(upleft,upright)+cost
 *      dp的数组大小可以开成最后一行的长度，也就是深度
 *      改变位置可知 i-1 和 i的cost比个大小，然后加上本身的cost去更新dp[i]就可以了
 *      2
 *      3 4
 *      6 5 7 
 *      4 1 8 3
 * 收获：1、dp的时候，因为更新是dp[i]=min(dp[i-1],dp[i]) 所以从右往左遍历，因为从左到有会更新dp[i]的值，下一个的dp[i-1]不再是原始的上一行的cost值
 *      2、在比大小的时候，因为默认位置是0的，所以要看好，如果是0和triangle.get(i).size()-1两个边的位置，只拿出一个就ok了，其他的拿出所有的比较
 *      3、击败了42.57%
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(null==triangle||triangle.size()==0)
            return 0;
        int len = triangle.size();
        int[] dp = new int[len];
        for(int i=0;i<len;i++){
            int n = triangle.get(i).size()-1;//n是list的最后一个位置下标
            for(int j=n;j>=0;j--){
                int tmp = (j>n)?0:triangle.get(i).get(j);
                if(j>0){
                    if(j==n){
                        dp[j] = dp[j-1]+tmp;
                    }else{
                    dp[j] = Math.min(dp[j-1], dp[j]) + tmp;
                }
                }else{
                    dp[j] = dp[j] + tmp;
                }
            }
        }
        int minimum = Integer.MAX_VALUE;
        for(int i:dp){
            if(i<minimum)
                minimum = i;
        }
        return minimum;
    }
}