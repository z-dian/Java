package API2.proxypattern;

public class TeacherWu implements Teaching {
    @Override
    public void teach() {
        System.out.println("同学们好，我是吴老师，我们开始上课！");
    }
}
