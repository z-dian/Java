package 华为机试;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Description: 合并表记录
 * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key
 * 值升序进行输出。
 * 输入描述: 先输入键值对的个数，然后输入成对的index和value值，以空格隔开
 * 输出描述: 输出合并后的键值对（多行）
 * Created by zhang on 2021/3/19 10:48
 */
public class HJ8 {
    public static void main(String[] args) throws IOException {
        /*Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new TreeMap<>();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int key = sc.nextInt();
                int value = sc.nextInt();
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + value);
                } else {
                    map.put(key, value);
                }
            }
        }
        for (Integer res : map.keySet()) {
            System.out.println(res + " " + map.get(res));
        }*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int num = Integer.parseInt(str);
            int[] values = new int[num];
            // 读取num行数据，并处理
            for (int i = 0; i < num; i++) {
                str = br.readLine();
                int pos = str.indexOf(" ");
                int n1 = Integer.parseInt(str.substring(0, pos));
                int n2 = Integer.parseInt(str.substring(pos + 1));
                values[n1] += n2;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < num; i++) {
                if (values[i] != 0) {
                    sb.append(i).append(" ").append(values[i]).append('\n');
                }
            }
            System.out.println(sb.toString());
        }
    }
}
