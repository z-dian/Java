package 牛客.剑指offer;

/**
 * @author 张点
 * @description 左旋转字符串
 * @date 2020/9/14 12:43
 **/
public class JZ_43Solution {
    public String LeftRotateString(String str, int n) {
        if (str.length() < n) return str;
        return str.substring(n, str.length()) + str.substring(0, n);
    }
}
