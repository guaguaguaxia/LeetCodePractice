package interview;

public class Rand10 {
    public int rand10() {
        while (true) {
            int a = rand7();
            int b = rand7();
            // rand 49
            int num = (a - 1) * 7 + b;
            if (num <= 40) {
                // 拒绝采样
                return num % 10 + 1;
            }
            // rand 9
            a = num - 40;
            b = rand7();
            // rand 63
            num = (a - 1) * 7 + b;
            if (num <= 60) {
                return num % 10 + 1;
            }
            // rand 3
            a = num - 60;
            b = rand7();
            // rand 21
            num = (a - 1) * 7 + b;
            if (num <= 20) {
                return num % 10 + 1;
            }
        }
    }

    public int rand7() {
        double d = Math.random();
        return (int) (d * 7);
    }
}
