/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:


The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
题意：大数乘法
思路：循环两两相乘，用控制下标的方法来控制结果。具体见discuss置顶，用pos数组控制进位和当前位结果，最后转字符串
收获：1.乘法主要是下标这边
     2.两个数相乘，结果位数最多是他们位数之和
     3.控制pos数组的前导0
     4.0*0等特殊结果转字符串时候的判断
*/
class Solution {
    public String multiply(String num1, String num2) {
        if(num1==null||num2==null||num1.length()==0||num2.length()==0)
            return null;
        String ans = "";
        if(num1.length()<num2.length()){
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        int carry = 0;
        int l1 = num1.length();
        int l2 = num2.length();
        int[] pos = new int[l1+l2];
        for(int i = l1-1;i>=0;i--)
            for(int j = l2-1;j>=0;j--){
                int product = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                product += pos[i+j+1];
                pos[i+j+1] = product%10;
                pos[i+j] += product/10;
            }
        StringBuffer sb = new StringBuffer();
        for(int i : pos){
            if(sb.length()==0&&i==0)
                continue;
            else 
                sb.append(i);
        }
        return sb.length()==0?"0":sb.toString();
    }
}