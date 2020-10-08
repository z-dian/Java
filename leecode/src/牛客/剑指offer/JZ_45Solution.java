package 牛客.剑指offer;

import java.util.Arrays;

/**
 * @description 扑克牌顺子
 *              1、排序
 *              2、计算所有相邻数字间的间隔总数
 *              3、计算0的个数
 *              4、如果2、3相等就是顺子
 *              5、如果出现对子就不是顺子
 * @author 张点
 * @date 2020/9/23 16:35
 **/
public class JZ_45Solution {
    public boolean isContinuous(int [] numbers) {
        if(numbers.length!=5)return false;
        int numOfZero = 0;
        int numOfInterval = 0;
        Arrays.sort(numbers);
        for(int i = 0;i<numbers.length-1;i++){
            if(numbers[i]==0){
                numOfZero++;
                continue;
            }
            //出现对子，直接返回false
            if(numbers[i]==numbers[i+1]){
                return false;
            }
            //计算相邻两个数字的间隔总数
            numOfInterval+=numbers[i+1]-numbers[i]-1;
        }
        if(numOfZero>=numOfInterval){
            return true;
        }
        return false;
    }
}
