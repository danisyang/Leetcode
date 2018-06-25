/**
 * Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
题意:求小于这个数的素数个数
思路：筛法求素数
收获：less than这里有个坑 i<n 而不是i<=n
        这道题的主要问题应该在于 时间复杂度 isPreme计算的时间复杂度在O(n^2)
        筛法的时间复杂度在O(n)，空间复杂度在O(n)
        打败了66
*/
class Solution {
    public int countPrimes(int n) {
        boolean[] isPreme = new boolean[n];
        for(int i=1;i<n;i++){
            isPreme[i]=true;
        }
        for(int i=2;i*i<n;i++){
            if(!isPreme[i])
                continue;
            for(int j=i*i;j<n;j+=i){ //j是i*i的原因是小于i倍的一定被筛过了。比如i是5的时候，2*5 被2筛过了，所以至少从i*i开始
                isPreme[j]=false;
            }
        }
        int count = 0;
        for(int i=2;i<n;i++){
            if(isPreme[i])
                count++;
            }
        return count;
    }
}

class Solution {
    public int countPrimes(int n) {
        int count = 0;
        for(int i=0;i<=n;i++){
            if(isPrime(i))
                count++;
        }
        return count;
    }
    public boolean isPrime(int n){
        if(n<2)
            return false;
        if(n==2)
            return true;
        for(int i=2;i<=(int)Math.sqrt(n)+1;i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
}