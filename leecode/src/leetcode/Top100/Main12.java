package leetcode.Top100;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 整数转罗马数字
 * Created by zhang on 2021/3/5 10:09
 */
public class Main12 {
    //方法1：此题类似与硬币贪心法,先列出所有可以表示的数字
    /*public String intToRoman(int num) {
        int[] nums ={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index<13){
            while (num>=nums[index]){
                num-=nums[index];
                stringBuilder.append(romans[index]);
            }
            index++;
        }
        return stringBuilder.toString();
    }*/
    //方法2：，此题给的范围是1-3999列出每位所有可能的数字
    public String intToRoman(int num) {
        String[] one =          {"","I","II","III","IV","V","VI","VII","VIII","IX"};//个位
        String[] ten =          {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};//十位
        String[] hundred =      {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};//百位
        String[] kilometer =    {"","M","MM","MMM"};//千位
        return kilometer[num/1000]+hundred[num%1000/100]+ten[num%100/10]+one[num%10];
    }
    public static void main(String[] args) {
        System.out.println(new Main12().intToRoman(1994));//MMDCCCXLIX
    }
}
