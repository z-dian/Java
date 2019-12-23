package 硬币划分;

import java.util.Scanner;

/*
问题描述：
有1分，2分，5分，10分四种硬币，每种硬币数量无限，给定n分钱(n <= 100000)，有多少中组合可以组成n分钱？
输入描述:13
输入整数n.(1<=n<=100000)

输出描述:16
输出组合数，答案对1e9+7取模。
 */
public class Main {
    static int numcount = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int coins[] = {1, 2, 5, 10};

        count(coins, 0, n);

        System.out.println(numcount%(1e9+7));
    }

    public static void count(int coins[], int index, int n) {
        if (n == 0) {
            numcount++;
            return;
        }
        if (index == 4) {
            return;
        }
        for (int i = 0; i * coins[index] <= n; i++) {
            count(coins, index + 1, n - i * coins[index]);
        }
    }
}
