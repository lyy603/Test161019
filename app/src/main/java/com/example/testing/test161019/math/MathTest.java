package com.example.testing.test161019.math;

/**
 * 作者：linyaye on 2017/2/14 10:08
 */

public class MathTest {

    public static int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int position = length / 2, start = 0, end = length - 1;
        int[] result = {-1, -1};

        if (length == 0 || target < nums[start] || target > nums[end])
            return result;

        while (nums[start] != target || nums[end] != target) {
            if (target < nums[position]) {
                end = position - 1;
                position = (end + start + 1) / 2;
            } else if (target > nums[position]) {
                start = position + 1;
                position = (end + start + 1) / 2;
            } else if (nums[start] == target)
                position = position + 1;
            else
                position = position - 1;
            if (start > end)
                return result;
        }

        result[0] = start;
        result[1] = end;
        return result;
    }

}
