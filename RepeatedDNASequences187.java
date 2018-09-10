import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 */
/**
 * 题意：给一个DNA串，求长度为10的连续字串，重复出现的所有的字串。
 * 思路：hash set 对每一个10个长度字符串进行存储，如果发现已经有了，那么就是重复的，此时，用另一个set记录该重复字符串，最后输出字符串列表。
 * 收获：
 */
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new LinkedList<>();
        if(s==null||s.length()<=10)
            return ans;
        Set<String> set = new HashSet<>();
        Set<String> str = new HashSet<>();
        for(int i=0;i<s.length()-0;i++){
            String tmp = s.substring(i, i+10);
            if(!set.add(tmp)){
                str.add(tmp);
            }
        }
        ans.addAll(str);
        return ans;
    }
}