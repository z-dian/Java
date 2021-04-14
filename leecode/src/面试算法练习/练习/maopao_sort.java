package 面试算法练习.练习;

/**
 * Description: leecode
 * Created by zhang on 2021/1/20 18:11
 */
public class maopao_sort {
    public static void  sort (int[] arr){
        for(int i = 0;i<arr.length-1;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums={4,2,6,3,7,8,1};
        sort(nums);
        for(int i = 0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
