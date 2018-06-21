import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, 
replace the number by the sum of the squares of its digits, 
and repeat the process until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1. 
Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */
//题意：图中的2是平方的意思，也就是说，给一个数，拆开，按位取平方，求和，如果能得到1的话，就是说明是happy数
//题意上说，要么是从1退出，要么是陷入无限循环。
//想了一下，如果循环的话，一定是会有重复的数字，因为如果是无限不循环的话，根据题意就算不出来这么个结果。
//比方说，999 拆开 平方 也不到300 ，那么重复到最后，一定是在一个可以预知的数的大小范围内循环的，那么必然有重复
//思路：如果有重复的话，就用set记录中间的数，每一步都记着，如果新的数是1的话，退出，如果是set中的数，返回false;
//收获：打败了48 看到有一种解法说，如果是中间有4那么就是不可以的，应该有一些trick的数学解法，不细究了
class Solution {
    public boolean isHappy(int n) {
        if(n<=0)
            return false;
        Set<Integer> hs = new HashSet<Integer>();
        hs.add(n);
        while(n!=1){
            int num = 0;
            while(n!=0){
                num += (n%10)*(n%10);
                n /= 10;
            }
            if(hs.contains(num)){
                return false;
            }
            else{
                hs.add(num);
            }
            n = num;
        }
        return true;
    }
}