import java.awt.List;
import java.util.ArrayList;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?

题意：从第0 行开始算，求第k行的杨辉三角的行数
思路：1.排列组合
     2.还是尽量不用多的空间进行迭代
收获：击败了53 还是不行，因为每次都开辟新的空间了。
    改进：开辟新空间的原因是每次 后一位会用到前一位的值，解决方案是 从后往前算 j=i i>=0 j-- 倒着算不影响
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        if(rowIndex == 0)
        return list;
        for(int i=1;i <= rowIndex;i++){
            List<Integer> line = new ArrayList<Integer>(list);;
            for(int j = 1; j < i;j++){ // i is the len of last line 
                list.set(j,line.get(j)+line.get(j-1));
            }
            list.add(1);
        }
        return list;
    }
}