package 字符串转换整数;

public class Solution {
    public static void main(String[] args) {
        String s = "  -113689831231412asd ";
        int num = new Solution().myAtoi(s);
        System.out.println(num);
    }

    public int myAtoi(String str) {
        //字符串为空时
        if (str == null) {
            return 0;
        }
        //利用trim()，返回字符串的副本，忽略前导空白和尾部空白。
        String s = str.trim();
        //字符串只有空格字符时
        if (s.length() == 0) {
            return 0;
        }
        int i = 0;
        int flag = 1;//定一个flag，确定正负号
        char ch = s.charAt(i);
        if (ch == '+') {
            i++;
        } else if (ch == '-') {
            flag = -1;
            i++;
        }
        int res = 0;
        for (; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch < '0' || ch > '9') {
                break;
            }
            if (flag > 0 && res > Integer.MAX_VALUE / 10) {
                return Integer.MAX_VALUE;
            }
            if (flag > 0 && res == Integer.MAX_VALUE / 10 && ch - '0' > Integer.MAX_VALUE % 10) {
                return Integer.MAX_VALUE;
            }
            if (flag < 0 && -res < Integer.MIN_VALUE / 10)
                return Integer.MIN_VALUE;
            if (flag < 0 && -res == Integer.MIN_VALUE / 10 && -(ch - '0') < Integer.MIN_VALUE % 10)
                return Integer.MIN_VALUE;
            res = res * 10 + ch - '0';
        }
        return flag * res;
    }
}
