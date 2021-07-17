package Leetcode287_FindDuplicate;

public class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int start = 1;
        int end = len - 1;

        while (end > start) {
            int mid = start + (end - start) / 2;
            int left = 0;
//            int right = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] >= start && nums[i] <= mid) {
                    left++;
                }
//                if (nums[i] >= mid + 1 && nums[i] <= end) {
//                    right++;
//                }
            }
            if (left > mid - start + 1) {
                end = mid;
                continue;
            }else{
                start = mid + 1;
            }
//            if (right > end - mid ) {
//                start = mid + 1;
//            }
        }
        return start;
    }
}
