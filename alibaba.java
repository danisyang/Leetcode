import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^ **/
    static int maxAreaRectWithSumZero(int[][] mat, int row, int col) {
        if(mat==null||row==0||col==0)
            return 0;
        int m = mat.length;
        int n = mat[0].length;
        int max = 0; 
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                for(int l= i;l<row;l++)
                    for(int k = j;k<col;k++){
                if(getSum(mat,i,j,l,k)*2==(l-i+1)*(k-j+1)){
                    max = (max>(l-i+1)*(k-j+1)/2)?max:(l-i+1)*(k-j+1)/2;
                }
            }
        }
        return max;
        
    }
    static int getSum(int[][] mat,int a,int b,int c,int d){
        int sum = 0;
        for(int i=a;i<=b;i++)
            for(int j=c;j<=d;j++){
                if(mat[i][j]==1){
                    sum++;
                }
            }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res = 0;
        int _mat_rows = 0;
        int _mat_cols = 0;
        _mat_rows = Integer.parseInt(in.nextLine().trim());
        _mat_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _mat = new int[_mat_rows][_mat_cols];
        for (int _mat_i = 0; _mat_i < _mat_rows; _mat_i++) {
            for (int _mat_j = 0; _mat_j < _mat_cols; _mat_j++) {
                _mat[_mat_i][_mat_j] = in.nextInt();

            }
        }

        res = maxAreaRectWithSumZero(_mat, _mat_rows, _mat_cols);
        System.out.println(String.valueOf(res));

    }
}