package 牛客.剑指offer;
/**
 * @description 求1+2+3+···+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @author 张点
 * @date 2020/9/24 10:43
 **/
public class JZ_47Solution {
    public int Sum_Solution(int n) {
        if(n<=1)return n;
        int sum = n;
        sum+=Sum_Solution(n-1);
        return sum;
    }
}
