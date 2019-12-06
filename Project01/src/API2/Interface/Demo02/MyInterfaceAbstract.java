package API2.Interface.Demo02;

public abstract class MyInterfaceAbstract implements MyInterfaceA,MyInterfaceB{
    @Override
    public void methodA() {

    }

    //假如漏了一个抽象方法，那么实现类就必须是一个抽象类
 /*   @Override
    public void methodB() {

    }
*/
    @Override
    public void methodAbs() {

    }

    @Override
    public void methodDefault() {

    }
}
