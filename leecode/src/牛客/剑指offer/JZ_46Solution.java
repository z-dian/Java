package 牛客.剑指offer;

import java.util.LinkedList;

/**
 * @description 孩子们的游戏（圆圈中最后剩下的数）
 * @author 张点
 * @date 2020/9/24 9:34
 **/
public class JZ_46Solution {
    //约瑟夫环问题的改编，模拟环形链表，每次从链表中删除第m-1个元素即可
    public int LastRemaining_Solution(int n, int m) {
        if(n<1||m<1)return -1;
        //index为当前索引
        int index = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0;i<n;i++){
            linkedList.add(i);
        }
        int size=linkedList.size();
        while (size>1){
            linkedList.remove((index+m-1)%size);
            index=(index+m-1)%size;
            size--;
        }
        return linkedList.get(0);
    }
}
