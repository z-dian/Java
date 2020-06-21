package API2.Polymorphism.Demo03;

/*
向上转型其实就是多态写法：
格式：父类名称 对象名 = new 子类名称();                       Animal animal = new Cat();
含义：右侧创建一个子类对象，把他当作父类来看待使用。            创建了一只猫，当作动物看待，没问题

向上转型一定是安全的，没问题的，正确的。但是也有一个弊端
对象一旦向上转型，那么就无法调用子类原本特有的内容。

解决方法：用对象的向下转型【还原】。
格式：子类名称 对象名 = (子类名称)父类对象;                   Animal animal = new Cat();//本来是猫，向上转型成为动物
含义：将父类对象，【还原】成本来的子类对象                     Cat cat =(Cat) animal;//本来是猫，已经被当作动物了，还原回来成为本来的猫

注意事项：
a、必须保证对象本来创建的时候，就是猫，才能向下转型成为猫。
b、如果对象创建的时候不是猫，现在非要向下转型成为猫，就会报错。ClassCastException

类似于：int num = (int) 10.0;//可以       int num = (int) 10.5;//不可以，精度损失

 */
public class Demo01Main {
    public static void main(String[] args) {
        //向上转型，就是父类引用指向子类对象
        Animal animal = new Cat();//本来创建的时候是一直猫
        animal.eat();//猫吃鱼

//        animal.catchMouse();//错误写法！

        //向下转型，进行“还原”动作
        Cat cat = (Cat) animal;
        cat.catchMouse();

        //下面是错误的向下转型
        //本来new的时候是一只猫，现在非要还原成狗
        //错误写法！编译不会报错，但是运行时会出现异常
        //java.lang.ClassCastException，类转换异常
        Dog dog =(Dog)animal;
    }
}
