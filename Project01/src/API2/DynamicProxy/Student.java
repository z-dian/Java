package API2.DynamicProxy;

public class Student {

    public static void main(String[] args) {
        //创建目标对象
        Teaching teacher = new TeacherLiu();
        //给目标对象创建代理对象，返回类型强行转为Teaching接口类型
        Teaching proxyInstance = (Teaching) new TvProxyFactory(teacher).getInstance();
        //从结果看出内存中动态生成代理对象
        System.out.println("proxyInstance的类型是：" + proxyInstance.getClass());
        //调用代理实现方法
        proxyInstance.teach();
    }
}
