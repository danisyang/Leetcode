/*
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * Input: 123 Output: 321 Example 2:
 * 
 * Input: -123 Output: -321 Example 3:
 * 
 * Input: 120 Output: 21
 * 
 * Note: Assume we are dealing with an environment which could only store
 * integers within the 32-bit signed integer range: [−231, 231 − 1]. For the
 * purpose of this problem, assume that your function returns 0 when the
 * reversed integer overflows.
 *
 一个数的范围是 [-2^31 ~ 2^31-1] 加上0一共是2^32次方个数
 负数的取反是正数，但是当-2^31取反的时候，反过来的数溢出了，还是自己本身，
 就是abs(-2^31) = -2^31;
 思路的闪光点就是 在比较大小的时候，当少一位的时候，那个数已经大于最大数/10，那么此时必然已经知道溢出了。
 另一个教训就是，写代码的时候，一定要注意安全，不要连着写太多，用白名单的方式，答案的方法用remaing > 0的方法就解决了之前的问题。
 而我用的是！=0 ，如果用了> 0,就更安全一些。
 todo：有空研究一下 原码补码反码 以及乘除法 溢出等的具体流程
 */
class Solution {
    public int reverse(int x) {
        int flag = x >= 0? 1:-1;
        if(x=-2147483648)
            return 0;
        int absnum = x >=0? x:-x;
        int absout = 0;
        int count=0;
        while(absnum!=0){
            count++;
            if(count==10 && absout>Integer.MAX_VALUE/10){
                return 0;
            }

            absout = absout *10 + (absnum)%10;
            absnum /= 10;
        }
        return flag*absout;

    
    }
}

class Solution {
    public int reverse(int x) {
        if (x >= 0) {
            return reversePos(x);
        } else {
            return -(reversePos(-x));
        } // negative input is the same. Just need to convert to positive first.
    }

    public int reversePos(int x) {
        int currentDigit;
        int remaining = x;
        int sum = 0;
        int count = 0;

        while (remaining > 0) {
            count++; // keeps track of the number of digits converted

            if (count == 10 && sum > Integer.MAX_VALUE / 10) {
                return 0; // tests the overflow right before the conversion of the 10th digit and
                          // remaining is not 0
            }

            currentDigit = remaining % 10;
            remaining /= 10;
            sum = sum * 10 + currentDigit;
        }
        return sum;
    }
}