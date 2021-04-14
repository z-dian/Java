package 华为机试;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Description: 取近似值
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 * 输入描述: 输入一个正浮点数值
 * 输出描述: 输出该数值的近似整数值
 * 示例1：
 * 输入：5.5    输出：6
 * Created by zhang on 2021/3/19 10:31
 */
public class HJ7 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int index = str.indexOf('.');
        int a = Integer.parseInt(str.substring(0,index));
        int b = Integer.parseInt(str.substring(index+1,index+2));
        if(b>=5){
            System.out.println(a+1);
        }else {
            System.out.println(a);
        }
    }
}
