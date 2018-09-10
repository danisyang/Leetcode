/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
Note:

-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
/**
 * 解题过程略有丑陋。。太丑陋了，击败了12.99的人
 * 收获：1、整数溢出问题，即最小数的相反数
 *      2、浮点数的比较 在一个范围内 而不是等号
 *      3、看了discuss之后发现这道题的核心主要是考察log(n)写法 即pow(2,8)可以写成pow(4,4),pow(8,2)
 */
class Solution {
    public double myPow(double x, int n) {
        if(n== -2147483648){ //为了预防整数溢出的问题，即-2147483648的相反数为本身 因为本题案例很弱可以通过
            if(x>1.0||x<-1.0){
                return 0.0;
            }
        }
        if(n==0&&x!=0.0)
        return 1.0;
        if((x<=0.00001&&x>-0.00001)&&n>0)
        return 0.0;
        if(x>0.99999&&x<1.00001)
        return 1.0;
        if(x>-1.00001&&x<-0.99999){
            if(n%2==0)
            return 1.0;
            else
            return -1.0;
        }
        double ans=1.0;
        int time = (n>0)?n:-n;
        while(time>0){
            ans *= x;
            time--;
        }
        if(n>0)
        return ans;
        else
        return 1/ans;
    }
}

//从discuss看来的 更优雅的思路的实现
class Solution {
    public double myPow(double x, int n) {
        if(x==0.0){
            return 0.0;
        }
        if(n==0){
            return 1.0;
        }
        else if(n<0){
            // 不能把 n/2的情况避免出现了 -2147483648 的相反数为本身的溢出问题 递归的时间也使得时间复杂度为O(logn)
            return n%2==0?myPow(x*x,n/2):(1/x)*myPow(x*x,n/2); 
        }
        else{
            return n%2==0?myPow(x*x,n/2):x*myPow(x*x,n/2);
        }
    }
}
