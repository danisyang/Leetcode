/**
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
题意：就是写递归上台阶
想法：用数组存每一个步骤的数字，然后上楼，不用递归
收获：if(n<=2)那边，考虑不够，导致数组越界了。
可以优化的是不用数组存，就用O(1)的空间，两个变量存一下前两步的steps就行了
*/
class Solution {
    public int climbStairs(int n) {
        int[] steps = new int[n+1];
        if(n<=2)
            return n;
        steps[1] = 1;
        steps[2] = 2;
        for(int i=3;i<=n;i++){
            steps[i] = steps[i-1] + steps[i-2];
        }
        return steps[n];
    }
}
//空间改进 不用数组
class Solution {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        int first = 1;
        int second = 2;
        int third ;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
}
