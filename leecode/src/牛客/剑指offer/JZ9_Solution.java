package 牛客.剑指offer;

/**
 * @ClassName JZ9_Solution
 * @Description 变态跳台阶
 * @Author 张点
 * @Date 2020/8/11 14:00
 * @Version 1.0
 **/
public class JZ9_Solution {
    public int JumpFloorII(int target) {
        if(target<2)return target;
        else{
            return 2*JumpFloorII(--target);
        }
    }
}
