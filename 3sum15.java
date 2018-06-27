import java.util.Arrays;
import java.util.LinkedList;

import javax.lang.model.util.ElementScanner6;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
题意：给一个数组，然后求出所有的，三个数加起来结果是0的情况，给出这三个数。且这三个数不要重复出现
思路：先给整个数组排个序，然后按照最外层循环每一个数，那么针对每一个数，这个问题就变成了，有一个数a，从它后面找两个数，加起来和是-a；这个题就是O(n)的做法
那么整体的复杂度就是O(n^2)的复杂度
有序数组找和为某个固定数的做法有两种，一种是借助hash表，另一种是low和high分别从两边朝中间走，如果他们的和大于target则high--，否则low++
312/313 有一个例子一直没有过，真的是不知道问题在哪儿，看结果的时候，是有重复元素，但是为啥会出现重复元素呢 312条都是ok的
 */
//这种方法的失败在找重复的时候，太繁琐了，时间复杂度太高，应该在查找的时候就去重，就像下面的方法里写的那样，直接指向相等的low的最后一个和high的最小的一个元素，不用再ans的list表里查询为什么会重复
//但是为什么失败了，会有重复，我也不清楚了
//收获：做题不容易，且行且珍惜。加油吧。方法2打败了28
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      
      List<List<Integer>> ans =new LinkedList<>();
      if(nums==null||nums.length<3)
        return ans;
        int len = nums.length;
      Arrays.sort(nums);
      for(int i=0;i<len-2;i++){
        if(i>0&&nums[i]==nums[i-1])
          continue;//保证没有重复的list发生，只要保证第一个元素即target不重复就好，既然是 已经有序的，那么和前一个不一样就是
        int target=nums[i]*(-1);
        
        int low = i+1;
        int high = len-1;
        while(low<high){
          List<Integer> list = new LinkedList<Integer>();
          if(nums[low]+nums[high]>target){
            high--;
          }
          else if(nums[low]+nums[high]<target){
            low++;
          }
          else {//这里还得加一个判断，就是说，如果[-2,0,0,2,2]这种情况，虽然target确定了，但是还是得判断一下
            list.add(nums[i]);
            list.add(nums[low]);
            list.add(nums[high]);
            //单独拿出来最后一个list判断一下和这个list是否是一样的，如果是一样的就不存了
            //
            int anssize= ans.size();
            if(anssize==0){
              ans.add(list);
            }
            else if(anssize>0&&ans.get(anssize-1).get(1)==list.get(1)&&ans.get(anssize-1).get(2)==list.get(2)&&ans.get(anssize-1).get(0)==list.get(0)){
            }
            else{
              ans.add(list);
            }
                
            low++;
            high--;
          }
        }
      }
      return ans;
    }
}

class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new LinkedList<>();
    if (nums == null || nums.length < 3)
      return ans;
    int len = nums.length;
    Arrays.sort(nums);
    for (int i = 0; i < len - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue;// 保证没有重复的list发生，只要保证第一个元素即target不重复就好，既然是 已经有序的，那么和前一个不一样就是
      int target = nums[i] * (-1);
      int low = i + 1;
      int high = len - 1;
      while (low < high) {
        List<Integer> list = new LinkedList<Integer>();
        if (nums[low] + nums[high] > target) {
          high--;
        } else if (nums[low] + nums[high] < target) {
          low++;
        } else {// 这里还得加一个判断，就是说，如果[-2,0,0,2,2]这种情况，虽然target确定了，但是还是得判断一下
          list.add(nums[i]);
          list.add(nums[low]);
          list.add(nums[high]);
          ans.add(list);
          while(low<high&&nums[low]==nums[low+1])
            low++;
          while(high>low && nums[high]==nums[high-1])
            high--;
          low++;
          high--;
        }
      }
    }
    return ans;
  }
}