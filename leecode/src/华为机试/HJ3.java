package 华为机试;

import java.util.*;

/**
 * Description: 明明的随机数
 * Created by zhang on 2021/3/17 9:18
 */
public class HJ3 {
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = in.nextInt();
            }
            Arrays.QuickSort(arr);
            for(int i = 0;i<arr.length;i++){
                if(i==0||arr[i]!=arr[i-1]){
                    System.out.println(arr[i]);
                }
            }
        }*/
        //方法二：
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int[] home = new int[1001];
            Arrays.fill(home, 0);
            int num = in.nextInt();
            for (int i = 0; i < num; i++) {
                int n = in.nextInt();
                home[n] = 1;
            }
            for (int i = 0; i < 1000; i++) {
                if (home[i] == 1) {
                    System.out.println(i);
                }
            }
        }
    }
}
