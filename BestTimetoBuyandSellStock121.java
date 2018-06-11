/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
题意：买股票，最多买一次，卖一次，问怎么操作利润最大，最大利润是多少，如果没有利润，返回0
思路：1、双重for，O(n^2) 肯定是可以解决的
     2、DP 设置一个数组，记录当前天卖出的利润最大值，状态转换方程是：
        if(prices[i+1]>prices[i])
            profit[i]  += prices[i+1]-prices[i]
        else
            profit[i] = (prices[i+1] > min[i])?prices[i+1] - min[i]:0;
        其中 min[i] 记录的是以i为结尾的前几天的最小值
*/
//想的复杂了，直接遍历一遍就ok了，维护一个变量存min，另一个pro存maxpro
//不过时间 已然是49用户 估计是java慢吧
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int len = prices.length;
        int min = prices[0];
        int pro = 0;
        for(int i = 0; i < len ;i++){
            if(prices[i] < min)
                min = prices[i];
            pro = (pro > (prices[i] - min))?pro:(prices[i] - min);
        }
        return pro;
    }
}

// dp 打败了49的用户 还有改进空间
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)
            return 0;
        int len = prices.length;
        int[] profit = new int[len];
        int min = prices[0];
        for(int i=1;i< len; i++){
            min = (prices[i] > min)?min:prices[i];//the min price of [1~i] day
            if(prices[i] > prices[i-1]){
                profit[i] = prices[i] - prices[i-1] + profit[i-1];
            }
            else{
                profit[i] = prices[i] - min;
            }
        } 
        int pro = 0;
        for(int i = 0;i<len;i++){
            if(profit[i]>pro)
                pro = profit[i];
        }
        return pro;
    }
}

//用profit 这个变量记录以本天为结尾的最大利润即可 用另一个变量pro去维护最小值
//仍然是49的用户
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int len = prices.length;
        int profit = 0;
        int pro = 0;
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            min = (prices[i] > min) ? min : prices[i];// the min price of [1~i] day
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
                pro = (profit > pro)?profit:pro;
            } else {
                profit = prices[i] - min;
                pro = (profit > pro)?profit:pro;
            }
        }
        return pro;
    }
}

// O(n^2) 击败了可能百分之0的用户 太慢了
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int len = prices.length;
        int pro = 0;
        for(int i = 0;i < len; i++){
            for(int j = i+1;j <len; j++){
                if((prices[j] - prices[i])>pro){
                    pro = prices[j] - prices[i];
                }
            }
        }
        return pro;
    }
}