package 牛客.剑指offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @ClassName JZ27_Solution
 * @Description 字符串的排列
 * @Author 张点
 * @Date 2020/8/27 15:52
 * @Version 1.0
 **/
public class JZ27_Solution {

    public ArrayList<String> Permutation(String str) {
        if (str == null) return null;
        ArrayList<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return res;
    }

    private void PermutationHelper(char[] chars, int i, ArrayList<String> res) {
        if (i == chars.length - 1) {
            String s = String.valueOf(chars);
            if (!res.contains(s)) {
                res.add(s);
            }
        } else {
            for (int j = i; j < chars.length; j++) {
                swap(chars, i, j);
                PermutationHelper(chars, i + 1, res);
                swap(chars, i, j);//复位，回退到上一个状态
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
