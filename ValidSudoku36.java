import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.

 */
//记录一下 写完一次性提交，一次性accepted ！！击败了81.30%
//
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board==null||board.length<9||board[0].length<9)
            return false;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(!set.add(board[i][j])){
                        return false;
                    }
                }
            }
            set.clear();
        }
        set.clear();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (!set.add(board[j][i])) {
                        return false;
                    }
                }
            }
            set.clear();
        }
        set.clear();
        for(int i=0;i<9;i=i+3){
            for(int j=0;j<9;j=j+3){
                for(int k=i;k<i+3;k++){
                    for(int l=j;l<j+3;l++){
                        if(board[k][l]!='.'){
                            if(!set.add(board[k][l])){
                                return false;
                            }
                        }
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}

/**
 * 我的做法比较繁琐，等于遍历了三次，第一次只看行，第二次看列，第三次看的是小格；
 * discuss 的做法很巧妙，只遍历一次，把行列和小格的编码成为三种type的value，
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i / 3 + b + j / 3))
                        return false;
                }
            }
        }
        return true;
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set set = new HashSet();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if(board[i][j]!='.'){
                String b = "("+board[i][j]+")";
                if(!set.add(i+b)||!set.add(b+j)||!set.add(i/3+b+j/3)){
                    return false;
                }
                }
            }
            }
        return true;
    }
}