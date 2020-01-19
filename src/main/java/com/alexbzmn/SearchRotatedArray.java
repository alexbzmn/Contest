package com.alexbzmn;

public class SearchRotatedArray {

    public static void main(String[] args) {
        int r = new SearchRotatedArray().search(new int[]{1, 3, 5}, 1);
    }

    public int search(int[] nums, int target) {
        if (nums.length < 2) {
            if (nums.length > 0 && nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        int p = findPivot(nums, 0, nums.length - 1);
        if (p == -1) {
            p = 0;
        }

        if (nums[p] == target) {
            return p;
        } else if (target > nums[p] && target <= nums[nums.length - 1]) {
            return find(nums, target, p + 1, nums.length - 1);
        } else {
            return find(nums, target, 0, p - 1);
        }
    }

    public int find(int[] nums, int target, int l, int r) {
        int mid = (l + r) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if (l == r || r < l) {
            return -1;
        }

        if (target > nums[mid]) {
            return find(nums, target, mid + 1, r);
        } else {
            return find(nums, target, l, mid);
        }
    }

    public int findPivot(int[] nums, int l, int r) {
        if (l == r) {
            return -1;
        }

        int mid = (l + r) / 2;

        if (nums[mid] > nums[mid + 1]) {
            return mid + 1;
        }

        if (mid > 0 && nums[mid] < nums[mid - 1]) {
            return mid;
        }

        if (nums[l] > nums[mid]) {
            return findPivot(nums, l, mid);
        } else {
            return findPivot(nums, mid + 1, r);
        }

    }
}