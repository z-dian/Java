package API2.Polymorphism.Demo02;
/*
在多态的代码中，访问成员方法的规则是：
    看new的是谁，就优先用谁，没有则向上找

注意：编译看左边，运行看右边。

对比一下：
成员变量：编译看左边，运行看左边。
成员方法：编译看左边，运行看右边。
 */
public class Demo02MultiMethod {
    public static void main(String[] args) {
        Fu obj =new Zi();

        obj.method();//父子都有，优先用子
        obj.methodFu();//子类没有，父类有，那么向上找到父类

        //编译看左，左边是父类，父类中没有method方法，所以编译报错。
//        obj.methodZi();//错误写法！
    }
}
