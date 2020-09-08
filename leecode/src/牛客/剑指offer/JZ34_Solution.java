package 牛客.剑指offer;

/**
 * @ClassName JZ34_Solution
 * @Description 第一次只出现一次的字符
 * @Author 张点
 * @Date 2020/9/5 9:47
 * @Version 1.0
 **/
public class JZ34_Solution {

    public int FirstNotRepeatingChar(String str) {
        if(str==null||str.length()==0){
            return -1;
        }
        int[] index = new int[128];
        for(int i = 0;i<str.length();i++){
            index[str.charAt(i)]+=1;
        }
        for(int i = 0;i<str.length();i++){
            if(index[str.charAt(i)]==1){
                return i;
            }
        }
        return -1;
    }
}
