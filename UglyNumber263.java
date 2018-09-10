/**
 * Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example 1:

Input: 6
Output: true
Explanation: 6 = 2 × 3
Example 2:

Input: 8
Output: true
Explanation: 8 = 2 × 2 × 2
Example 3:

Input: 14
Output: false 
Explanation: 14 is not ugly since it includes another prime factor 7.
Note:

1 is typically treated as an ugly number.
Input is within the 32-bit signed integer range: [−231,  231 − 1].
 */
/**
 * 题意：判断一个数是不是丑数，丑数是因子只有2.3.5.的数字，1也是丑数
 * 思路：如果能被2.3.5.整除，那么就直接除去，如果不能，false。最终如果得到的是1 那么true 如果值是0 那么说明本来就是0 返回false；
 * 收获：击败100%
 */
class Solution {
    public boolean isUgly(int num) {
        while(num>=2){
            if(num%2==0) num/=2;
            else if(num%3==0) num/=3;
            else if(num%5==0) num/=5;
            else return false;
        }
        return num==1;
    }
}