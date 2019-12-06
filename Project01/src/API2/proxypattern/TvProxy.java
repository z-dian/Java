package API2.proxypattern;


public class TvProxy implements Teaching {

    private Teaching teacher;

    public TvProxy(Teaching teacher) {
        this.teacher=teacher;
    }

    @Override
    public void teach() {
        // TODO Auto-generated method stub
        System.out.println("直播系统开启");

        teacher.teach();

        System.out.println("直播结束，记得写作业");
    }
}
