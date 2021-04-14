package 华为机试;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Description: 计算某字符出现的次数
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，然后输出输入字符串中该字母的出现次数。不区分大小写。
 * Created by zhang on 2021/3/16 11:48
 */
public class HJ2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] chars1 = bf.readLine().toLowerCase().toCharArray();
        char[] chars2 = bf.readLine().toLowerCase().toCharArray();
        int count = 0;
        for(int i = 0 ;i<chars1.length;i++){
            if(chars1[i] == chars2[0]){
                count++;
            }
        }
        System.out.println(count);
    }
}
