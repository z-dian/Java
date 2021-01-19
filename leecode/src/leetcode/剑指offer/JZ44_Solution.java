package leetcode.剑指offer;

/**
 * @author 张点
 * @description 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位
 * （从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * @date 2020/11/23 9:37
 **/
public class JZ44_Solution {
    public int findNthDigit(int n) {
        int digit = 1;//数位（个位/十位/百位/...，就是1/2/3/...）
        long start = 1; // 属于该数位的所有数的起始点数（个位是1，十位是10，百位是100）
        long cnt = 9;// 该数位的数一共的索引个数（不是数字个数）

        while (n > cnt) {
            //1.确定数字的数位，也就是数字所在数字是几位数
            n -= cnt;
            digit += 1;
            start *= 10;
            cnt = digit * 9 * start;
        }

        long num = start + (n - 1) / digit;//2.确定n所在的是哪个数字num

        int remainder = (n - 1) % digit; //3.确定n在数字num的哪一位,余数就是 n 是这个数字中的第几位
        return Long.toString(num).charAt(remainder) - '0';
    }
}
