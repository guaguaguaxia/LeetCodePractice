package Additional;

public class CoinChange322 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 30;
        int i = coinChange(coins, amount);
        System.out.println(i);
    }


    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp.length;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        System.out.println(111);
        return dp[amount] == dp.length ? -1 : dp[amount];
    }

//    public static int coinChange(int[] coins, int amount) {
//        if (amount < 1) {
//            return 0;
//        }
//        return coinChange(coins, amount, new int[amount]);
//    }
//
//    private static int coinChange(int[] coins, int rem, int[] count) {
//        if (rem < 0) {
//            return -1;
//        }
//        if (rem == 0) {
//            return 0;
//        }
//        if (count[rem - 1] != 0) {
//            return count[rem - 1];
//        }
//        int min = Integer.MAX_VALUE;
//        for (int coin : coins) {
//            int res = coinChange(coins, rem - coin, count);
//            if (res >= 0 && res < min) {
//                min = 1 + res;
//            }
//        }
//        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
//        return count[rem - 1];
//    }

}
