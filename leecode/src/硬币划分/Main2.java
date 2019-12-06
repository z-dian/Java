package 硬币划分;

import java.util.Scanner;

public class Main2 {
    static int countnum = 0;

    public static void main(String[] args) {

        count();

    }

    static void count() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int a = 0; a <= n; a++) {
            for (int b = 0; b <= n / 2; b++) {
                for (int c = 0; c <= n / 5; c++) {
                    for (int d = 0; d <= n / 10; d++)
                        if (a + 2 * b + c * 5 + d * 10 == n) {
                            countnum++;
                        }
                }
            }
        }

        System.out.println(countnum);

    }
}
