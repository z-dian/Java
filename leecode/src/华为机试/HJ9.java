package 华为机试;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Description: 提取不重复的整数
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是0。
 * Created by zhang on 2021/3/22 9:31
 */
public class HJ9 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = bf.readLine()) != null) {
            char[] arr = input.toCharArray();
            int len = arr.length;
            Set<Character> set = new LinkedHashSet<>();
            for (int i = len - 1; i >= 0; i--) {
                if (!set.contains(arr[i])) {
                    set.add(arr[i]);
                } else {
                    continue;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (Character character : set) {
                sb.append(character);
            }
            System.out.println(sb.toString());
        }
    }
}
