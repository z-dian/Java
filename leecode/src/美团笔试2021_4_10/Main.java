package 美团笔试2021_4_10;

import java.util.Scanner;
import java.util.Stack;

/**
 * Description:
 * Created by zhang on 2021/4/10 20:19
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        int res = getMaxLen(str);
        System.out.println(res);
    }

    public static int getMaxLen(String str){
        while (str.contains("111")||str.contains("011")||str.contains("101")||str.contains("110")){
            if(str.contains("111")){
                str = str.replace("111","");
            }else if(str.contains("011")){
                str=str.replace("011","");
            }else if(str.contains("101")){
                str=str.replace("101","");
            }else if(str.contains("110")){
                str=str.replace("110","");
            }
        }
        int cnt = 0;
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)=='0'){
                cnt++;
            }else if(str.charAt(i)=='1'){
                cnt--;
            }
        }
        return cnt;
    }

    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int i = 0;
        while (i < n && a[i] != 0) {
            i++;
        }
        int res1 = 0, res2 = 0;
        for (int j = i - 1; j > 0; j--) {
            if (a[j] <= k) {
                res1 = j + 1;
            }
        }
        for (int j = i + 1; j < a.length; j++) {
            if (a[j] <= k) {
                res2 = j-1;
            }
        }
        System.out.println(Math.min(res1, res2));
    }*/
}

