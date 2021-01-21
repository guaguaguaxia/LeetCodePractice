package newcodetop200.part1;

public class AddStrings {

    public static void main(String[] args) {
        String s = "51189";
        String s1 = "967895";
        String s2 = addStrings(s, s1);
        System.out.println(s2);
    }


    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }
        return res.reverse().toString();
    }


}
