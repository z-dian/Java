package 牛客.剑指offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName JZ29_Solution
 * @Description 最小的k个数
 * @Author 张点
 * @Date 2020/8/31 9:24
 * @Version 1.0
 **/
public class JZ29_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input.length == 0) return res;
        Arrays.sort(input);
        if(k>input.length){
            return res;
        }else {
            for (int i = 0; i < k; i++) {
                res.add(input[i]);
            }
        }

        return res;
    }
}
