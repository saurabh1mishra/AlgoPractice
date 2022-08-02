package arrays;

import java.io.*;
import java.util.*;


/**
 * STDIN    Function
 * -----    --------
 * 5    →   intervals[] size n = 5
 * 2    →   intervals[i] size always 2
 * 6 9  →   intervals = [[6, 9], [2, 3], [9, 11], [1, 5], [14, 18]]
 * 2 3
 * 9 11
 * 1 5
 * 14 18
 */

/**
 * https://www.youtube.com/watch?v=qKczfGUrFY4&t=96s
 */

class GetMergedInterval {

    /*
     * Complete the 'getMergedIntervals' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY intervals as parameter.
     */

    public static List<List<Integer>> getMergedIntervals(List<List<Integer>> intervals) {

        List<Integer> visited = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        for (List<Integer> list : intervals) {
            int start = list.get(0);
            int end = list.get(1);
            while (start < end) {
                visited.add(start);
                start++;
            }
        }

        Collections.sort(visited);
        boolean continuation = false;
        int prev = visited.get(0);
        List<Integer> list = new ArrayList<>();
        for (Integer integer : visited) {
            if (!continuation) {
                list = new ArrayList<>();
                list.add(prev);

            }
            if (prev + 1 == integer || prev == integer) {
                continuation = true;

            } else {
                list.add(prev);
                result.add(list);
                continuation = false;
            }
            prev = integer;
        }

        return result;
    }

    public int[][] merge_usingLinkList(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public int[][] merge2(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        for (int[] interval : intervals)
            if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < interval[0]) ans.add(interval);
            else ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], interval[1]);
        return ans.toArray(new int[ans.size()][]);
    }

    public int[][] merge_interVal(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        List<int[]> output_arr = new ArrayList<>();
        int[] current_interval = intervals[0];
        output_arr.add(current_interval);

        for (int[] interval : intervals) {
            int cur_begin = current_interval[0];
            int cur_end = current_interval[0];
            int next_begin = interval[0];
            int next_end = interval[1];

            if (cur_end > next_begin) {
                current_interval[1] = Math.max(cur_end, next_end);
            } else {
                current_interval = interval;
                output_arr.add(current_interval);
            }
        }

        return output_arr.toArray(new int[output_arr.size()][]);
    }


    public static void main(String[] args) throws IOException {
        List<List<Integer>> input = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(6);
        list1.add(9);
        input.add(list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        input.add(list2);

        List<Integer> list3 = new ArrayList<>();
        list3.add(9);
        list3.add(11);
        input.add(list3);

        List<Integer> list4 = new ArrayList<>();
        list4.add(1);
        list4.add(5);
        input.add(list4);

        List<Integer> list5 = new ArrayList<>();
        list5.add(14);
        list5.add(18);
        input.add(list5);


        System.out.println(GetMergedInterval.getMergedIntervals(input));
    }
}

