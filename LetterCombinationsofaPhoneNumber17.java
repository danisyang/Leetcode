import java.util.LinkedList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
*/
/**
 * Input: "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
/**
 * 
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits==null || digits.length()==0)
            return ans;
        String[] nums = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        //
            ans.add("");
            while(ans.peek().length()!=digits.length()){
                // 位数不够，需要补位
                String tmp = ans.remove();//remove的是第一个
                String map = nums[digits.charAt(tmp.length())-'0'];
                for(char c : map.toCharArray()){
                    ans.add(tmp+c);
                }
            }
        return ans;
    }
}