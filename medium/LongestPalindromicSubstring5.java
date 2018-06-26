import javax.lang.model.util.ElementScanner6;

import sun.security.util.Length;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
题意：找最长回文串
思路：最low的方法就是O(n^3)从最后一个字符开始找，这个字符，是结束，然后以每一个为开始，判断是否是回文，判断是O(n),太low了

总结：有四种方法
1、bf 暴力解决，先确定一个长度，然后根据每个长度确定头尾字符， 每个字符O(n)判断是否是回文 总共是O(n^3)
2、dp 动态规划 
3、expand 中心拓展法 先确定一个对称中心，从中心往两边发散出去，每个中心是O(n)的复杂度 总共O(n^2)
4、马拉车算法 O(n)
 */
//通过反转s得到s' 然后找最大公共字串，代码是对的，但是这种思路是错的，因为，最长回文串显然是s和s'的公共字串，但是最长的公共字串却不一定是最长的回文串
//SS = "abacdfgdcaba", S'S​="abacdgfdcaba". 这个最长的公共字串是abacd 但是不是回文串

//wrong way to try 
class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<=1)
            return s;
        int len = s.length();
        StringBuffer sBuffer = new StringBuffer();
        for(int i=len-1;i>=0;i--){
            sBuffer.append(s.charAt(i));
        }
        String t = new String(sBuffer);
        return longestCommoString(s, t);
    }
    public String longestCommoString(String s,String t){ //记住这个方法，求两个字符串的最长公共子串
        if(s==null || t==null)
            return null;
        int lens = s.length();
        int lent = t.length();
        int[][] st = new int[lens][lent];
        for(int i=0;i<lens;i++)
            for(int j=0;j<lent;j++){
                if(s.charAt(i)==t.charAt(j)){
                    if(i>=1&&j>=1){
                        st[i][j] = st[i-1][j-1] + 1;
                    }
                    else{
                        st[i][j] = 1;
                    }
                }
                //没有匹配的话 什么都不用做
            }
        int max = 0;
        int maxi = -1;
        int maxj = -1;
        for(int i=0;i<lens;i++)
            for(int j=0;j<lent;j++){
                if(st[i][j]>max){
                    max = st[i][j];
                    maxi = i;
                    maxj = j;
                }
            }
        return t.substring(maxj-(max-1), max+maxj-(max-1));//[a,b)
    }
}
//dp way
//初始化这里有点啰嗦了，但是不想改了。初始化这里可以直接优化成O(n).目前是O(n^2)
//dp 的思路主要是 把以前每个长度的字符串判断，改成自底向上，判断每个子问题的回文状态，然后得出上层问题的回文状态，减少重复计算
// 例如 长度为4个字符的回文判断就是 长度为2的回文判断加上边上两个字符相等状态判断，同理，3个字符也是 1个字符加上边上两个字符的相等状态
// 那么边界条件是，回文长度为1 和回文长度为2 的情况，在本题里，我定义其size 为0 ，1 所以需要初始化
// 如果优化的话，空间可能被优化成O(n)吧，即只记录最近状态的情况，然后更新本层的状态，但是不想改了。。
// 时间复杂度是O(n^2)
class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<=1)
            return s;
        if(s.length()==2){
            if(s.charAt(0)==s.charAt(1))
                return s;
            return s.substring(0,2);
        }
        int max = 0;
        String ans = s.substring(0, 1);
        int n = s.length();
        boolean[][] longest = new boolean[n][n];
        for(int i=0;i<n;i++){ //init this matrix
            for(int j=0;j<n;j++){
                if(i==j)
                    longest[i][j] = true;
                else if(j==i+1){
                    longest[i][j] = (s.charAt(i)==s.charAt(j));
                    if(longest[i][j]==true){
                        max = 1;
                        ans = s.substring(i,i+2); //substring(a,b) [a,b) and b can bigger than length.
                    }
                }
                else 
                    longest[i][j] = false;
            }
        }
        //dp to solve the question 
        for(int size=2;size <s.length();size++){ //size = 1  or size = 0 has already been inited before.
            for(int low = 0; low<s.length()-size;low++){ // i+size < s.length()
                if(longest[low+1][low+size-1]&&s.charAt(low)==s.charAt(low + size)){
                    longest[low][low + size] = true;
                    if(size > max){
                        max = size;
                        ans = s.substring(low, low+size+1);
                    }
                }
            }
        }
        return ans;
    }
}
//expand try 
//既然是回文串，那么一定有一个对称轴，（两种情况，奇数或者偶数）
//那么就从倒数第二个字符开始 O(n)的复杂度假设每个字符是对称轴的情况，针对每个对称轴，然后向两边扩散，O(n)找到这种情况下的最大回文串，
//总体的时间是O(n^2)
//需要注意的就是 是对称轴的情况有两种，奇数或者偶数
//收获 字符串这里的知识点太薄弱了 这种思路很好！！打败了48
class Solution {
    String ans = "";
    int max = 0;
    public String longestPalindrome(String s) {
        if(s==null||s.length()<=1)
            return s;
        for(int i=s.length()-2;i>=0;i--){ //-2 to make i+1 is legal in range 0~len-1
            checkExpand(s, i, i);//odds            cbabd
            checkExpand(s, i, i+1);//even         dabbac
        }
        return ans;
    }
    public void checkExpand(String s ,int low ,int high){
        //low and high determine the odds or even 
        while(low>=0 && high<=s.length()-1){
            if(s.charAt(low)==s.charAt(high)){
                if(high-low+1 > max){
                    max = high - low + 1;
                    ans = s.substring(low, high+1);
                }
                low--;
                high++;
            }
            else{
                return ;
            }
        }
        return ;
    }
}
//manacher算法 O(n)找到最长回文数的算法 应该是已知最快的算法
