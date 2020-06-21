package API2.Interface.Demo02;

public interface MyInterface {
    public default void method(){
        System.out.println("接口默认方法");
    }
}
