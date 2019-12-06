package API2.Object;

import java.util.Objects;

public class Demo03Objects {
    public static void main(String[] args) {
        String s1= "abc";
//        String s1 = null;
        String s2 = "abc";
//        boolean b = s1.equals(s2);  //NullPointerException是不能调用方法的，就会抛出空指针异常

        /*
        Objects类的equals方法：对两个对象进行比较，防止空指针异常
        public static boolean equals(API2.Object a, API2.Object b) {
            return (a == b) || (a != null && a.equals(b));
        }
         */
        boolean b2 = Objects.equals(s1,s2);
//        API2.System.out.println(b);
        System.out.println(b2);
    }
}
