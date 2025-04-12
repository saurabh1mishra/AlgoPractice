package arrays;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        Arrays.stream(nums).forEach(i -> map.put(i, map.getOrDefault(i, 0) + 1));

        List<Integer> list = Arrays.stream(nums).boxed().sorted((x, y) -> !Objects.equals(map.get(x), map.get(y)) ? map.get(y) - map.get(x) : x - y).collect(Collectors.toList());

        LinkedHashSet<Integer> set = new LinkedHashSet<>(list);

        return set.stream().limit(k).mapToInt(i ->i).toArray();

    }
}
