package 牛客.剑指offer;

import java.util.HashMap;

/**
 * @author 张点
 * @description 数组中重复的数字
 * @date 2020/9/26 10:40
 **/
public class JZ_50Solution {

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (length==0||numbers==null||length==1) {
            duplication[0] = -1;
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
        }
        for (int num : map.keySet()) {
            if (map.get(num) != 1) {
                duplication[0] = num;
                return true;
            }
        }
        return false;
    }
}
