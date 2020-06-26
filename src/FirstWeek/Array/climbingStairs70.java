package FirstWeek.Array;


/*
* 2020-06-23 First Pass
* 2020-06-24 Second Pa ss
* */
public class climbingStairs70 {
    public static void main(String[] args) {
        int ret = climbStairs(7);
        System.out.println(ret);
    }

    /** 斐波那契数列
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
