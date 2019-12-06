package API2.System;

import java.util.Arrays;

public class arrayCopy {
    public static void main(String[] args) {
        demo01();
    }
    /*
        public static void arraycopy(API2.Object src, int srcPos, API2.Object dest, int destPos, int length)：将数组中指定的数据拷贝到另一个数组中。
        参数：
            src - 源数组
            srcPos - 源数组中的起始位置（起始索引）
            dest - 目标数组
            destPos - 目标数组中的起始位置
            length - 要复制的数组元素的数量
        练习：将src数组中前3个元素，复制到dest数组的前3个位置上复制元素前：src数组元素[1,2,3,4,5]，
            dest数组元素[6,7,8,9,10]复制元素后：src数组元素[1,2,3,4,5]，dest数组元素[1,2,3,9,10]
    */
    private static void demo01(){
        //定义源数组
        int[] src = {1,2,3,4,5};
        int[] dest = {6,7,8,9,10};

        //使用System中的arrayCopy把源数组的前3个元素复制到目标数组的前三个位置上
        System.out.println("复制前："+Arrays.toString(dest));
        System.arraycopy(src,0,dest,0,3);
        System.out.println("复制后："+Arrays.toString(dest));
    }
}
