package arrays;

/**
 * https://medium.com/theleanprogrammer/best-time-to-buy-and-sell-stock-c4ff30e56e4e
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */

public class BestTimetoBuySellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int min = prices[0]; // min so far
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            result = Math.max(result, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return result;
    }
}
