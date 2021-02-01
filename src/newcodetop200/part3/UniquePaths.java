package newcodetop200.part3;

import java.util.Arrays;
/*
*
* 1--1--1--1--1--1--1--
  1--2--3--4--5--6--7--
  1--3--6--10--15--21--28--
* */
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
                System.out.println(cur[j] + "---" + cur[j-1]);
                cur[j] = cur[j] + cur[j-1] ;
                System.out.println(cur[j] + "+++");
            }
            System.out.println(Arrays.toString(cur));
            System.out.println("------");
        }
        return cur[n-1];
    }

}
