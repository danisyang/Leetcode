import java.util.Arrays;
import java.util.Map;

/**
 * Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
 */
//击败98%
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null||nums.length==0) return false;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1])
                return true;
        }
        return false;
    }
}

//击败14.93%
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) return true;
            else map.put(nums[i], 1);
        }
        return false;
    }
}

//用set貌似更合理一些。。击败了76%
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums)
            if (!set.add(i))// if there is same
                return true;
        return false;
    }
}