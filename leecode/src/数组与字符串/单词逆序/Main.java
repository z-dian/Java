package 数组与字符串.单词逆序;

import java.util.Scanner;

/*
题目：
对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
给定一个原字符串A，请返回逆序后的字符串。例，输入"I am a boy!", 输出"boy! a am I"

思路：用split（）分割字符串，并存入字符串数组集合中，最后将字符串数组集合倒叙输出
逆序输出。
 */
public class Main {

    /*public void reverse(String str) {
        String[] src = str.split(" ");

        int length = src.length;

        ArrayList<String> list = new ArrayList<>();
        for (int i = length - 1; i >= 0; i--) {
            list.add(src[i]);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
*/
    public String ReverseSentence(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] s = str.split(" ");
        int len = s.length;
        for(int i = len-1;i>=0;i--){
            stringBuffer.append(s[i]);
        }
        String res = stringBuffer.toString();
        return res;

    }
    public static void main(String[] args) {
        Main v = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(v.ReverseSentence(str));
    }

}
