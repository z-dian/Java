package 华为机试;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Description: 进制转换
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 * Created by zhang on 2021/3/18 9:26
 */
public class HJ5 {
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            String s = str.substring(2);
            int len = s.length();
            int res = 0;
            for (int i = 0; i <len; i++) {

                if (s.charAt(i) == 'A') {
                    res += 10 * Math.pow(16, len-i-1);
                } else if (s.charAt(i) == 'B') {
                    res += 11 * Math.pow(16, len-i-1);
                } else if (s.charAt(i) == 'C') {
                    res += 12 * Math.pow(16, len-i-1);
                } else if (s.charAt(i) == 'D') {
                    res += 13 * Math.pow(16, len-i-1);
                } else if (s.charAt(i) == 'E') {
                    res += 14 * Math.pow(16, len-i-1);
                } else if (s.charAt(i) == 'F') {
                    res += 15 * Math.pow(16, len-i-1);
                } else {
                    res += (s.charAt(i)-'0')*Math.pow(16,len-i-1);
                }

            }
            System.out.println(res);
        }
    }*/
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = bf.readLine()) != null) {
            String s = input.substring(2);
            int len = s.length();
            int res = 0;
            for (int i = len - 1; i >= 0; i--) {
                int curNum = s.charAt(i);
                if (curNum >= 65) {
                    curNum = curNum - 65 + 10;//65是字符A的ASCII码
                } else {
                    curNum -= 48;//48是字符0的ASCII码
                }
                res += curNum * Math.pow(16, len - i - 1);
            }
            System.out.println(res);
        }
    }
}
