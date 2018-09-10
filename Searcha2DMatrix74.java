/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(null==matrix||matrix.length==0||matrix[0].length==0)
        return false;
        int row_low = 0;
        int row_high = matrix.length-1;
        
        while(row_low<=row_high){
            int row_mid = row_low + (row_high - row_low) / 2;
            if(target==matrix[row_mid][0])
                return true;
            else if(target<matrix[row_mid][0]){
                row_high = row_mid - 1;
            }
            else{// target > matrix[row_mid][0]
                if(row_mid==matrix.length-1||matrix[row_mid + 1][0]>target){
                    row_low = row_mid;
                    break;
                }else{
                    row_low = row_mid + 1;
                }
            }
        }

        if(row_low<0 || row_low >matrix.length-1)
        return false;
        int low = 0;int high = matrix[0].length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(target == matrix[row_low][mid])
                return true;
            else if(target > matrix[row_low][mid]){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return false;
    }
}