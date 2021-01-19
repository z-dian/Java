package leetcode.剑指offer;
/**
 * @description 替换空格
 * @author 张点
 * @date 2020/10/11 13:59
 **/
public class JZ05_Solution {
    public String replaceSpace(String s) {
        if(s.length()==0){
            return "";
        }
        StringBuffer s1 = new StringBuffer();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==' '){
                s1.append('%').append('2').append('0');
            }else {
                s1.append(s.charAt(i));
            }
        }
        return s1.toString();
    }
}
