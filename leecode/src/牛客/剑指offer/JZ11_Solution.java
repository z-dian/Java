package 牛客.剑指offer;

/**
 * @ClassName JZ11_Solution
 * @Description 二进制数中1的个数
 * @Author 张点
 * @Date 2020/8/11 14:40
 * @Version 1.0
 **/
public class JZ11_Solution {

    /*public int NumberOf1(int n) {
        int count = 0;
        char[] chars = Integer.toBinaryString(n).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='1'){
                count++;
            }
        }
        return count;
    }*/
    public int NumberOf1(int n){
        int cnt = 0;
        int flag = 1;
        while (flag!=0){
            if((n&flag)!=0){
                cnt++;
            }
            flag=flag<<1;
        }
        return cnt;
    }

}
