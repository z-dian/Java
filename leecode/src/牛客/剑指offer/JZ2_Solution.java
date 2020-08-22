package 牛客.剑指offer;

/**
 * @ClassName JZ2_Solution
 * @Description 替换空格
 * @Author 张点
 * @Date 2020/8/6 11:40
 * @Version 1.0
 **/
public class JZ2_Solution {
    public String replaceSpace(StringBuffer str) {
        if(str==null)return null;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==' ') {
                stringBuffer.append("%20");
            }else {
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String s = "we are happy";
        StringBuffer str = new StringBuffer(s);
        String res = new JZ2_Solution().replaceSpace(str);
        System.out.println(res);
    }
}
