/**
 * Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.

题意：非负整数的x，求其2次根号下的值的整数部分
思路：就循环，如果i^2 >x 的时候，返回i-1
收获：1，i在循环里赋值，在return里返回，作用域出错
     2，for 的判断条件，i<x 改成了i<=x 因为有1 的存在！！考虑不周
     3，2147483647 这个时间超出限制了，看来还是不能用这种方法，
     倒不是说超出限制了，因为按照我的判断方法，是不可能有i*i > 这个数的，因为就越界了。解决方案，判断的时候 i*i>x || i*i <0 
     4，测试的时间显示，线性的方案不是一个好方案，应该用二分查找类似的方法。
 */
class Solution {
    public int mySqrt(int x) {
        if(x==0)
            return 0;
        int i;
        for(i=0;i<=x;i++){
            if (i*i==x)
                return i;
            else if(i*i>x)
                break;
        }
        return i-1;
    }
}
//修改后 AC代码 打败了5%的用户。。
class Solution {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int i;
        for (i = 0; i <= x; i++) {
            if (i * i == x)
                return i;
            else if (i * i > x || i * i < 0)
                break;
        }
        return i - 1;
    }
}
//discuss 上有牛顿法和二分查找法
//这个是二分查找 大致就是不断缩小mid的位置 没仔细看边界条件 mid > x / mid 就可以大致理解为 mid*mid > x 然后 mid 大概能缩小为一半 
class Solution{
    public int sqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }
}
//牛顿法：有空看一下牛顿法 是什么意思