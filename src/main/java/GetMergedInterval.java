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

