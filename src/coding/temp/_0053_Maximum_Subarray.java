/**
 *  @author Yunxiang He
 *  @date 12/16/2017
 */

package coding.temp;

/*

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.


Example:
    Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4],
    Output: 6
    Explanation: [4, -1, 2, 1] has the largest sum = 6.


Follow up:
    If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

*/

public class _0053_Maximum_Subarray {

    public static void main(String[] args) {
        System.out.println(new _0053_Maximum_Subarray().maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // DP
    // nums[i] can be overwritten
    // nums[i] denotes the maximum sum ends with nums[i]
    // nums(i) = A[i] + nums(i - 1) > 0 ? nums(i - 1) : 0;
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            maxSum = Math.max(maxSum, nums[i]);
        }
        return maxSum;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Divide and Conquer
    // Divide the problem to 3 parts:
    // 1. the maximum subarray lies in the left part
    // 2. the maximum subarray lies in the right part
    // 3. the maximum subarray lies across the mid
    // Combine:
    // Return the largest value of these three
    // Base case:
    // When low == high, the only one element
    public int maxSubArray2(int[] nums) {
        return maxSubArray2_AUX(0, nums.length - 1, nums);
    }

    private int maxSubArray2_AUX(int low, int high, int[] nums) {
        // base
        if (low == high) {
            return nums[low];
        }
        // divide
        int mid = (low + high) / 2;
        // combine
        return Math.max(maxCrossMid(low, high, mid, nums), Math.max(maxSubArray2_AUX(low, mid, nums), maxSubArray2_AUX(mid + 1, high, nums)));
    }

    private int maxCrossMid(int low, int high, int mid, int nums[]) {
        int leftSum = 0;
        int leftMax = Integer.MIN_VALUE;
        for (int i = mid; i >= low; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }
        int rightSum = 0;
        int rightMax = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= high; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }
        return leftMax + rightMax;
    }

}
