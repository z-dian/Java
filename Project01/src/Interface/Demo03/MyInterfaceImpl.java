package Interface.Demo03;

public class MyInterfaceImpl implements MyInterface{
    @Override
    public void method() {
        System.out.println("来源于自己的method方法重写");
    }

    @Override
    public void methodA() {
        System.out.println("来源于InterfaceA的methodA方法重写");
    }

    @Override
    public void methodB() {
        System.out.println("来源于InterfaceB的methodB方法重写");
    }

    @Override
    public void methodCommon() {
        System.out.println("来源于A和B的methodCommon方法重写");
    }
}
