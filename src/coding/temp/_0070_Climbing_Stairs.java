/**
 *  @author Yunxiang He
 *  @date 10/17/2017
 */

package coding.temp;

/*

You are climbing a stair case. 
It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. 
In how many distinct ways can you climb to the top?


Example 1:
    Input: 2
    Output:  2
    Explanation:  There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps

Example 2:
    Input: 3
    Output:  3
    Explanation:  There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step


Note:
    Given n will be a positive integer.

*/

public class _0070_Climbing_Stairs {

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int climbStairs_DP(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int step = 0;
        int pre1 = 1;
        int pre2 = 2;
        for (int i = 2; i < n; ++i) {
            step = pre2 + pre1;
            pre1 = pre2;
            pre2 = step;
        }
        return step;
    }
}