package 牛客.剑指offer;

import java.util.HashMap;

/**
 * @ClassName JZ28_Solution
 * @Description 数组中出现次数超过一半的数字
 * @Author 张点
 * @Date 2020/8/30 13:05
 * @Version 1.0
 **/
public class JZ28_Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0;i<array.length;i++) {
           if(map.containsKey(array[i])){
               map.put(array[i],map.get(array[i])+1);
           }else {
               map.put(array[i],1);
           }
        }
        int len = array.length / 2;
        for (int value : array) {
            if (map.get(value) > len) {
                return value;
            }
        }
        return 0;
    }
}
