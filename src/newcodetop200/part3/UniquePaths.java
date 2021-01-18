package newcodetop200.part3;

import java.util.Arrays;

public class UniquePaths {

    public static void main(String[] args) {
        int i = uniquePaths(3, 7);
        System.out.println(i);
    }

    public static int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] = cur[j] + cur[j-1] ;
            }
        }
        return cur[n-1];
    }

}
