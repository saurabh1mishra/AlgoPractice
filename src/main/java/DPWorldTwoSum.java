import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * [1,3,2,5,8]
 * <p>
 * <p>
 * target = 10
 * <p>
 * <p>
 * output: {1,3}
 */
public class DPWorldTwoSum {

    public static int[] solution(int[] input, int target) {

        int[] result = new int[2];
        //N^2
        for (int i = 0; i < input.length; i++) {
            int sum = input[i];
            if (sum == target) {
                return new int[]{i, i};
            }
            for (int j = i + 1; j < input.length - 1; j++) {
                sum += input[j];
                if (sum == target) {
                    return new int[]{i, j};
                }
                if (sum > target) {
                    break;
                }
            }
        }

        return result;
    }

    public static int[] solution2(int[] input, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < input.length; i++) {

            int targetNum = target - input[i];
            if (indexMap.containsKey(targetNum)) {
                result[0] = i;
                result[1] = indexMap.get(targetNum);
                break;
            }
            indexMap.put(input[i], i);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 2, 5, 8, 2};
        int target = 10;
        int[] result = solution2(input, target);
        System.out.println(Arrays.toString(result));
    }

}
