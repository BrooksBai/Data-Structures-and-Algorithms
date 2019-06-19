/* 
  LeetCode 698. Partition to K Equal Sum Subsets: https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
  Time: O(?)
  Space: O(n), boolean array to mark used elements entails an automatic O(n) space, and the call stack will take O(n) space.
*/
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sumOfAllArrayItems = 0;
        for (int num : nums) {
            sumOfAllArrayItems += num;
        }
        
        if (k <= 0 || k > nums.length || sumOfAllArrayItems % k != 0) {
            return false;
        }
        
        return canPartitionKSubsets(0, nums, new boolean[nums.length], k, 0, sumOfAllArrayItems / k);
    }
    
    private boolean canPartitionKSubsets(int iterationStart, int[] nums, boolean[] used, int k, int inProgressBucketSum, int targetBucketSum) {
        // We have filled k - 1 buckets, there is 1 bucket left to fill, we know we can complete the partitioning.
        if (k == 1) {
            return true;
        }
        // Bucket full, we have 1 less bucket to fill.
        if (inProgressBucketSum == targetBucketSum) {
            return canPartitionKSubsets(0, nums, used, k - 1, 0, targetBucketSum);
        }
        
        for (int i = iterationStart; i < nums.length; i++) {
            if (!used[i] && inProgressBucketSum + nums[i] <= targetBucketSum) {
                // choose
                used[i] = true;
                // explore
                if (canPartitionKSubsets(i + 1, nums, used, k, inProgressBucketSum + nums[i], targetBucketSum)) {
                    return true;
                }
                // unchoose
                used[i] = false;
            }
        }
        // Partitioning from this point is impossible.
        return false;
    }
}