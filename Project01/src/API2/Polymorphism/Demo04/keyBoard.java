package API2.Polymorphism.Demo04;

public class keyBoard implements USB{

    @Override
    public void open() {
        System.out.println("键盘连接开启");
    }

    @Override
    public void close() {
        System.out.println("键盘连接断开");
    }

    public void knock(){
        System.out.println("敲打键盘...");
    }
}
