package DS.Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GetMaxNumberInSlidingWindow {


    public static List<Integer> solution(final List<Integer> nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            if (i < k) {
                queue.add(nums.get(i));
            } else {
                result.add(queue.peek());
                queue.remove(nums.get(i - k));
                queue.add(nums.get(i));
            }
        }
        result.add(queue.peek());
        return result;
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(2);
        l.add(3);
        l.add(1);
        l.add(5);
        l.add(7);
        l.add(1);
        l.add(2);
        l.add(5);
        l.add(4);
        l.add(3);
        System.out.println(solution(l, 3));


    }
}
