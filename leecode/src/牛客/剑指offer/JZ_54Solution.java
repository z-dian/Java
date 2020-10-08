package 牛客.剑指offer;

import java.util.HashMap;

/**
 * @description 字符流中第一个不重复的字符
 * @author 张点
 * @date 2020/9/30 16:05
 **/
public class JZ_54Solution {
    //Map<Character,Integer> map = new LinkedHashMap<>();
    HashMap<Character,Integer> map = new HashMap<>();
    StringBuffer s = new StringBuffer();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        s.append(ch);
        if(map.containsKey(ch)){
            map.put(ch,map.get(ch)+1);
        }else {
            map.put(ch,1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {

        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i))==1){
                return s.charAt(i);
            }
        }
        return '#';
    }
}
