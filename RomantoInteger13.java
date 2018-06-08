import javax.lang.model.util.ElementScanner6;

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together.
 Twelve is written as, XII, which is simply X + II. 
 The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. 
However, the numeral for four is not IIII. Instead, the number four is written as IV. 
Because the one is before the five we subtract it making four. 
The same principle applies to the number nine, which is written as IX. 
There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: "III"
Output: 3
Example 2:

Input: "IV"
Output: 4
Example 3:

Input: "IX"
Output: 9
Example 4:

Input: "LVIII"
Output: 58
Explanation: C = 100, L = 50, XXX = 30 and III = 3.
Example 5:

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/
class Solution {
    public int romanToInt(String s) {
        int cal = 0;
        int len = s.length();
        int i;
        for (i=0;i<len-1;i++){//每次拿出两位，最后一位最后处理
            switch(s.charAt(i)){
                case 'I':
                    if(s.charAt(i+1)=='V'){
                        i++;
                        cal += 4;
                    }
                    else if(s.charAt(i+1)=='X'){
                        i++;
                        cal += 9;
                    }
                    else {cal +=1;}
                    break;
                case 'V':
                    cal += 5;
                    break;
                case 'X':
                    if (s.charAt(i + 1) == 'L') {
                    i++;
                    cal += 40;
                    } else if (s.charAt(i + 1) == 'C') {
                    i++;
                    cal += 90;
                    } else {
                    cal += 10;
                    }
                    break;
                case 'L':
                    cal += 50;
                    break;
                case 'C':
                    if (s.charAt(i + 1) == 'D') {
                    i++;
                    cal += 400;
                    } else if (s.charAt(i + 1) == 'M') {
                    i++;
                    cal += 900;
                    } else {
                    cal += 100;
                    }
                    break;
                case 'D':
                    cal += 500;
                    break;
                case 'M':
                    cal += 1000;
            }
        }
        if(i==len-1){
            switch(s.charAt(i)){
                case 'I':
                    cal += 1;
                    break;
                case 'V':
                    cal +=5;
                    break;
                case 'X':
                    cal += 10;
                    break;
                case 'L':
                    cal += 50;
                    break;
                case 'C':
                    cal += 100;
                    break;
                case 'D':
                    cal += 500;
                    break;
                case 'M':
                    cal += 1000;
                    break;
            }
        }    
        return cal;
    }
}
//以下为leetcode  discuss  代码
public class Solution {
    public int romanToInt(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        if (s.length() == 1) {
            return map.get(s.charAt(0));
        }
        sum += map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))
                sum -= map.get(s.charAt(i));
            else
                sum += map.get(s.charAt(i));
        }
        return sum;
    }
}