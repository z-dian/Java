package 面试算法练习.练习;

/**
 * Description: leecode
 * Created by zhang on 2021/1/23 14:03
 */
public class bitnum_add {
    public static String add(String s1, String s2) {
        StringBuffer str1 = new StringBuffer(s1).reverse();
        StringBuffer str2 = new StringBuffer(s2).reverse();
        int l1 = str1.length();
        int l2 = str2.length();
        int maxlen = Math.max(l1, l2);
        if (l1 < l2) {
            for (int i = l1; i < l2; i++) {
                str1.append("0");
            }
        } else {
            for (int i = l2; i < l1; i++) {
                str2.append("0");
            }
        }
        StringBuffer res = new StringBuffer();
        int c = 0;
        for (int i = 0; i < maxlen; i++) {
            int curSum = Integer.parseInt(String.valueOf(str1.charAt(i))) + Integer.parseInt(String.valueOf(str2.charAt(i))) + c;
            int mod = curSum % 10;
            res.append(mod);
            c = curSum / 10;
        }
        if (c > 0) {
            res.append(c);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 ="1242657234132523";
        String s2 ="2657234132523";
        System.out.println(add(s1,s2));

    }
}
