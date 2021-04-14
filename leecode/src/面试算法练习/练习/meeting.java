package 面试算法练习.练习;

import java.util.Arrays;

/**
 * Description: leecode
 * Created by zhang on 2021/1/22 19:42
 */
public class meeting {
    public static void main(String[] args) {
        int[][] intervals = {{7,10},{2,4},{11,20}};
        boolean res = meeting(intervals);
        System.out.println(res);
    }
    public static boolean meeting(int[][] intervals){
        Arrays.sort(intervals,(a1,a2)->a1[0]-a2[0]);
        for(int i = 0;i<intervals.length-1;i++){
            if(intervals[i][1]>intervals[i+1][0]){
                return false;
            }
        }
        return true;
    }
}
