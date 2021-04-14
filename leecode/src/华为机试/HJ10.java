package 华为机试;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Description: 字符个数统计
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。
 * 不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。
 * Created by zhang on 2021/3/22 10:06
 */
public class HJ10 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int[] is = new int[128];
        int count = 0;
        for(int i = 0;i< s.length();i++){
            char b = s.charAt(i);
            if(is[b]==0){
                count++;
                is[b]=1;
            }
        }
        System.out.println(count);
    }
}
