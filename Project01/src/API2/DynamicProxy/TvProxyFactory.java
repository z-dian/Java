package API2.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TvProxyFactory {
    private Object teacher;
    public TvProxyFactory(Object teacher) {
        this.teacher = teacher;
    }
	//利用反射机制生成一个目标对象的代理实例
	//public static API2.Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
	//参数说明:
	//ClassLoader loader  		指定当前目标对象的类加载器,获取加载器的方法固定
	//Class<?>[] interface		目标对象实现的接口类型，使用泛型方法确认类型
	//InvokationHandler 		事物处理，执行目标对象方法时，会触发事务处理方法，
	// 							会把当前执行的目标对象方法作为参数传入。
    public Object getInstance() {
        return Proxy.newProxyInstance(teacher.getClass().getClassLoader(),
                teacher.getClass().getInterfaces()
                , new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("动态代理直播授课开始！");
                        //反射调用目标对象的方法：teach()
                        Object invoke = method.invoke(teacher, args);
						System.out.println("动态代理直播授课结束！");
                        return invoke;
                    }
                }
                );
    }
}
