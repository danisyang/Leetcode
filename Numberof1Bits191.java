/**
 *Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Example 1:

Input: 11
Output: 3
Explanation: Integer 11 has binary representation 00000000000000000000000000001011 
Example 2:

Input: 128
Output: 1
Explanation: Integer 128 has binary representation 00000000000000000000000010000000
题意：就是找这个数作为二进制的字符里有多少个1
思路：就是不断去%2 然后/2 一位一位算
注：汉明权重是一个字符串里，不为'0'的字符的个数
收获：就知道没这么简单，肯定有坑，果然是有边界值问题，2^31，不能用乘除法这种方法去做，因为 对于负数的补码，就不能用/2去取最后一位
discuss上的方法是按照 位运算做的，每次→移一位，然后和1做与运算，如果结果==1说明是cnt++
当然也可以用字符串方法做，没意思啊
理解原码补码和反码的意义，以及负数存反码的时候是如何存的。全为1是-1 1后面全是0 是-(2^31)
and %(取余) 和mod(模运算) 居然是不同的两种运算，omg， 取余 负数的余数一定是负的，而模运算可以是正的
具体参考我收藏的blog
*/
//correct code
//打败63
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        for(int i=0;i<32;i++){
            if((n>>i & 1) == 1){
                cnt++;
            }
        }
        return cnt;
    }
}
//error code
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        if(n == -2147483648)
            return 1;
        while(n>0){
            if(n%2==1)
                cnt++;
            n /= 2;
        }
        if(n<0){
            cnt = 1;
            while(o<0){
                if(o%2==-1){
                    cnt++;
                }
                o/=2;
            }
        }
        return cnt;
    }
}
//4294967295(11111111111111111111111111111111) 这个补码表示的是-1