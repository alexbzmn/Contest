package com.alexbzmn;

public class BinarySearchRange {
    public int[] searchRange(int[] nums, int target) {
        // 5 7 7 8 8 8 10
        // 1 3 3
        // 1 3
        // 1

        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = findLeft(nums, target, 0, nums.length - 1);
        int right = findRight(nums, target, 0, nums.length - 1);

        return new int[]{left, right};
    }

    public int findRight(int[] nums, int target, int l, int r) {
        int mid = (l + r) / 2;

        if (nums[mid] == target) {
            if (mid == nums.length - 1 || (mid < nums.length - 1 && nums[mid + 1] > target)) {
                return mid;
            }
        }

        if (r <= l) {
            return -1;
        }

        if (nums[mid] > target) {
            return findRight(nums, target, l, mid - 1);
        } else {
            return findRight(nums, target, mid + 1, r);
        }
    }

    public int findLeft(int[] nums, int target, int l, int r) {
        int mid = (l + r) / 2;

        if (nums[mid] == target) {
            if (mid == 0 || (mid > 0 && nums[mid - 1] < target)) {
                return mid;
            }
        }

        if (l == r) {
            return -1;
        }

        if (nums[mid] >= target) {
            return findLeft(nums, target, l, mid);
        } else {
            return findLeft(nums, target, mid + 1, r);
        }
    }
}
