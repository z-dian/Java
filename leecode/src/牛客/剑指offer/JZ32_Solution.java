package 牛客.剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @ClassName JZ32_Solution
 * @Description 把数组排成最小的数
 * @Author 张点
 * @Date 2020/9/2 8:49
 * @Version 1.0
 **/
public class JZ32_Solution {
    public String PrintMinNumber(int[] numbers) {
        String s = "";
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<numbers.length;i++){
            list.add(numbers[i]);
        }

        Collections.sort(list,new Comparator<Integer>(){
            public int compare(Integer str1, Integer str2){
                String s1 = str1+""+str2;
                String s2 = str2+""+str1;
                return s1.compareTo(s2);
            }
        });

        for(int j :list){
            s+=j;
        }
        return s;
    }
}
