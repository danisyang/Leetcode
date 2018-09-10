import java.util.HashMap;
import java.util.LinkedList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null||strs.length==0)
            return null;
        HashMap<String,List<String>> hashMap = new HashMap<String,List<String>>();
        List<List<String>> ans = new LinkedList<>();
        for(String str : strs){
            char[] chararray = str.toCharArray();
            Arrays.sort(chararray);
            String newstr = chararray.toString();
            if(!hashMap.containsKey(newstr))
                hashMap.put(newstr, new LinkedList<String>().add(str));
            else{
                hashMap.get(newstr).add(str);
            }
        }
        for(List<String> list :hashMap.values()){
            ans.add(list);
        }
    return ans;
    }
}