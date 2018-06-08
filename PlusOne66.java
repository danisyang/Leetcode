/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

题意：就是把一个数组看成数字，+1后，结果再放在一个数组里。
思路：其实应该就是考察进位的问题。当最后一位有进位的时候，数组应该比原来长一位。
收获：carry 和 digits[i]顺序求反了 应该先求carry的数
     carry 默认的1 ，或许真的需要一个tmp存一下当前的数字
 */
class Solution {
    public int[] plusOne(int[] digits) {
        if(digits==null||digits.length==0)
            return null;
        int d =0;
        int carry  = 1;
        for(int i=digits.length-1;i>=0;i--){
            d = digits[i] + carry;
            carry = d / 10;
            digits[i] = d % 10;
            
        }
        if(carry==0)
            return digits;
        else{
            int[] nums = new int[digits.length+1];
            nums[0] = carry;
            for(int i=0;i<digits.length;i++){
                nums[i+1] = digits[i];
            }
            return nums;
        }
    }
}
//discusss 上看到了一个吊炸天的解法 每一位是9的话，才需要考虑进位 数组加长的唯一可能是999+1=1000这种情况
class Solution{
    public int[] plusOne(int[] digits) {
            
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            digits[i] = 0;
        }
        
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
        
        return newNumber;
    }
}