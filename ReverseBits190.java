/**
 * Reverse bits of a given 32 bits unsigned integer.

Example:

Input: 43261596
Output: 964176192
Explanation: 43261596 represented in binary as 00000010100101000001111010011100, 
             return 964176192 represented in binary as 00111001011110000010100101000000.
Follow up:
If this function is called many times, how would you optimize it?
题意：输入一个数，输出其二进制反转过来的对应的那个数，输入的数要看做unsigned int
思路：肯定是要用位运算的，不能用除了这种方法之外的，太复杂了 涉及到 >>(有符号右移) <<(左移，不用考虑符号) >>>(无符号右移)
收获：对位运算有了新的认识,原答主说必须用 n>>>1 我觉得只需要n>>1 就可以了 ac，打败77
*/
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i=0;i<32;i++){
            result += n&1;
            n >>= 1;
            if(i<31){
                result <<=1;
            }
        }
        return result;
    }
}