package API2.proxypattern;


public class Student {

    public static void main(String[] args) {

//      TeacherZhang teacherZhang = new TeacherZhang();

        TvProxy tvProxy = new TvProxy(new TeacherZhang());

        tvProxy.teach();
    }
}
