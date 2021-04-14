package 华为机试;

import java.io.IOException;
import java.io.InputStream;

/**
 * Description: 计算字符串最后一个单词的长度，单词以空格隔开。
 * Created by zhang on 2021/3/16 11:16
 */
public class HJ1 {
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        int length = 0;
        char c = (char) is.read();
        while (c!='\n'){
            if(c==' '){
                length = 0;
            }else {
                length++;
            }
            c= (char) is.read();
        }
        System.out.println(length);
    }
}
