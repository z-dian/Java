package 牛客.剑指offer;

/**
 * @ClassName JZ33_Solution
 * @Description 丑数
 * @Author 张点
 * @Date 2020/9/4 14:13
 * @Version 1.0
 **/
public class JZ33_Solution {
    public static int GetUglyNumber_Solution(int index) {
        if (index < 7) {
            return index;
        }
        //p2,p3,p5分别是三个队列的指针，arr[0]为最小的丑数
        int p2 = 0, p3 = 0, p5 = 0;
        int[] arr = new int[index];
        arr[0] = 1;
        for (int i = 1; i < index; i++) {
            //选出三个队列头最小的数
            arr[i] = min(min(arr[p2] * 2, arr[p3] * 3), arr[p5] * 5);
            //这三个if有可能进入一个或者多个，进入多个是三个队列头最小的数有多个的情况
            if (arr[i] == arr[p2] * 2) p2++;
            if (arr[i] == arr[p3] * 3) p3++;
            if (arr[i] == arr[p5] * 5) p5++;
        }
        return arr[index - 1];
    }

    public static int min(int a, int b) {
        return Math.min(a, b);
    }


    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(7));
    }
}
