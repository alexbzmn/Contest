package com.alexbzmn;

import java.util.*;

public class MergeIntervals {

    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(new MergeIntervals().merge(new int[][]{new int[]{3, 4}, new int[]{1, 2}, new int[]{4, 6}, new int[]{9, 12}})));

    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Stack<Interval> s = new Stack<>();
        s.push(new Interval(intervals[0][0], intervals[0][1]));

        for (int i = 1; i < intervals.length; i++) {

            Interval interval = s.peek();

            if (interval.finish >= intervals[i][0] && interval.finish < intervals[i][1]) {
                interval.finish = intervals[i][1];
                s.pop();
                s.push(interval);
            } else if (interval.finish < intervals[i][1]) {
                s.push(new Interval(intervals[i][0], intervals[i][1]));
            }
        }

        int[][] res = new int[s.size()][intervals[0].length];
        for (int i = res.length - 1; i >= 0; i--) {
            Interval interval = s.pop();
            res[i][0] = interval.start;
            res[i][1] = interval.finish;
        }
        return res;
    }

    private class Interval {
        int start;
        int finish;

        private Interval(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
}
