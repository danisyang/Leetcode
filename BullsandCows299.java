import java.util.HashMap;
import java.util.Map;

/**
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. 

Please note that both secret number and friend's guess may contain duplicate digits.

Example 1:

Input: secret = "1807", guess = "7810"

Output: "1A3B"

Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
Example 2:

Input: secret = "1123", guess = "0111"

Output: "1A1B"

Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 */
/**
 * 题意：给两个字符串数字， 如果两个字串中，有一个位置和数字都猜对了，那么bull+1；如果数字猜对了，但是位置没有猜对，cow+1；
 * 思路：如果是bull就直接计数，否则是cow的情况，把两个数出现的次数存在两个数组里，最后，选取最小的那个求和就可以了。
 * 收获：打败了100%
 *      discuss上有只用一个数组记录的做法，类似的。
 */
class Solution {
    public String getHint(String secret, String guess) {
        if(secret==null||guess==null||secret.length()==0||guess.length()==0)
            return "0A0B";
        //Map<Integer,Integer> map1 = new HashMap<>();
        //Map<Integer, Integer> map2 = new HashMap<>();
        int len = secret.length();
        int[] a1 = new int[10];
        int[] a2 = new int[10];
        int[] arrs = new int[10];
        int bull = 0;
        for(int i=0;i<len;i++){
            if(secret.charAt(i)==guess.charAt(i))
                bull++;
            else{
            a1[secret.charAt(i)-'0']++;
            a2[guess.charAt(i)-'0']++;
        }
        }
        int cow = 0;
        for(int i=0;i<10;i++){
            cow += Math.min(a1[i], a2[i]);
        }
/*        for(Integer x:map1.values()){
            if(map2.containsValue(x)){
                cow++;
                for(int index=0;index<map2.size();index++){
                    if(map2.get(index)==x) {map2.remove(index);
                    break;
                    }
                }
            }
        }
        */
        return bull+"A"+cow+"B";
    }
}