package 面试算法练习.练习;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description: 会议室253
 * Created by zhang on 2021/1/23 14:16
 */
public class meeting2 {
    public static int minMeetingRooms(int[][] arr) {
        //判空
        if (arr.length == 0) {
            return 0;
        }
        //定义一个优先队列，最小堆，存放每个会议时间的结束时间，堆顶元素为结束时间最早的会议
        PriorityQueue<Integer> q = new PriorityQueue<>();
        //对每个会议按照开始时间大小进行排序
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        //存放第一个会议的结束时间
        q.offer(arr[0][1]);
        //开始遍历所有会议
        for (int i = 1; i < arr.length; i++) {
            //若当前会议开始时间大于堆顶元素，说明当前会议开始时间晚于当前要结束的会议，不会冲突，等堆顶会议结束后直接用
            if (arr[i][0] >= q.peek()) {
                q.poll();
            }
            //否则，另开一间会议室
            q.offer(arr[i][1]);

        }
        //堆的大小就是当前可用最少的会议室数目
        return q.size();
    }

    public static void main(String[] args) {
        int[][] arr = {{10, 30}, {5, 10}};
        System.out.println(minMeetingRooms(arr));
    }
}
