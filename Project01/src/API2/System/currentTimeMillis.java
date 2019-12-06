package API2.System;
/*
java.lang.System类中提供了大量的静态方法，可以获取与系统相关的信息或系统级操作，在System类的API文档中，常用的方法有：
    public static long currentTimeMillis()：返回以毫秒为单位的当前时间。
    public static void arraycopy(API2.Object src, int srcPos, API2.Object dest, int destPos, int length)：将数组中指定的数据拷贝到另一个数组中。
 */
public class currentTimeMillis {

    public static void main(String[] args) {
        demo01();
    }
    /*
        public static long currentTimeMillis()：返回以毫秒为单位的当前时间。
        用来测试程序的效率：
            验证for循环打印数字1-9999所需要使用的时间（毫秒）
     */
    private static void demo01(){
        //程序运行前获取一次毫秒值
        long s = System.currentTimeMillis();
        //执行for循环
        for (int i = 0; i < 9999; i++) {
            System.out.println(i);
        }
        //程序执行后，获取一次毫秒值
        long e = System.currentTimeMillis();

        System.out.println("程序共耗时："+(e-s)+"毫秒");
    }
}
