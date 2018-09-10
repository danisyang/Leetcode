import com.sun.scenario.effect.Offset;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.

 */
class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==0||dividend==0)
        return 0;
        if(dividend==Integer.MIN_VALUE&&divisor==-1)
        return Integer.MAX_VALUE;
        //因为输出的结果是int 所以 可能有-MAX 的情况 这种会溢出。。
        //为什么用了long之后就可以通过了。。。
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        boolean flag = false;
        if((dividend<0&&divisor>0)||(dividend>0&&divisor<0))
        flag = false;
        else
        flag = true;
        int ans = 0;
        while(a>=b){
            int offset = 0;
            while(a>=(b<<offset))
                offset++;
        a -= (b<<(offset-1));
        ans += (1<<(offset-1));
    }
        return (flag==true)?ans:-ans;
    }
}