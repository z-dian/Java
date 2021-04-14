package leetcode周赛.牛牛打怪;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int n = 5;
        int[] DEF = {4,5,5,6,6,7};
        System.out.println(Minimumdays(n, DEF));
    }

   /* public static int Minimumdays(int n, int[] DEF) {
        // write code here
        Arrays.QuickSort(DEF);
        int day = 0;
        for(int i = 0;i<n;i++){
            //如果防御值大于天数day的话就让天数day=防御值,也就是说第i天才可以杀死这个怪
            if(DEF[i]>day){
                day = DEF[i];
            }else {
                //否则的话，让天数加1 此时，天数大于防御值，每天杀死一只怪
                day++;
            }
        }
        return day;
    }*/
   public static int Minimumdays(int n, int[] DEF) {
       // write code here
       Arrays.sort(DEF);
       int day = DEF[0];
       for(int i = 1;i<n;i++){
          day = Math.max(DEF[i],day+1);
       }
       return day;
   }


}
