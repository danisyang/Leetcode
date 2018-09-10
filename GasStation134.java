/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.

Note:

If there exists a solution, it is guaranteed to be unique.
Both input arrays are non-empty and have the same length.
Each element in the input arrays is a non-negative integer.
Example 1:

Input: 
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

Output: 3

Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
Example 2:

Input: 
gas  = [2,3,4]
cost = [3,4,3]

Output: -1

Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.
 */
/**
 * 题意：
 * 思路：经过discuss的结合，有两个重要结论
 *      结论1：如果总油量>总消耗量 那么一定有解
 *      结论2：如果a-->b站 无法到达，那么a-b中间的任意c站，也无法到达b站
 * 结合着两个重要结论，先遍历一遍看是否有解；如有解的话，从头到尾遍历累计油量，如果油量为负，那么这些中间点必然不能作为起点，就要用start=i+1，遍历到最后，第一个就是满足的
    i+1的逻辑在 如果在i处累计油量为负了，那么肯定这一点油量小于消耗值的，所以直接从下一个点开始遍历了。
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int max_fuel = 0;
        for(int i=0;i<gas.length;i++){
            max_fuel += gas[i] - cost[i];
        }
        if(max_fuel<0) return -1;
        int add_fuel = 0;
        int start = 0;
        for(int i=0;i<gas.length;i++){
            add_fuel += gas[i] - cost[i];
            if(add_fuel<0){
                start = i+1;
                add_fuel = 0;
            }
        }
        return start;
    }
}