import java.awt.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
/**
 * 非常重要的一点是去重。。 在于每次遍历的时候，遇到下一位和自己一样的那么就直接到最后一个和自己一样的位置去，这样能保证是去重的。
 * 击败了4.25%
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
      List<List<Integer>> ans = new LinkedList<>();
      if(null==nums||nums.length<4) return ans;
      Arrays.sort(nums);
      Set<Integer> set = new HashSet<>();
      int len = nums.length;
      for(int i=0;i<len-3;i++){
        if(i!=0&&nums[i]==nums[i-1])
          continue;
        for(int j=i+1;j<len-2;j++){
          if(j!=i+1&&nums[j]==nums[j-1])
            continue;
          int need = target - nums[i] - nums[j];
          set.clear();
          for(int k=j+1;k<len;k++){
            if(set.contains(need-nums[k])){
              List<Integer> list = new LinkedList<>();
              list.add(nums[i]);list.add(nums[j]);list.add(need-nums[k]);list.add(nums[k]);
              ans.add(list);
              while(k+1<len&&nums[k+1]==nums[k]){
                k++;
              }
            }
            set.add(nums[k]);
          }
        }
      }
      return ans;
    }
}