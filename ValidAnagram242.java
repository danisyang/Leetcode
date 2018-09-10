import java.util.HashMap;
import java.util.Map;


/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
//打败了4.22%
class Solution {
    public boolean isAnagram(String s, String t) {
        if(null==s||null==t||s.length()!=t.length())
            return false;
        Map<Integer,Integer> hashMap = new HashMap<>();
        int len = s.length();
        for(int i=0;i<len;i++){
            int k = s.charAt(i)-'a';
            if(hashMap.containsKey(k)){
                int v = hashMap.get(k);
                hashMap.put(k, ++v);
            }else{
                hashMap.put(k, 1);
            }
        }
        for(int i=0;i<len;i++){
            int k = t.charAt(i)-'a';
            if(hashMap.containsKey(k)){
                int v = hashMap.get(k);
                if(v<=0) return false;
                hashMap.put(k, --v);
            }else{
                return false;
            }
        }
        for(Integer v:hashMap.values()){
            if(v!=0)
            return false;
        }
        return true;
    }
}

//discuss上看到的 一个方法 这个不用hash也可以的。不过主要锻炼一下hash的写法
//击败了40.14%
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}