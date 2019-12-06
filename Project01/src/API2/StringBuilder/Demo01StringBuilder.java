package API2.StringBuilder;

/*
    java.lang.StringBuilder类：字符串缓冲区，可以提高字符串的效率
    构造方法：
        public API2.StringBuilder()：构造一个空的StringBuilder容器，初始容量为16个字符。
        public API2.StringBuilder(String str)：构造一个StringBuilder容器，并将字符串添加进去。
 */
public class Demo01StringBuilder {
    public static void main(String[] args) {
        StringBuilder stu1 = new StringBuilder();
        System.out.println("stu1:" + stu1);
        StringBuilder stu2 = new StringBuilder("abc");
        System.out.println("stu2:" + stu2);

    }
}
