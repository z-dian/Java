package 华为机试;

import java.util.Scanner;

/**
 * Description: 字符串分隔
 * 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * Created by zhang on 2021/3/17 10:11
 */
public class HJ4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            StringBuilder s = new StringBuilder(sc.nextLine());
            if (s.length() < 8) {
                for (int i = s.length() - 1; i < 8; i++) {
                    s.append("0");
                }
                System.out.println(s.toString());
            } else {
                while (s.length() > 8) {
                    System.out.println(s.substring(0, 8));
                    s.delete(0, 8);
                }
                for (int i = s.length() - 1; i < 8; i++) {
                    s.append("0");
                }
                System.out.println(s.toString());
            }
        }
    }
}
