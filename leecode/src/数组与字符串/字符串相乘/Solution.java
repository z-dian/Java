package 数组与字符串.字符串相乘;

/*
题目描述：
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
示例 1:
输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:
输入: num1 = "123", num2 = "456"
输出: "56088"
说明：
num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Solution {
    public static void main(String[] args) {
        String num1 = "498828660196";
        String num2 = "840477629533";
        System.out.println("结果是：" + new Solution().multiply(num1, num2));
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) {
                continue;
            }
            result.append(res[i]);
        }
        return result.toString();
    }
  /*  public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0)
            return "0";
        long longnum1 = 0;
        //123
        for (int j = 0; j < num1.length(); j++) {
            int i = num1.length()-j-1;
            long mul = 1;
            while (i > 0) {
                mul *= 10;
                i--;
            }
            longnum1 += (num1.charAt(j)-'0') * mul;
        }
        long longnum2 = 0;
        for (int j = 0; j < num2.length(); j++) {
            int i = num2.length()-j-1;
            long mul = 1;
            while (i > 0) {
                mul *= 10;
                i--;
            }
            longnum2 += (num2.charAt(j)-'0') * mul;
        }

        String res = String.valueOf(longnum1 * longnum2);
        return res;
    }*/
}
