package leetcode.Top100;

/**
 * Description: 盛最多水的容器
 * Created by zhang on 2021/3/4 10:32
 */
public class Main11 {
    //双指针法
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int maxVolume = 0;
        while (i<j){
            maxVolume = height[i]<height[j]?
                    Math.max(maxVolume,(j-i)*height[i++]):
                    Math.max(maxVolume,(j-i)*height[j--]);
        }
        return maxVolume;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Main11().maxArea(height));
    }
}
