/**
 * Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.
 */
/**
 * 题意：找到第n个丑数，丑数是只有2.3.5作为因子的数 另外1也是丑数
 * 思路：只有2.3.5作为因子，那么每个数必然都是被前面的丑数乘以2.3.5.得到的 用i2 i3 i5 来标记离当前丑数步伐最近的下标。
 *      那么下一个丑数必然出现在，i2*2 i3*3 i5*5 之间，min取值就可以
 */
class Solution {
    public int nthUglyNumber(int n) {
        if(n==0) return 0;
        int[] uglys = new int[n];uglys[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for(int i=1;i<n;i++){
            int lastugly = uglys[i-1];
            while(uglys[i2]*2<=lastugly) i2++;
            while(uglys[i3]*3<=lastugly) i3++;
            while(uglys[i5]*5<=lastugly) i5++;
            uglys[i] = Math.min(Math.min(uglys[i2]*2, uglys[i3]*3), uglys[i5]*5);
        }
        return uglys[n-1];
    }
}