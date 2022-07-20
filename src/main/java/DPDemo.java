import java.util.Arrays;

/**
 * [1,3,2,5,8]
 *
 *
 * target = 10
 *
 *
 * output: {1,3}
 */
public class DPDemo {

    public static int[] solution(int[] input, int target){

        int[] result = new int[2];
        //N^2
        for(int i = 0; i < input.length; i++){
            int sum = input[i];
            if(sum == target){
                return new int[]{i, i};
            }
            for(int j = i+1; j<input.length-1; j++){
                sum += input[j];
                if (sum == target) {
                    return new int[]{i, j};
                }
                if (sum > target ) {
                    break;
                }
            }
        }

       return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,3,2,5,8,2};
        int target = 10;
        int[] result = solution(input, target);
        System.out.println(Arrays.toString(result));
    }

}
