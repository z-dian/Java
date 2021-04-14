package 华为机试;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description: 质数因子
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * 最后一个数后面也要有空格
 * Created by zhang on 2021/3/18 11:03
 */
public class HJ6 {
    /*public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            long num = in.nextLong();
            StringBuilder s = new StringBuilder();
            while (num != 1) {
                for (int i = 2; i <= num; i++) {
                    if (num % i == 0) {
                        s.append(i).append(" ");
                        num = num / i;
                        break;
                    }
                }
            }
            System.out.println(s.toString());
        }
    }*/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str ;
        while ((str = br.readLine()) != null) {
            int num = Integer.parseInt(str);
            StringBuffer sb = new StringBuffer();
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    sb.append(i).append(" ");
                    num = num / i;
                    i--;
                }
            }
            sb.append(num).append(" ");
            System.out.println(sb.toString());
        }
    }

}
