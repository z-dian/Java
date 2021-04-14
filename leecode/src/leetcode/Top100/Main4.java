package leetcode.Top100;

/**
 * Description: 寻找两个正序数组的中位数
 * Created by zhang on 2021/2/27 14:34
 */
public class Main4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int a[] = new int[m+n];
        if(m==0){
            if(n%2==0){
                return (nums2[n/2-1]+nums2[n/2])/2.0;
            }else{
                return nums2[n/2];
            }
        }
        if(n==0){
            if(m%2==0){
                return (nums1[m/2-1]+nums1[m/2])/2.0;
            }else{
                return nums1[m/2];
            }
        }
        int i = 0,j=0,k=0;
        while(k!=(m+n)){
            if(nums1[i]<=nums2[j]){
                a[k++] = nums1[i++];
            }else{
                a[k++] = nums2[j++];
            }
            if(i==m){
                while(j!=n){
                    a[k++]=nums2[j++];
                }
                break;
            }
            if(j==n){
                while(i!=m){
                    a[k++] = nums1[i++];
                }
                break;
            }
        }
        if(k%2==0){
            return (a[k/2-1]+a[k/2])/2.0;
        }else{
            return a[k/2];
        }
    }
}
