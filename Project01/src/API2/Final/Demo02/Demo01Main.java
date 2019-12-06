package API2.Final.Demo02;

/*
Java中有四种权限修饰符：
            public  >   protected   >   (default)   >   private

同一个类        yes         yes             yes             yes

同一个包        yes         yes             yes             NO

不同包子类       yes         yes             NO              NO

不同包非子类      yes         NO              NO              NO

注意事项：(default)并不是关键字“default"，而是根本不写。
 */
public class Demo01Main {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.method();
    }
}
