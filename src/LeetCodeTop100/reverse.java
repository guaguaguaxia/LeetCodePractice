package LeetCodeTop100;

public class reverse {

    public static void main(String[] args) {
        int x = 2147483647;
        System.out.println(x);
    }

    public int reverse(int x) {
        int res = 0;
        int last = 0;
        while(x!=0) {
            //每次取末尾数字
            int tmp = x%10;
            last = res;
            res = res*10 + tmp;
            //判断整数溢出
            if(last != res/10)
            {
                return 0;
            }
            x /= 10;
        }
        return res;
    }
}
