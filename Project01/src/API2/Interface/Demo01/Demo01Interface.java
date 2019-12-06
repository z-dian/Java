package API2.Interface.Demo01;

/*
接口就是多个类的公共规范。
接口时一种引用数据类型，最重要的内容就是其中的：抽象方法

定义：
public interface 接口名称{
    //接口内容
}
备注：换成了关键字interface之后，编译生成的字节码文件仍然是：.java-->.class

如果是Java7，那么接口可以包含：
1.常量
2.抽象方法
如果是Java8，那么接口还可以包含：
3.默认方法
4.静态方法
如果是Java9，那么接口还可以包含：
5.私有方法


 */
public class Demo01Interface {
    public static void main(String[] args) {
        //错误写法，不能直接new接口对象使用
//        MyInterfaceAbstract inter = new MyInterfaceAbstract() ;

        //创建实现类的对象使用
        MyInterfaceAbstractImpl impl = new MyInterfaceAbstractImpl();
        impl.methodAbs1();
        impl.methodAbs2();

    }
}

