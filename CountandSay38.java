/**
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 * 
 * 1. 1 
 * 2. 11 
 * 3. 21 
 * 4. 1211 
 * 5. 111221 
 * 1 is read off as "one 1" or 11. 
 * 11 is read
 * off as "two 1s" or 21. 21 is read off as "one 2, then one 1" or 1211. 
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * Note: Each term of the sequence of integers will be represented as a string.
 * 
 * Example 1:
 * 
 * Input: 1 Output: "1" Example 2:
 * 
 * Input: 4 Output: "1211"
 * 注意的点：(1)java里 char 是不能被转换成String类型的，s.charAt(index)是char类型，不能赋值给String对象
 *          (2)注意边界条件，以及循环到底是n次还是n-1次
 * 主要的想法是：用sli记录当前的字符，用count记录这个字符重复的次数，
 * 当下一个不是sli时，就说明sli这个字符到头了，记录在tar里，并重置sli和count
 * 当下一个是sli时，count++
 * 当循环结束，两种情况，最后一位和倒数第二位相同或者不同
 * 相同的时候，输出sli和count 不同也同样输出sli和count
 */
class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String num = "1";
        for (int i = 2; i <= n; i++) {
            num = Say(num);
        }
        return num;
    }

    public String Say(String n) {
        String s = n;
        String tar = "";
        int count = 1;
        String sli = Character.toString(s.charAt(0));
        for (int i = 0; i + 1 < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
                sli = Character.toString(s.charAt(i));
            } else {
                tar = tar + count;
                tar = tar + sli;
                count = 1;
                sli = Character.toString(s.charAt(i + 1));
            }
        }
        tar = tar + count;
        tar = tar + sli;
        return tar;
    }
}