package 牛客.剑指offer;

/**
 * @ClassName JZ13_Solution
 * @Description 调整数组顺序使奇数位于偶数前面
 * @Author 张点
 * @Date 2020/8/14 21:30
 * @Version 1.0
 **/
public class JZ13_Solution {
    public static void reOrderArray(int[] array) {

        if(array==null||array.length==0)return;

        int[] odd = new int[array.length];
        int[] even = new int[array.length];
        int odd_num = 0;
        int even_num = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                even[even_num++] = array[i];
            } else {
                odd[odd_num++] = array[i];
            }
        }
        for(int i = 0 ;i<array.length;i++){
            array[i]=odd[i];
        }
        int j = 0;
        for(int i = odd_num;i<array.length;i++){

            array[i]=even[j++];

        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        reOrderArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
