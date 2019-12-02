package Interface.Demo02;

import java.lang.reflect.Method;

public interface MyInterface {
    public default void method(){
        System.out.println("接口默认方法");
    }
}
