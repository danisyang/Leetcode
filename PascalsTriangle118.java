import java.awt.List;
import java.util.ArrayList;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

题意：给一个行数，输出对应的杨辉三角
思路：1迭代算，每个数是他的两个肩膀上的和，
      2排列组合 C(0,0) 
            C(1,0) C(1,1) 
        c(2,0) C(2,1) C(2,2)
收获：get ArrayList 基本操作
*/
//一种迭代解的思路 打败了99
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows <= 0)
        return ans;
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        ans.add(list);
        int i = 2;
        while(i <= numRows){
            list = getThisLine(list);
            ans.add(list);
            i++;
        }
        return ans;
        
    }
    public List<Integer> getThisLine(List<Integer> list){ 
        int len = list.size()+1;
        List<Integer> line = new ArrayList<Integer>();
        for(int i=0; i<len ; i++){
            if(i==0){
                line.add(list.get(0));
                continue;
            }
            if(i==len-1){
                line.add(list.get(len-2));
                continue;
            }
            line.add(list.get(i-1)+list.get(i));
        }
        return line;
    }
}