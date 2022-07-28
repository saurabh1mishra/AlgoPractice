package algo;

/**
 * https://www.youtube.com/watch?v=ZI17bgz07EE&t=6s
 * <p>
 * https://randomwits.com/blog/coin-change-leetcode-solution
 * <p>
 * https://leetcode.com/problems/coin-change/submissions/
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <p>
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 */
public class CoinChange {


    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int coinType = coins.length;
        int[] arr = new int[amount + 1];

        //setting base condition
        arr[0] = 0;

        // init
        for (int i = 1; i <= amount; i++) {
            arr[i] = amount + 1;
        }

        //
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++)
                if (coins[j] <= i) {
                    arr[i] = Math.min(arr[i - coins[j]] + 1, arr[i]);
                }
        }

        return (arr[amount] > amount) ? -1 : arr[amount];

    }
}
