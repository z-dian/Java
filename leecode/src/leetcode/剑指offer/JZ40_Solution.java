package leetcode.剑指offer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 张点
 * @description 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * @date 2020/11/19 10:14
 **/
public class JZ40_Solution {
    //直接sort
    /*public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }*/
    //大根堆实现
    /*public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        //默认是小根堆，实现大根堆要实现一下比较器
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        int[] res = new int[pq.size()];
        int index = 0;
        for (int num : pq) {
            res[index++] = num;
        }
        return res;
    }*/
    //大牛解法
    private int[] list;
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length==0||k==0){
            return new int[0];
        }

        list=arr;
        dfs(0,arr.length-1, k);
        int[] res = new int[k];
        System.arraycopy(list,0,res,0,k);
        return res;
    }
    private void dfs(int start, int end, int k){
        int pirod=list[end];
        int j = start;
        for(int i=start;i<end;i++){
            if(list[i]<pirod){
                swap(i,j);
                j++;
            }
        }
        swap(j,end);
        if(j>k-1){
            // System.out.println(j+","+k);
            dfs(start,j-1,k);
        }else if(j<k-1){
            dfs(j+1,end,k);
        }else{
            return;
        }


    }
    private void swap(int i, int j){
        int tmp = list[i];
        list[i]=list[j];
        list[j]=tmp;
    }
}
