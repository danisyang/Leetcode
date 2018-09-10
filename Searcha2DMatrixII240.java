/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
 */
/**
 * 题意：有一个二维数组，列和行都是单调增加的，查找一个数是否存在。
 * 思路：从左下角或者右上角开始查找，如果等于返回true，如果大于target  列-- 如果小于target 行++
 * 收获：击败43.86%
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(null==matrix||matrix.length==0||matrix[0].length==0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int x=0,y=n-1;
        while(x<m&&y>=0){
            if(matrix[x][y]==target)
                return true;
            else if(matrix[x][y]<target){
                x++;
            }else{
                y--;
            }
        }
        return false;
    }
}